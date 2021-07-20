package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.Movimentacao;
import com.dio.projetocontroleponto.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<Movimentacao> createMovimentacao(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.ok(movimentacaoService.save(movimentacao));
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> getMovimentacaoList() {
        return ResponseEntity.ok(movimentacaoService.findAll());
    }

    @GetMapping("/movimento={idMovimento}&usuario={idUsuario}")
    public ResponseEntity<Movimentacao> getMovimentacaoByIdMovimentoAndIdUsuario(@PathVariable("idMovimento") Long idMovimento,
                                                                                 @PathVariable("idUsuario") Long idUsuario) {
        Optional<Movimentacao> movimentacao = movimentacaoService.findByIdMovimentoAndIdUsuario(idMovimento, idUsuario);

        return movimentacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public ResponseEntity<Movimentacao> updateMovimentacao(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.ok(movimentacaoService.update(movimentacao));
    }

    @DeleteMapping("/movimento={idMovimento}&usuario={idUsuario}")
    public ResponseEntity<Movimentacao> deleteMovimentacaoByIdMovimentoAndIdUsuario(@PathVariable("idMovimento") Long idMovimento,
                                                                                    @PathVariable("idUsuario") Long idUsuario) {
        Optional<Movimentacao> movimentacao = movimentacaoService.findByIdMovimentoAndIdUsuario(idMovimento, idUsuario);

        if (movimentacao.isPresent()) {
            movimentacaoService.deleteByIdMovimentoAndIdUsuario(idMovimento, idUsuario);
            return ResponseEntity.ok(movimentacao.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
