package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Meme;
import it.kolleg.whatdoyoumeme.exceptions.MemeNotFound;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MemeServiceImpl implements MemeService{

    private DbZugriffMeme dbZugriffMeme;

    @Override
    public void speichereMeme(Meme meme) {
        this.dbZugriffMeme.addMeme(meme);
    }

    @Override
    public List<Meme> gibAlleMemes() {
        return this.dbZugriffMeme.getAllMemes();
    }

    @Override
    public Meme gibMemeMitID(Long id) throws MemeNotFound {
        return this.dbZugriffMeme.getMemeByID(id);
    }

    @Override
    public void loescheMemeMitID(Long id) throws MemeNotFound {
        this.dbZugriffMeme.deleteMemeByID(id);
    }

    @Override
    public void aktualisiereMeme(Meme meme) {
        this.dbZugriffMeme.updateMeme(meme);
    }

    @Override
    public List<Meme> letzten5Memes() {
        return this.dbZugriffMeme.last5Memes();
    }

    @Override
    public void setzeLike(Long id) {
        this.dbZugriffMeme.addLike(id);
    }

    @Override
    public Meme gibLetztesMeme(Date date) {
        return this.dbZugriffMeme.getlatestMeme(date);
    }

    @Override
    public List<Meme> gibAlleMemesNach(Date date) {
        return this.dbZugriffMeme.getAllMemesAfter(date);
    }

    @Override
    public Meme gibFavoriteMeme() throws MemeNotFound {
        return this.dbZugriffMeme.getFavMeme();
    }
}
