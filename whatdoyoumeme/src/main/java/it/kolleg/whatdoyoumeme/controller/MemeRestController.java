package it.kolleg.whatdoyoumeme.controller;


import it.kolleg.whatdoyoumeme.domain.Meme;
import it.kolleg.whatdoyoumeme.domain.Picture;
import it.kolleg.whatdoyoumeme.domain.Quote;
import it.kolleg.whatdoyoumeme.exceptions.*;
import it.kolleg.whatdoyoumeme.services.MemeService;
import it.kolleg.whatdoyoumeme.services.PictureService;
import it.kolleg.whatdoyoumeme.services.QuoteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/whatdoyoumeme")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MemeRestController {

    private MemeService memeService;
    private PictureService pictureService;
    private QuoteService quoteService;

    public MemeRestController(MemeService memeService, PictureService pictureService, QuoteService quoteService) {
        this.memeService = memeService;
        this.pictureService = pictureService;
        this.quoteService = quoteService;
    }

    @GetMapping("/allmemes")
    public ResponseEntity<List<Meme>> getAllMemes(){
        return ResponseEntity.ok(this.memeService.gibAlleMemes());
    }

    @GetMapping("/memes/{id}")
    public ResponseEntity<Meme> getMemeById(@PathVariable Long id) throws MemeNotFound {
        return ResponseEntity.ok(this.memeService.gibMemeMitID(id));
    }

    @PostMapping("/memes/{pid}/{qid}")
    public ResponseEntity<String> addMeme(@PathVariable Long pid, @PathVariable Long qid, BindingResult bindingResult) throws FormValidierungFehlgeschlagen {
        FormValildierungExceptionDTO formValildierungExceptionDTO = new FormValildierungExceptionDTO("2000");
        if (bindingResult.hasErrors()){
            for (ObjectError error : bindingResult.getAllErrors()){
                formValildierungExceptionDTO.addFormValidationError(((FieldError)error).getField(), error.getDefaultMessage());
            }
            throw new FormValidierungFehlgeschlagen(formValildierungExceptionDTO);
        } else {

            //this.memeService.speichereMeme(new Meme());
            return ResponseEntity.ok("Meme erfolgreich hinzugefügt");
        }
    }

    @GetMapping("/pictures/random1")
    public ResponseEntity<Picture> getRandomPicture() throws PictureNotFound {
        return ResponseEntity.ok(this.pictureService.gibRandomPicture());
    }

    @GetMapping("/pictures/{id}")
    public ResponseEntity<Picture> getPictureByID(@PathVariable Long id) throws PictureNotFound {
        return ResponseEntity.ok(this.pictureService.gibPictureMitId(id));
    }

    @GetMapping("/quotes/random4")
    public ResponseEntity<List<Quote>> get4RandomQuotes() throws QuoteNotFound {
        return ResponseEntity.ok(this.quoteService.gib4RandomQuotes());
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> getQuoteByID(@PathVariable Long id) throws QuoteNotFound {
        return ResponseEntity.ok(this.quoteService.gibQuoteMitID(id));
    }

    @GetMapping("/meme/like/{id}")
    public void addLikeToMeme(@PathVariable Long id) throws MemeNotFound {
        this.memeService.setzeLike(id);
    }



}
