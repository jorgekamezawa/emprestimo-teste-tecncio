package com.Qred.emprestimo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PalavraRepetidaDto {
    @JsonProperty("palavra")
    private String palavra;
    @JsonProperty("quantidade_ocorrencia")
    private int quantidadeOcorrencia;
}
