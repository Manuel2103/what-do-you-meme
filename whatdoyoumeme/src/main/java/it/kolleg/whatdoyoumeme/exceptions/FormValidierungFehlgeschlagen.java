package it.kolleg.whatdoyoumeme.exceptions;

public class FormValidierungFehlgeschlagen extends Exception{

    private FormValildierungExceptionDTO errors;

    public FormValidierungFehlgeschlagen(String message) {
        super(message);
    }

    public FormValidierungFehlgeschlagen(FormValildierungExceptionDTO errors){
        this.errors = errors;
    }
    public FormValildierungExceptionDTO getErrorMap(){
        return errors;
    }
}
