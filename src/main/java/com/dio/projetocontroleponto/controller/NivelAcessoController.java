package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.NivelAcesso;
import com.dio.projetocontroleponto.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nivel_acesso")
public class NivelAcessoController {

    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping
    public ResponseEntity<NivelAcesso> createNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return ResponseEntity.ok(nivelAcessoService.save(nivelAcesso));
    }

    @GetMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> getNivelAcessoById(@PathVariable("idNivelAcesso") Long idNivelAcesso) {

        Optional<NivelAcesso> nivelAcesso = nivelAcessoService.getById(idNivelAcesso);

        return nivelAcesso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<NivelAcesso>> getNivelAcessoList() {
        return ResponseEntity.ok(nivelAcessoService.findAll());
    }

    @PutMapping
    public ResponseEntity<NivelAcesso> updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return ResponseEntity.ok(nivelAcessoService.update(nivelAcesso));
    }

    @DeleteMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> deleteNivelAcesso(@PathVariable("idNivelAcesso") long idNivelAcesso) {

        Optional<NivelAcesso> nivelAcesso = nivelAcessoService.getById(idNivelAcesso);

        if (nivelAcesso.isPresent()) {
            nivelAcessoService.deleteById(idNivelAcesso);
            return ResponseEntity.ok(nivelAcesso.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
