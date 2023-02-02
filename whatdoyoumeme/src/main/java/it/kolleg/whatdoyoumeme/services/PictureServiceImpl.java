package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Picture;
import it.kolleg.whatdoyoumeme.exceptions.PictureNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService{

    private DbZugriffPicture dbZugriffPicture;

    public PictureServiceImpl(DbZugriffPicture dbZugriffPicture) {
        this.dbZugriffPicture = dbZugriffPicture;
    }

    @Override
    public Picture gibRandomPicture() throws PictureNotFound {
        return this.dbZugriffPicture.getRandomPicture();
    }

    @Override
    public void speicherePicture(Picture picture) {
        this.dbZugriffPicture.addPicture(picture);
    }

    @Override
    public List<Picture> gibAllePicture() {
        return this.dbZugriffPicture.getAllPicture();
    }

    @Override
    public Picture gibPictureMitId(Long id) throws PictureNotFound {
        return this.dbZugriffPicture.getPictureById(id);
    }

    @Override
    public void loeschePictureMitId(Long id) throws PictureNotFound {
        this.dbZugriffPicture.deletePictureById(id);
    }

    @Override
    public void aktualisierePicture(Picture picture) {
        this.dbZugriffPicture.updatePicture(picture);
    }
}
