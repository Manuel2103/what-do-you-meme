package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Quote;

import java.util.List;

public interface QuoteService {

    public void speichereQuote(Quote quote);
    public List<Quote> alleQuotes();
    public Quote gibQuoteMitID(Long id);
    public void loescheQuote(Long id);
    public void aktualisiereQuote(Quote quote);
    public List<Quote> gib4RandomQuotes();


}
