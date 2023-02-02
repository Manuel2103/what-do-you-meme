package it.kolleg.whatdoyoumeme.exceptions;

public class QuoteNotFound extends Exception{

    public QuoteNotFound() {
        super("Quote nicht gefunden!");
    }
}
