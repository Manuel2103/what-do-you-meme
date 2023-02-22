package it.kolleg.whatdoyoumeme.controller;

import it.kolleg.whatdoyoumeme.domain.Meme;
import it.kolleg.whatdoyoumeme.domain.Picture;
import it.kolleg.whatdoyoumeme.domain.Quote;
import it.kolleg.whatdoyoumeme.exceptions.MemeNotFound;
import it.kolleg.whatdoyoumeme.exceptions.PictureNotFound;
import it.kolleg.whatdoyoumeme.exceptions.QuoteNotFound;
import it.kolleg.whatdoyoumeme.services.MemeService;
import it.kolleg.whatdoyoumeme.services.PictureService;
import it.kolleg.whatdoyoumeme.services.QuoteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MyThymeleafController {
    QuoteService quoteService;
    MemeService memeService;
    PictureService pictureService;

    public MyThymeleafController(QuoteService quoteService, MemeService memeService, PictureService pictureService) {
        this.quoteService = quoteService;
        this.memeService = memeService;
        this.pictureService = pictureService;
    }

    @GetMapping("web/allquotes")
    public ModelAndView allQuotes(){
        List<Quote> quoteList = quoteService.alleQuotes();
        return new ModelAndView("allquotes", "quotes", quoteList);
    }
    @GetMapping("web/allmemes")
    public ModelAndView allMemes(){
        List<Meme> memeList = memeService.gibAlleMemes();
        return new ModelAndView("allmemes", "memes", memeList);
    }

    @GetMapping("web/addlike/{id}")
    public View addLike(@PathVariable long id){
        memeService.setzeLike(id);
        return new RedirectView("/web/allmemes");
    }

    @GetMapping("web/allpictures")
    public ModelAndView allPictures(){
        List<Picture> pictures = pictureService.gibAllePicture();
        return new ModelAndView("allpictures", "pictures", pictures);
    }
    @GetMapping("web/addmeme")
    public ModelAndView addMeme() throws QuoteNotFound, PictureNotFound {
        List<Quote> randomQuotes = quoteService.gib4RandomQuotes();
        Picture randomPicture = pictureService.gibRandomPicture();
        ModelAndView modelAndView = new ModelAndView("addmeme");
        modelAndView.addObject("quotes", randomQuotes);
        modelAndView.addObject("picture", randomPicture);
        return modelAndView;
    }

}
