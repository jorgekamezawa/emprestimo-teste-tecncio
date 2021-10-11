package com.Qred.emprestimo.persistence.adapter;

import com.Qred.emprestimo.model.PerguntaDto;

import java.util.List;

public interface PerguntaPersistence {
    List<PerguntaDto> buscarTodasPerguntas();
}
