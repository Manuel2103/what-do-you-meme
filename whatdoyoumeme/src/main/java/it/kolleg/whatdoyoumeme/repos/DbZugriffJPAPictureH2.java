package it.kolleg.whatdoyoumeme.repos;

import it.kolleg.whatdoyoumeme.domain.Picture;
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
    public Picture getRandomPicture() {

        Random random = new Random();
        Long randomID = random.nextLong(1,this.pictureJPARepo.count()+1);
        return this.pictureJPARepo.findById(randomID).get();
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
    public Picture getPictureById(Long id) {
        //Optional check heast
        return this.pictureJPARepo.findById(id).get();
    }

    @Override
    public void deletePictureById(Long id) {
        this.pictureJPARepo.deleteById(id);
    }

    @Override
    public void updatePicture(Picture picture) {
        this.pictureJPARepo.save(picture);

    }
}
