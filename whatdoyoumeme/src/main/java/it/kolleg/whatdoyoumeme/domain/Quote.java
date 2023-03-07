package it.kolleg.whatdoyoumeme.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Die Domainklasse Quote besitzt die Datenfelder ID, und Text.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quote {

    @Id
    @GeneratedValue
    private Long id;
    @Size(min=3)
    private String text;

    public Quote(String text){
        this.text = text;
    }

}
