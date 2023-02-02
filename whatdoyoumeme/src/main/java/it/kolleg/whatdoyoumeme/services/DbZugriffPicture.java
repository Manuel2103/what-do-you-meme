package it.kolleg.whatdoyoumeme.services;

import it.kolleg.whatdoyoumeme.domain.Picture;

import java.util.List;

public interface DbZugriffPicture {
    public Picture getRandomPicture();
    public void addPicture(Picture picture);
    public List<Picture> getAllPicture();
    public Picture getPictureById(Long id);
    public void deletePictureById(Long id);
    public void updatePicture(Picture picture);
}
