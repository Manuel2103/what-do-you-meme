package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Quote;
import it.kolleg.whatdoyoumeme.exceptions.QuoteNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService{

    private DbZugriffQuote dbZugriffQuote;

    public QuoteServiceImpl(DbZugriffQuote dbZugriffQuote) {
        this.dbZugriffQuote = dbZugriffQuote;
    }

    @Override
    public void speichereQuote(Quote quote) {
        this.dbZugriffQuote.addQuote(quote);
    }

    @Override
    public List<Quote> alleQuotes() {
        return this.dbZugriffQuote.getAllQuotes();
    }

    @Override
    public Quote gibQuoteMitID(Long id) throws QuoteNotFound {
        return this.dbZugriffQuote.getQuoteById(id);
    }

    @Override
    public void loescheQuote(Long id) throws QuoteNotFound {
        this.dbZugriffQuote.deleteQuoteById(id);
    }

    @Override
    public void aktualisiereQuote(Quote quote) {
        this.dbZugriffQuote.updateQuote(quote);
    }

    @Override
    public List<Quote> gib4RandomQuotes() {
        return this.dbZugriffQuote.get4RandomQuotes();
    }
}
