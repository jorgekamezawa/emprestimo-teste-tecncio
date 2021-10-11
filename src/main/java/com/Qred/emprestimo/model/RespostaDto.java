package com.Qred.emprestimo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespostaDto {
    @JsonProperty("id_resposta")
    private Long idResposta;

    @JsonProperty("descricao_resposta")
    private String descricaoResposta;

    @JsonIgnore
    private int pontuacao;
}
