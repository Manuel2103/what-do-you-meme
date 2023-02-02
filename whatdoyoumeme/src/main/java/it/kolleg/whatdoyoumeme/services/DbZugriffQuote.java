package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Quote;

import java.util.List;

public interface DbZugriffQuote {
    public void addQuote(Quote quote);
    public List<Quote> getAllQuotes();
    public Quote getQuoteById(Long id);
    public void deleteQuoteById(Long id);
    public void updateQuote(Quote quote);
    public List<Quote> get4RandomQuotes();
}
