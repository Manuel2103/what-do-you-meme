package it.kolleg.whatdoyoumeme.controller;


import it.kolleg.whatdoyoumeme.domain.Kategorie;
import it.kolleg.whatdoyoumeme.domain.Meme;
import it.kolleg.whatdoyoumeme.domain.Picture;
import it.kolleg.whatdoyoumeme.domain.Quote;
import it.kolleg.whatdoyoumeme.exceptions.*;
import it.kolleg.whatdoyoumeme.services.MemeService;
import it.kolleg.whatdoyoumeme.services.PictureService;
import it.kolleg.whatdoyoumeme.services.QuoteService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @GetMapping("/kategories")
    public ResponseEntity<List<Kategorie>> kategories() {
        return new ResponseEntity<List<Kategorie>>(Arrays.asList(Kategorie.values()), HttpStatus.OK);
    }

    @GetMapping("/allmemes")
    public ResponseEntity<List<Meme>> getAllMemes(){
        return ResponseEntity.ok(this.memeService.gibAlleMemes());
    }

    @GetMapping("/memes/{id}")
    public ResponseEntity<Meme> getMemeById(@PathVariable Long id) throws MemeNotFound {
        return ResponseEntity.ok(this.memeService.gibMemeMitID(id));
    }

    @GetMapping("/memes/{pid}/{qid}")
    public ResponseEntity<String> addMeme(@PathVariable Long pid, @PathVariable Long qid) throws PictureNotFound, QuoteNotFound {
        System.out.println("PID:"+pid);
        System.out.println("QID:"+qid);

            this.memeService.speichereMeme(new Meme(this.pictureService.gibPictureMitId(pid),this.quoteService.gibQuoteMitID(qid)));
            return ResponseEntity.ok("Meme erfolgreich hinzugefügt");
    }

    @GetMapping("/meme/like/{id}")
    public void addLikeToMeme(@PathVariable Long id) throws MemeNotFound {
        this.memeService.setzeLike(id);
    }

    @GetMapping("/allpictures")
    public ResponseEntity<List<Picture>> getAllPictures(){
        return ResponseEntity.ok(this.pictureService.gibAllePicture());
    }

    @GetMapping("/pictures/random1")
    public ResponseEntity<Picture> getRandomPicture() throws PictureNotFound {
        return ResponseEntity.ok(this.pictureService.gibRandomPicture());
    }

    @GetMapping("/pictures/{id}")
    public ResponseEntity<Picture> getPictureByID(@PathVariable Long id) throws PictureNotFound {
        return ResponseEntity.ok(this.pictureService.gibPictureMitId(id));
    }

    @PutMapping("/pictures")
    public HttpStatus updatePicture(@Valid @RequestBody Picture picture, BindingResult bindingResult) throws FormValidierungFehlgeschlagen, PictureNotFound {
        FormValildierungExceptionDTO formValildierungExceptionDTO = new FormValildierungExceptionDTO("1000");
        if (picture.getId() == null)
            throw new PictureNotFound();

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                formValildierungExceptionDTO.addFormValidationError(((FieldError) error).getField(), error.getDefaultMessage());
            }
            throw new FormValidierungFehlgeschlagen(formValildierungExceptionDTO);
        } else {
            this.pictureService.aktualisierePicture(picture);
            return HttpStatus.OK;
        }
    }

    @GetMapping("/allquotes")
    public ResponseEntity<List<Quote>> getAllQuotes(){
        return ResponseEntity.ok(this.quoteService.alleQuotes());
    }
    @GetMapping("/quotes/random4")
    public ResponseEntity<List<Quote>> get4RandomQuotes() throws QuoteNotFound {
        return ResponseEntity.ok(this.quoteService.gib4RandomQuotes());
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> getQuoteByID(@PathVariable Long id) throws QuoteNotFound {
        return ResponseEntity.ok(this.quoteService.gibQuoteMitID(id));
    }

    @DeleteMapping("/deletequote/{id}")
    public HttpStatus deleteQuoteById(@PathVariable Long id) throws QuoteNotFound {
        try {
            this.quoteService.loescheQuote(id);
            return HttpStatus.OK;
        } catch (QuoteNotFound quoteNotFound){
            return HttpStatus.NOT_FOUND;
        } catch (Exception e){
            return HttpStatus.NOT_ACCEPTABLE;
        }
    }





}
