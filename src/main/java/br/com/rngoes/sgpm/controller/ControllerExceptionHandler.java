package br.com.rngoes.sgpm.controller;

import br.com.rngoes.sgpm.dto.ErrorDTO;
import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(exception = InvalidFieldException.class)
    public ResponseEntity<ErrorDTO> handleInvalidFieldException(InvalidFieldException ex) {
        return ResponseEntity.status(404).body(new ErrorDTO(ex.getMessage()));
    }
}
