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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class WhatdoyoumemeApplication {

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

		Quote quote1 = new Quote("");
		Quote quote2 = new Quote("");
		Quote quote3 = new Quote("");
		dbZugriffQuote.addQuote(quote1);
		dbZugriffQuote.addQuote(quote2);
		dbZugriffQuote.addQuote(quote3);
		dbZugriffQuote.addQuote(new Quote(""));
		dbZugriffQuote.addQuote(new Quote(""));
		dbZugriffQuote.addQuote(new Quote(""));
		dbZugriffQuote.addQuote(new Quote(""));
		dbZugriffQuote.addQuote(new Quote(""));
		dbZugriffQuote.addQuote(new Quote(""));
		dbZugriffQuote.addQuote(new Quote(""));

		Picture picture1 = new Picture("", "", Kategorie.ANIMALS);
		Picture picture2 = new Picture("", "", Kategorie.ANIMALS);
		Picture picture3 = new Picture("", "", Kategorie.ANIMALS);

		dbZugriffPicture.addPicture(picture1);
		dbZugriffPicture.addPicture(picture2);
		dbZugriffPicture.addPicture(picture3);
		dbZugriffPicture.addPicture(new Picture("", "", Kategorie.ANIMALS));
		dbZugriffPicture.addPicture(new Picture("", "", Kategorie.ANIMALS));

		//TODO Date Format
		dbZugriffMeme.addMeme(new Meme(new Date(), 2, quote1, picture2 ));
		dbZugriffMeme.addMeme(new Meme(new Date(), 3, quote3, picture1 ));
		dbZugriffMeme.addMeme(new Meme(new Date(), 5, quote2, picture3 ));


	}


}
