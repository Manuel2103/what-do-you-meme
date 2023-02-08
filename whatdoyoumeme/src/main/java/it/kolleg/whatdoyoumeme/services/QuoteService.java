package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Quote;
import it.kolleg.whatdoyoumeme.exceptions.QuoteNotFound;

import java.util.List;

public interface QuoteService {

    public void speichereQuote(Quote quote);
    public List<Quote> alleQuotes();
    public Quote gibQuoteMitID(Long id) throws QuoteNotFound;
    public void loescheQuote(Long id) throws QuoteNotFound;
    public void aktualisiereQuote(Quote quote);
    public List<Quote> gib4RandomQuotes() throws QuoteNotFound;


}
