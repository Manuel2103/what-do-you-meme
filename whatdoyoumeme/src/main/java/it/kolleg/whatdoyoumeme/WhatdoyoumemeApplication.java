package it.kolleg.whatdoyoumeme;

import it.kolleg.whatdoyoumeme.domain.Kategorie;
import it.kolleg.whatdoyoumeme.domain.Meme;
import it.kolleg.whatdoyoumeme.domain.Picture;
import it.kolleg.whatdoyoumeme.domain.Quote;
import it.kolleg.whatdoyoumeme.services.DbZugriffMeme;
import it.kolleg.whatdoyoumeme.services.DbZugriffPicture;
import it.kolleg.whatdoyoumeme.services.DbZugriffQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class WhatdoyoumemeApplication implements ApplicationRunner {

    @Autowired
    DbZugriffQuote dbZugriffQuote;
    @Autowired
    DbZugriffPicture dbZugriffPicture;
    @Autowired
    DbZugriffMeme dbZugriffMeme;
    public static void main(String[] args) {

        SpringApplication.run(WhatdoyoumemeApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Dummy-Daten
        Quote quote1 = new Quote("When the newest member of the squad starts roasting u sooner than expected");
        Quote quote2 = new Quote("When ur shampoo says 'Damage Control' but deep down ur still broken");
        Quote quote3 = new Quote("When you eat peanut butter too fast and regret ever being born");
        dbZugriffQuote.addQuote(quote1);
        dbZugriffQuote.addQuote(quote2);
        dbZugriffQuote.addQuote(quote3);
        dbZugriffQuote.addQuote(new Quote("When you think you've been charging your phone for he last 3 hours but it wasn't plugged in"));
        dbZugriffQuote.addQuote(new Quote("When you say 'bye' to someone then both walk in the same direction"));
        dbZugriffQuote.addQuote(new Quote("The face you make while helping your son look for his Halloween candy you ate last night"));
        dbZugriffQuote.addQuote(new Quote("When you're all ready to go out but then realize you have no money, no plans, and no friends"));
        dbZugriffQuote.addQuote(new Quote("When ur drowning in life's responsibilities but don't give a single fuck"));
        dbZugriffQuote.addQuote(new Quote("When you dip you biscuit in your cuppa and it breaks off"));
        dbZugriffQuote.addQuote(new Quote("When they come back from the bathroom and see that their phone is disabled for 196 hours"));

        Picture picture1 = new Picture("https://api.memegen.link/images/ackbar.png", "Ackbar", Kategorie.ANIMALS);
        Picture picture2 = new Picture("https://api.memegen.link/images/afraid.png", "Afraid", Kategorie.ANIMALS);
        Picture picture3 = new Picture("https://api.memegen.link/images/agnes.png", "Agnes", Kategorie.ANIMALS);

        dbZugriffPicture.addPicture(picture1);
        dbZugriffPicture.addPicture(picture2);
        dbZugriffPicture.addPicture(picture3);
        dbZugriffPicture.addPicture(new Picture("https://api.memegen.link/images/bihw.png", "Bihw", Kategorie.ANIMALS));
        dbZugriffPicture.addPicture(new Picture("https://api.memegen.link/images/cmm.png", "change my mind", Kategorie.ANIMALS));
        dbZugriffPicture.addPicture(new Picture("https://api.memegen.link/images/disastergirl.png", "disaster girl", Kategorie.ANIMALS));
        dbZugriffPicture.addPicture(new Picture("https://api.memegen.link/images/ive.png", "Ive", Kategorie.ANIMALS));

        dbZugriffMeme.addMeme(new Meme(Date.valueOf("2023-01-22"), 2, picture2, quote1));
        dbZugriffMeme.addMeme(new Meme(Date.valueOf("2022-12-28"), 3, picture1, quote3));
        dbZugriffMeme.addMeme(new Meme(Date.valueOf("2022-11-15"), 5, picture3, quote2));
        dbZugriffMeme.addMeme(new Meme(picture1, quote1));


    }


}
