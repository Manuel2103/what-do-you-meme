package it.kolleg.whatdoyoumeme.repos;

import it.kolleg.whatdoyoumeme.domain.Quote;
import it.kolleg.whatdoyoumeme.exceptions.QuoteNotFound;
import it.kolleg.whatdoyoumeme.services.DbZugriffQuote;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class DbZugriffJPAQuoteH2 implements DbZugriffQuote {

    private QuoteJPARepo quoteJPARepo;
    //Konstruktor injektion
    public DbZugriffJPAQuoteH2(QuoteJPARepo quoteJPARepo) {
        this.quoteJPARepo = quoteJPARepo;
    }

    @Override
    public void addQuote(Quote quote) {
        this.quoteJPARepo.save(quote);
    }

    @Override
    public List<Quote> getAllQuotes() {
        return this.quoteJPARepo.findAll();
    }

    @Override
    public Quote getQuoteById(Long id) throws QuoteNotFound {
        try {
            Optional<Quote> optionalQuote = this.quoteJPARepo.findById(id);
            return optionalQuote.get();
        } catch (Exception e) {
            throw new QuoteNotFound();
        }
    }
    @Override
    public void deleteQuoteById(Long id) throws QuoteNotFound {
        try {
            this.quoteJPARepo.deleteById(id);

        }catch (Exception e){
            throw new QuoteNotFound();
        }


    }
    @Override
    public void updateQuote(Quote quote) {
        this.quoteJPARepo.save(quote);
    }

    @Override
    public List<Quote> get4RandomQuotes() throws QuoteNotFound {
        long countquotes = this.quoteJPARepo.count();
        Random random = new Random();
        long randomID;
        Optional<Quote> optionalQuote;
        List<Quote> quoteList = new ArrayList<>();
        try {
            int i = 0;
            ArrayList<Long> quotelistids = new ArrayList<>();
            boolean ispresent;
            while (i<4){
                ispresent = false;
                randomID = random.nextLong(1, countquotes+1);
                for(Long quotelistid:quotelistids){
                    if(randomID==quotelistid){
                        ispresent = true;
                    }
                }
                if(!ispresent){
                    optionalQuote = this.quoteJPARepo.findById(randomID);
                    if(optionalQuote.isPresent()){
                        quoteList.add(optionalQuote.get());
                        quotelistids.add(optionalQuote.get().getId());
                        i++;
                    }
                }

            }
            return quoteList;
        }catch (Exception e){
            throw new QuoteNotFound();
        }


    }
}
