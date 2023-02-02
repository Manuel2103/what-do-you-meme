package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Meme;

import java.sql.Date;
import java.util.List;

public interface MemeService {

    public void speichereMeme(Meme meme);
    public List<Meme> gibAlleMemes();
    public Meme gibMemeMitID(Long id);
    public void loescheMemeMitID(Long id);
    public void aktualisiereMeme(Meme meme);

    public List<Meme> letzten5Memes();
    public void setzeLike(Long id);
    public Meme gibLetztesMeme(Date date);
    public List<Meme> gibAlleMemesNach(Date date);
    public Meme gibFavoriteMeme();
}
