package com.Qred.emprestimo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RetornoAnaliseDto {
    @JsonProperty("soma_pontuacao_analise")
    private int somaPontuacaoAnalise;

    @JsonProperty("elegibilidade")
    private boolean elegibilidade;

    @JsonProperty("palavra_repetida")
    private PalavraRepetidaDto palavraRepetida;
}