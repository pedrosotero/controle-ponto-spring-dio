package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.Calendario;
import com.dio.projetocontroleponto.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public ResponseEntity<Calendario> createCalendario(@RequestBody Calendario calendario) {
        return ResponseEntity.ok(calendarioService.save(calendario));
    }

    @GetMapping
    public ResponseEntity<List<Calendario>> getCalendarioList() {
        return ResponseEntity.ok(calendarioService.findAll());
    }

    @GetMapping("/{idCalendario}")
    public ResponseEntity<Calendario> getCalendarioById(@PathVariable("idCalendario") Long idCalendario) {
        Optional<Calendario> calendario = calendarioService.findById(idCalendario);

        return calendario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public ResponseEntity<Calendario> updateCalendario(@RequestBody Calendario calendario) {
        return ResponseEntity.ok(calendarioService.update(calendario));
    }

    @DeleteMapping("/{idCalendario}")
    public ResponseEntity<Calendario> deleteCalendarioById(@PathVariable("idCalendario") Long idCalendario) {
        Optional<Calendario> calendario = calendarioService.findById(idCalendario);

        if (calendario.isPresent()) {
            calendarioService.deleteById(idCalendario);
            return ResponseEntity.ok(calendario.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
