package br.com.tqi.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyLoanListException extends Exception{


    public EmptyLoanListException() {
        super("Loan not found.");
    }
}
