package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.Localidade;
import com.dio.projetocontroleponto.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public ResponseEntity<Localidade> createLocalidade(@RequestBody Localidade localidade) {
        return ResponseEntity.ok(localidadeService.save(localidade));
    }

    @GetMapping
    public ResponseEntity<List<Localidade>> getLocalidadeList() {
        return ResponseEntity.ok(localidadeService.findAll());
    }

    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeById(@PathVariable("idLocalidade") Long idLocalidade) {
        Optional<Localidade> localidade = localidadeService.findById(idLocalidade);

        return localidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public ResponseEntity<Localidade> updateLocalidade(@RequestBody Localidade localidade) {
        return ResponseEntity.ok(localidadeService.update(localidade));
    }

    @DeleteMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> deleteLocalidadeById(@PathVariable("idLocalidade") Long idLocalidade) {
        Optional<Localidade> localidade = localidadeService.findById(idLocalidade);

        if (localidade.isPresent()) {
            localidadeService.deleteById(idLocalidade);
            return ResponseEntity.ok(localidade.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
