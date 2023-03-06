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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

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
    @GetMapping("web/deletememe/{id}")
    public View deleteMeme(@PathVariable long id) throws MemeNotFound {
        memeService.loescheMemeMitID(id);
        return new RedirectView("/web/allmemes");
    }
    @GetMapping("web/allpictures")
    public ModelAndView allPictures(){
        List<Picture> pictures = pictureService.gibAllePicture();
        return new ModelAndView("allpictures", "pictures", pictures);
    }
    @GetMapping("web/addmeme")
    public ModelAndView addMemeForm() throws QuoteNotFound, PictureNotFound {
        List<Quote> randomQuotes = quoteService.gib4RandomQuotes();
        Picture randomPicture = pictureService.gibRandomPicture();
        ModelAndView modelAndView = new ModelAndView("addmeme");
        modelAndView.addObject("quotes", randomQuotes);
        modelAndView.addObject("randomPicture", randomPicture);
        modelAndView.addObject("meme", new Meme());
        return modelAndView;
    }
    @PostMapping("web/addmeme")
    public String addMeme(@Valid @ModelAttribute("meme") Meme meme, BindingResult bindingResult, @RequestParam Map<String, String> picturequote) throws QuoteNotFound, PictureNotFound {
        //System.out.println(picturequote.toString());
        meme.setPicture(pictureService.gibPictureMitId(Long.valueOf(picturequote.get("randomPicture"))));
        meme.setQuote(quoteService.gibQuoteMitID(Long.valueOf(picturequote.get("randomQuote"))));
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().toString());
            return "addmeme";
        }else{
            memeService.speichereMeme(meme);
            return "redirect:/web/allmemes";
        }
    }
    @GetMapping("web/addpicture")
    public ModelAndView addPictureForm(){
        return new ModelAndView("addpicture", "picture", new Picture());
    }

    @PostMapping("web/addpicture")
    public String addPicture(@Valid @ModelAttribute("picture") Picture picture, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addpicture";
        }else{
            pictureService.speicherePicture(picture);
            return "redirect:/web/allpictures";
        }
    }
    @GetMapping("web/changepicture/{id}")
    public ModelAndView changePictureForm(@PathVariable Long id) throws PictureNotFound {
        return new ModelAndView("changepicture", "picture", pictureService.gibPictureMitId(id));
    }
    @PostMapping("web/changepicture")
    public String changePicture(@Valid @ModelAttribute("picture") Picture picture, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "changepicture";
        }else{
            pictureService.aktualisierePicture(picture);
            return "redirect:/web/allpictures";
        }
    }
    @GetMapping("web/deletepicture/{id}")
    public View deletePicture(@PathVariable long id) throws PictureNotFound {
        pictureService.loeschePictureMitId(id);
        return new RedirectView("/web/allpictures");
    }

    @GetMapping("web/addquote")
    public ModelAndView addQuoteForm(){
        return new ModelAndView("addquote", "quote",new Quote());
    }

    @PostMapping("web/addquote")
    public String addQuote(@Valid @ModelAttribute("quote") Quote quote, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "addquote";
        }else{
            quoteService.speichereQuote(quote);
            return "redirect:/web/allquotes";
        }
    }
    @GetMapping("web/updatequote/{id}")
    public ModelAndView updateQuoteForm(@PathVariable long id) throws QuoteNotFound {
        return new ModelAndView("updatequote", "quote", quoteService.gibQuoteMitID(id));
    }

    @PostMapping("web/updatequote")
    public String updateQuote(@Valid @ModelAttribute("quote") Quote quote, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "updatequote";
        }else {
            quoteService.aktualisiereQuote(quote);
            return "redirect:/web/allquotes";
        }
    }
    @GetMapping("web/deletequote/{id}")
    public String deleteQuote(@PathVariable long id) throws QuoteNotFound {
        quoteService.loescheQuote(id);
        return "redirect:/web/allquotes";
    }





}
