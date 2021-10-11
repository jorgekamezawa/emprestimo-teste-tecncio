package com.Qred.emprestimo.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorModel {

    private final HttpStatus status;
    private final String message;
    private final String localDateTime;
}
