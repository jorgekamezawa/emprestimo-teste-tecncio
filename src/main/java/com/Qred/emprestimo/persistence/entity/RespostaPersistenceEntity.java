package com.Qred.emprestimo.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "respostas")
public class RespostaPersistenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long idResposta;

    @Column(name = "descricao_resposta", nullable = false)
    private String descricaoResposta;

    @Column(name = "pontuacao")
    private int pontuacao;

    @ManyToOne(fetch = FetchType.LAZY)
    private PerguntaPersistenceEntity pergunta;
}
