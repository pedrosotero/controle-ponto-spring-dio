package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.Ocorrencia;
import com.dio.projetocontroleponto.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ResponseEntity.ok(ocorrenciaService.save(ocorrencia));
    }

    @GetMapping
    public ResponseEntity<List<Ocorrencia>> getOcorrenciaList() {
        return ResponseEntity.ok(ocorrenciaService.findAll());
    }

    @GetMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> getOcorrenciaById(@PathVariable("idOcorrencia") Long idOcorrencia) {
        Optional<Ocorrencia> ocorrencia = ocorrenciaService.findById(idOcorrencia);

        return ocorrencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public ResponseEntity<Ocorrencia> updateOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ResponseEntity.ok(ocorrenciaService.save(ocorrencia));
    }

    @DeleteMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> deleteOcorrencia(@PathVariable("idOcorrencia") Long idOcorrencia) {
        Optional<Ocorrencia> ocorrencia = ocorrenciaService.findById(idOcorrencia);

        if (ocorrencia.isPresent()) {
            ocorrenciaService.deleteById(idOcorrencia);
            return ResponseEntity.ok(ocorrencia.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
