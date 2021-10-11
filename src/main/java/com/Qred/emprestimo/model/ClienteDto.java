package com.Qred.emprestimo.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private String cnpj;
    private int pontuacaoAnaliseCredito;

    public ClienteDto(String cnpj) {
        this.cnpj = cnpj;
    }
}
