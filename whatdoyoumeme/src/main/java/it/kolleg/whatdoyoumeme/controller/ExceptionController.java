package it.kolleg.whatdoyoumeme.controller;

import it.kolleg.whatdoyoumeme.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.FormatFlagsConversionMismatchException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MemeNotFound.class)
    public ResponseEntity<ExceptionDTO> memeNichtGefunden(MemeNotFound memeNotFound){
        return new ResponseEntity<>(new ExceptionDTO("1000", memeNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PictureNotFound.class)
    public ResponseEntity<ExceptionDTO> bildNichtGefunden(PictureNotFound pictureNotFound){
        return new ResponseEntity<>(new ExceptionDTO("1010", pictureNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(QuoteNotFound.class)
    public ResponseEntity<ExceptionDTO> zitatNichtGefunden(QuoteNotFound quoteNotFound){
        return new ResponseEntity<>(new ExceptionDTO("1020", quoteNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FormValidierungFehlgeschlagen.class)
    public ResponseEntity<FormValildierungExceptionDTO> formValidierungFehlgeschlagen(FormValidierungFehlgeschlagen formValidierungFehlgeschlagen){
        return new ResponseEntity<>(formValidierungFehlgeschlagen.getErrorMap(), HttpStatus.BAD_REQUEST);
    }



}
