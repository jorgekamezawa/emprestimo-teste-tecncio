package com.Qred.emprestimo.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespostaAnaliseDto {
    private Long idPergunta;
    private Long idResposta;
}
