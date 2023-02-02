package it.kolleg.whatdoyoumeme.repos;

import it.kolleg.whatdoyoumeme.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureJPARepo extends JpaRepository<Picture, Long> {

}
