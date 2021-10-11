package com.Qred.emprestimo.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class ClientePersistenceEntity {
    @Id
    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "pontuacao_analise_credito")
    private int pontuacaoAnaliseCredito;

    public ClientePersistenceEntity(String cnpj) {
        this.cnpj = cnpj;
        this.pontuacaoAnaliseCredito = 0;
    }
}
