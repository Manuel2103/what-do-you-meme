package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Picture;
import it.kolleg.whatdoyoumeme.exceptions.PictureNotFound;

import java.util.List;

public interface PictureService {

    public Picture gibRandomPicture() throws PictureNotFound;
    public void speicherePicture(Picture picture);
    public List<Picture> gibAllePicture();
    public Picture gibPictureMitId(Long id) throws PictureNotFound;
    public void loeschePictureMitId(Long id) throws PictureNotFound;
    public void aktualisierePicture(Picture picture);
}
