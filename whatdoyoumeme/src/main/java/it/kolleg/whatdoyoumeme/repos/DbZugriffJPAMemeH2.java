package it.kolleg.whatdoyoumeme.repos;

import it.kolleg.whatdoyoumeme.domain.Meme;
import it.kolleg.whatdoyoumeme.services.DbZugriffMeme;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public class DbZugriffJPAMemeH2 implements DbZugriffMeme {

    private MemeJPARepo memeJPARepo;

    public DbZugriffJPAMemeH2(MemeJPARepo memeJPARepo) {
        this.memeJPARepo = memeJPARepo;
    }

    @Override
    public void addMeme(Meme meme) {
        this.memeJPARepo.save(meme);
    }

    @Override
    public List<Meme> getAllMemes() {
        return this.memeJPARepo.findAll();
    }

    @Override
    public Meme getMemeByID(Long id) {
        return this.memeJPARepo.findById(id).get();
    }

    @Override
    public void deleteMemeByID(Long id) {
        this.memeJPARepo.deleteById(id);
    }

    @Override
    public void updateMeme(Meme meme) {
        this.memeJPARepo.save(meme);
    }

    @Override
    public List<Meme> last5Memes() {

        return null;
    }

    @Override
    public void addLike(Long id) {
        Optional<Meme> optionalMeme = this.memeJPARepo.findById(id);
        Meme meme = optionalMeme.get();
        meme.setLikes(meme.getLikes()+1);
        this.memeJPARepo.save(meme);
    }

    @Override
    public Meme getlatestMeme(Date date) {
        //get last entry
        return null;
    }

    @Override
    public List<Meme> getAllMemesAfter(Date date) {
        return this.memeJPARepo.getMemesByDateAfter(date);
    }

    @Override
    public Meme getFavMeme() {
        List<Meme> memeList = this.memeJPARepo.findAll();
        Meme bestMeme = memeList.get(0);

        for (int i = 1; i < memeList.size(); i++) {
            if(bestMeme.getLikes() == memeList.get(i).getLikes()){
                if(bestMeme.getDate().after(memeList.get(i).getDate())){
                    bestMeme = memeList.get(i);
                }
            } else if(bestMeme.getLikes() < memeList.get(i).getLikes()) {
                bestMeme = memeList.get(i);
            }
        }
        return bestMeme;
    }
}
