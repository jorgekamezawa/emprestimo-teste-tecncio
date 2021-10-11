package com.Qred.emprestimo.exception.handler;

import com.Qred.emprestimo.exception.ValidacaoCnpjException;
import com.Qred.emprestimo.exception.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class CustomRestExceptionHandler {

    @ExceptionHandler(value = {ValidacaoCnpjException.class})
    public ResponseEntity<ErrorModel> handlerNoContentException(ValidacaoCnpjException ex) {
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;

        ErrorModel errorModel = ErrorModel.builder()
                .message(ex.getMessage())
                .status(status)
                .localDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).build();

        return new ResponseEntity<>(errorModel, status);
    }
}
