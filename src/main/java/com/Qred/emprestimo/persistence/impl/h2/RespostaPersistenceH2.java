package com.Qred.emprestimo.persistence.impl.h2;

import com.Qred.emprestimo.model.RespostaDto;
import com.Qred.emprestimo.persistence.adapter.RespostaPersistence;
import com.Qred.emprestimo.persistence.mapper.RespostaMapper;
import com.Qred.emprestimo.persistence.repository.RespostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RespostaPersistenceH2 implements RespostaPersistence {
    private final RespostaRepository respostaRepository;
    private final RespostaMapper respostaMapper;

    @Override
    public RespostaDto buscarPerguntaPorId(Long idPergunta) {
        return respostaMapper.converterParaDto(respostaRepository.findById(idPergunta).get());
    }
}
