package it.kolleg.whatdoyoumeme.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class FormValildierungExceptionDTO {
    private String code;
    private HashMap<String, String> formValidationsErrors;

    public FormValildierungExceptionDTO(String code){
        this.code = code;
        this.formValidationsErrors = new HashMap<>();
    }
    public void addFormValidationError(String fieldname, String fieldErrorMessage)
    {
        this.formValidationsErrors.put(fieldname, fieldErrorMessage);
    }
}
