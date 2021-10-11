package com.Qred.emprestimo.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespostasAnaliseDto {
    private String cnpj;
    private List<RespostaAnaliseDto> listaRespostaParaAnaliseDto;
}
