package com.Qred.emprestimo.persistence.adapter;

import com.Qred.emprestimo.model.RespostaDto;

public interface RespostaPersistence {

    RespostaDto buscarPerguntaPorId(Long idPergunta);
}
