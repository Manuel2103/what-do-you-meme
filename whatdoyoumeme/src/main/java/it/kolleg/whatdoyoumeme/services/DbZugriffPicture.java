package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Picture;
import it.kolleg.whatdoyoumeme.exceptions.PictureNotFound;

import java.util.List;

public interface DbZugriffPicture {
    public Picture getRandomPicture() throws PictureNotFound;
    public void addPicture(Picture picture);
    public List<Picture> getAllPicture();
    public Picture getPictureById(Long id) throws PictureNotFound;
    public void deletePictureById(Long id) throws PictureNotFound;
    public void updatePicture(Picture picture);
}
