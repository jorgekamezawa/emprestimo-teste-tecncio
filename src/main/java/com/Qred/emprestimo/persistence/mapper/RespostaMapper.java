package com.Qred.emprestimo.persistence.mapper;

import com.Qred.emprestimo.model.RespostaDto;
import com.Qred.emprestimo.persistence.entity.RespostaPersistenceEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RespostaMapper {

    public List<RespostaPersistenceEntity> converterParaEnitty(List<RespostaDto> listaDto) {
        return listaDto.stream().map(this::converterParaEnitty)
                .collect(Collectors.toList());
    }

    public RespostaPersistenceEntity converterParaEnitty(RespostaDto dto) {
        return RespostaPersistenceEntity.builder()
                .idResposta(dto.getIdResposta())
                .descricaoResposta(dto.getDescricaoResposta())
                .pontuacao(dto.getPontuacao()).build();
    }

    public List<RespostaDto> converterParaDto(List<RespostaPersistenceEntity> listaEntity) {
        return listaEntity.stream().map(this::converterParaDto)
                .collect(Collectors.toList());
    }

    public RespostaDto converterParaDto(RespostaPersistenceEntity entity) {
        return RespostaDto.builder()
                .idResposta(entity.getIdResposta())
                .descricaoResposta(entity.getDescricaoResposta())
                .pontuacao(entity.getPontuacao()).build();
    }
}
