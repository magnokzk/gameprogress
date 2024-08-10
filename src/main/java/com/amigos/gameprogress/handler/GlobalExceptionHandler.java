package com.amigos.gameprogress.handler;

import com.amigos.gameprogress.exceptions.ExpectedException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(ExpectedException.class)
    public ResponseEntity<String> handleExpectedException(ExpectedException ex, Locale locale) {
            return new ResponseEntity<>(messageSource
                    .getMessage(ex.getMessage(), null, locale), HttpStatus.BAD_REQUEST);
    }

}
