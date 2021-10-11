package com.Qred.emprestimo.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perguntas")
public class PerguntaPersistenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long idPergunta;

    @Column(name = "descricao_pergunta", nullable = false)
    private String descricaoPergunta;

    @OneToMany(mappedBy = "pergunta", targetEntity = RespostaPersistenceEntity.class, cascade = CascadeType.MERGE)
    private List<RespostaPersistenceEntity> listaRespostas;
}
