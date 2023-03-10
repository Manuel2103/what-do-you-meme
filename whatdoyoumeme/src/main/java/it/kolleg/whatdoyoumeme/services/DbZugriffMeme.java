package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Meme;
import it.kolleg.whatdoyoumeme.exceptions.MemeNotFound;

import java.sql.Date;
import java.util.List;

public interface DbZugriffMeme {

    public void addMeme(Meme meme);
    public List<Meme> getAllMemes();
    public Meme getMemeByID(Long id) throws MemeNotFound;
    public void deleteMemeByID(Long id) throws MemeNotFound;
    public void updateMeme(Meme meme);

    public List<Meme> last5Memes();
    public void addLike(Long id);
    public Meme getlatestMeme(Date date);
    public List<Meme> getAllMemesAfter(Date date);
    public Meme getFavMeme() throws MemeNotFound;
}
