package com.Qred.emprestimo.persistence.impl.h2;

import com.Qred.emprestimo.model.PerguntaDto;
import com.Qred.emprestimo.persistence.adapter.PerguntaPersistence;
import com.Qred.emprestimo.persistence.entity.PerguntaPersistenceEntity;
import com.Qred.emprestimo.persistence.mapper.PerguntaMapper;
import com.Qred.emprestimo.persistence.repository.PerguntaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PerguntaPersistenceH2 implements PerguntaPersistence {
    private final PerguntaRepository perguntaRepository;
    private final PerguntaMapper perguntaMapper;

    @Override
    public List<PerguntaDto> buscarTodasPerguntas() {
        List<PerguntaPersistenceEntity> listaPerguntaEntity = perguntaRepository.findAll();
        return perguntaMapper.converterParaDto(listaPerguntaEntity);
    }
}
