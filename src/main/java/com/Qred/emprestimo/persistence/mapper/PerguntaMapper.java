package com.Qred.emprestimo.persistence.mapper;

import com.Qred.emprestimo.model.PerguntaDto;
import com.Qred.emprestimo.model.RespostaDto;
import com.Qred.emprestimo.persistence.entity.PerguntaPersistenceEntity;
import com.Qred.emprestimo.persistence.entity.RespostaPersistenceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PerguntaMapper {
    private final RespostaMapper respostaMapper;

    public List<PerguntaPersistenceEntity> converterParaEntity(List<PerguntaDto> listaDto) {
        return listaDto.stream().map(this::converterParaEntity)
                .collect(Collectors.toList());
    }

    public PerguntaPersistenceEntity converterParaEntity(PerguntaDto dto) {
        List<RespostaPersistenceEntity> listaRespostaentity = new ArrayList<>();
        if (!dto.getListaRespostas().isEmpty()) {
            listaRespostaentity = respostaMapper.converterParaEnitty(dto.getListaRespostas());
        }

        return PerguntaPersistenceEntity.builder()
                .idPergunta(dto.getIdPergunta())
                .descricaoPergunta(dto.getDescricaoPergunta())
                .listaRespostas(listaRespostaentity).build();
    }

    public List<PerguntaDto> converterParaDto(List<PerguntaPersistenceEntity> listaEntity) {
        return listaEntity.stream().map(this::converterParaDto)
                .collect(Collectors.toList());
    }

    public PerguntaDto converterParaDto(PerguntaPersistenceEntity entity) {
        List<RespostaDto> listaRespostaDto = new ArrayList<>();
        if (!entity.getListaRespostas().isEmpty()) {
            listaRespostaDto = respostaMapper.converterParaDto(entity.getListaRespostas());
        }

        return PerguntaDto.builder()
                .idPergunta(entity.getIdPergunta())
                .descricaoPergunta(entity.getDescricaoPergunta())
                .listaRespostas(listaRespostaDto).build();
    }
}
