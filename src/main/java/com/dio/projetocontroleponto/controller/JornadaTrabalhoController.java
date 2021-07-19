package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.JornadaTrabalho;
import com.dio.projetocontroleponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return ResponseEntity.ok(jornadaService.save(jornadaTrabalho));
    }

    @GetMapping
    public ResponseEntity<List<JornadaTrabalho>> getJornadaList() {
        return ResponseEntity.ok(jornadaService.findAll());
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") long idJornada) {

        Optional<JornadaTrabalho> response = jornadaService.getById(idJornada);

        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public ResponseEntity<JornadaTrabalho> updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return ResponseEntity.ok(jornadaService.update(jornadaTrabalho));
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> deleteJornadaById(@PathVariable("idJornada") long idJornada) {

        Optional<JornadaTrabalho> jornada = jornadaService.getById(idJornada);

        if (jornada.isPresent()) {
            jornadaService.delete(idJornada);
            return ResponseEntity.ok(jornada.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
