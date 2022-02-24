package com.example.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundPersonException extends Exception{
    public NotFoundPersonException(Long id) {
        super("PERSON NOT FOUND WITH ID " + id);
    }
}
