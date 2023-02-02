package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Quote;
import it.kolleg.whatdoyoumeme.exceptions.QuoteNotFound;

import java.util.List;

public interface DbZugriffQuote {
    public void addQuote(Quote quote);
    public List<Quote> getAllQuotes();
    public Quote getQuoteById(Long id) throws QuoteNotFound;
    public void deleteQuoteById(Long id) throws QuoteNotFound;
    public void updateQuote(Quote quote);
    public List<Quote> get4RandomQuotes() throws QuoteNotFound;
}
