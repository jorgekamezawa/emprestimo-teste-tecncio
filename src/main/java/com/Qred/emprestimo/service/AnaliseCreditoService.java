package com.Qred.emprestimo.service;

import com.Qred.emprestimo.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnaliseCreditoService {
    private final RespostaService respostaService;
    private final PerguntaService perguntaService;
    private final ClienteService clienteService;

    public List<PerguntaDto> buscarPerguntas(String cnpj) {
        clienteService.validarCliente(cnpj);
        return perguntaService.buscarTodasPerguntas();
    }

    public RetornoAnaliseDto analisarRespostas(RespostasAnaliseDto respostasAnaliseDto) {
        List<RespostaDto> listaRespostas = respostasAnaliseDto.getListaRespostaParaAnaliseDto()
                .stream().map(resposta -> respostaService.buscarPerguntaPorId(resposta.getIdResposta()))
                .collect(Collectors.toList());

        int somaPontuacaoAnalise = respostaService.somarPontuacaoResposta(listaRespostas);
        boolean elegibilidade = somaPontuacaoAnalise >= 2;
        PalavraRepetidaDto palavraMaisRepetida = respostaService.buscarPalavraMaisRepetida(listaRespostas);

        return RetornoAnaliseDto.builder()
                .somaPontuacaoAnalise(somaPontuacaoAnalise)
                .elegibilidade(elegibilidade)
                .palavraRepetida(palavraMaisRepetida).build();
    }
}
