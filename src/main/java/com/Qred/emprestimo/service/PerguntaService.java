package com.Qred.emprestimo.service;

import com.Qred.emprestimo.model.PerguntaDto;
import com.Qred.emprestimo.persistence.adapter.PerguntaPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerguntaService {
    private final PerguntaPersistence perguntaPersistence;

    public List<PerguntaDto> buscarTodasPerguntas() {
        return perguntaPersistence.buscarTodasPerguntas();
    }
}
