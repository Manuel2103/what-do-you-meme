package it.kolleg.whatdoyoumeme.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Picture {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String url;

    @Size(min=3)
    private String name;

    @NotNull
    private Kategorie kategorie;

    public Picture(String url, String name, Kategorie kategorie){
        this.url = url;
        this.name = name;
        this.kategorie = kategorie;
    }

}
