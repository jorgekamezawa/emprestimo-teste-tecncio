package com.Qred.emprestimo.controller;

import com.Qred.emprestimo.model.PerguntaDto;
import com.Qred.emprestimo.model.RespostasAnaliseDto;
import com.Qred.emprestimo.model.RetornoAnaliseDto;
import com.Qred.emprestimo.service.AnaliseCreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("analise/credito")
@RequiredArgsConstructor
public class AnaliseDeCreditoController {
    private final AnaliseCreditoService analiseCreditoService;

    @GetMapping("/{cnpj}/perguntas")
    public ResponseEntity<List<PerguntaDto>> buscarPerguntas(@PathVariable String cnpj) {
        List<PerguntaDto> listaPerguntas = analiseCreditoService.buscarPerguntas(cnpj);
        return ResponseEntity.ok(listaPerguntas);
    }

    @PostMapping
    public ResponseEntity<RetornoAnaliseDto> analisarPerguntas(@RequestBody RespostasAnaliseDto respostasAnaliseDto) {
        RetornoAnaliseDto retornoAnaliseDto = analiseCreditoService.analisarRespostas(respostasAnaliseDto);
        return ResponseEntity.ok(retornoAnaliseDto);
    }
}
