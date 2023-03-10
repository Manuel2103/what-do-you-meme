package it.kolleg.whatdoyoumeme.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Meme {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private Date date;
    private long likes;
    @ManyToOne(fetch = FetchType.EAGER)
    private Picture picture;
    @ManyToOne(fetch = FetchType.EAGER)
    private Quote quote;

    public Meme(Date date, long likes, Picture picture, Quote quote){
        this.date = date;
        this.likes = likes;
        this.picture = picture;
        this.quote = quote;
    }
}
