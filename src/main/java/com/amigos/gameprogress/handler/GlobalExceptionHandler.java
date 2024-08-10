package com.amigos.gameprogress.handler;

import com.amigos.gameprogress.exceptions.ExpectedException;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final MessageSource messageSource;

    @ExceptionHandler(ExpectedException.class)
    public ResponseEntity<String> handleExpectedException(ExpectedException ex, Locale locale) {
            log.error(ex.getMessage());
            return new ResponseEntity<>(messageSource
                    .getMessage(ex.getMessage(), null, locale), HttpStatus.BAD_REQUEST);
    }

}
