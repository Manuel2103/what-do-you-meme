package it.kolleg.whatdoyoumeme.repos;

import it.kolleg.whatdoyoumeme.domain.Picture;
import it.kolleg.whatdoyoumeme.exceptions.PictureNotFound;
import it.kolleg.whatdoyoumeme.services.DbZugriffPicture;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class DbZugriffJPAPictureH2 implements DbZugriffPicture {

    private PictureJPARepo pictureJPARepo;

    public DbZugriffJPAPictureH2(PictureJPARepo pictureJPARepo) {
        this.pictureJPARepo = pictureJPARepo;
    }

    @Override
    public Picture getRandomPicture() throws PictureNotFound {

        Random random = new Random();
        try {
            Long randomID = random.nextLong(1,this.pictureJPARepo.count()+1);
            return this.pictureJPARepo.findById(randomID).get();
        }catch (Exception e){
            throw new PictureNotFound();
        }

    }

    @Override
    public void addPicture(Picture picture) {
        this.pictureJPARepo.save(picture);

    }

    @Override
    public List<Picture> getAllPicture() {

        return this.pictureJPARepo.findAll();
    }

    @Override
    public Picture getPictureById(Long id) throws PictureNotFound {
        try {
            return this.pictureJPARepo.findById(id).get();
        }catch (Exception e){
            throw new PictureNotFound();
        }

    }

    @Override
    public void deletePictureById(Long id) throws PictureNotFound {
        try {
            this.pictureJPARepo.deleteById(id);

        }catch (Exception e){
            throw new PictureNotFound();
        }

    }

    @Override
    public void updatePicture(Picture picture) {
        this.pictureJPARepo.save(picture);

    }
}
