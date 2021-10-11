package com.Qred.emprestimo.service;

import com.Qred.emprestimo.model.PalavraRepetidaDto;
import com.Qred.emprestimo.model.RespostaDto;
import com.Qred.emprestimo.persistence.adapter.RespostaPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class RespostaService {
    private static final String PALAVRA_CRESCIMENO = "crescimento";
    private static final String PALAVRA_DIFICULDADES = "dificuldades";
    private final RespostaPersistence respostaPersistence;

    public RespostaDto buscarPerguntaPorId(Long idPergunta) {
        return respostaPersistence.buscarPerguntaPorId(idPergunta);
    }

    public int somarPontuacaoResposta(List<RespostaDto> listaRespostas) {
        return listaRespostas.stream().mapToInt(RespostaDto::getPontuacao).sum();
    }

    public PalavraRepetidaDto buscarPalavraMaisRepetida(List<RespostaDto> listaRespostas) {
        AtomicInteger quantidadeCrecimento = new AtomicInteger();
        AtomicInteger quantidadeDificuldade = new AtomicInteger();

        listaRespostas.forEach(resposta -> {
            if (resposta.getDescricaoResposta().toLowerCase().contains(PALAVRA_CRESCIMENO))
                quantidadeCrecimento.getAndIncrement();
            if (resposta.getDescricaoResposta().toLowerCase().contains(PALAVRA_DIFICULDADES))
                quantidadeDificuldade.getAndIncrement();
        });

        if (quantidadeCrecimento.get() > quantidadeDificuldade.get()) {
            return PalavraRepetidaDto.builder()
                    .palavra(PALAVRA_CRESCIMENO)
                    .quantidadeOcorrencia(quantidadeCrecimento.get()).build();
        } else {
            return PalavraRepetidaDto.builder()
                    .palavra(PALAVRA_DIFICULDADES)
                    .quantidadeOcorrencia(quantidadeDificuldade.get()).build();
        }
    }
}
