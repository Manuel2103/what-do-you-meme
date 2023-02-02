package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Picture;

import java.util.List;

public interface PictureService {

    public Picture gibRandomPicture();
    public void speicherePicture(Picture picture);
    public List<Picture> gibAllePicture();
    public Picture gibPictureMitId(Long id);
    public void loeschePictureMitId(Long id);
    public void aktualisierePicture(Picture picture);
}
