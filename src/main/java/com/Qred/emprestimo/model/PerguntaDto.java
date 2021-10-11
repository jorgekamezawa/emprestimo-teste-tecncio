package com.Qred.emprestimo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerguntaDto {
    @JsonProperty("id_pergunta")
    private Long idPergunta;

    @JsonProperty("descricao_pergunta")
    private String descricaoPergunta;

    @JsonProperty("lista_respostas")
    private List<RespostaDto> listaRespostas;
}
