package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.TipoData;
import com.dio.projetocontroleponto.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tipo_data")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    public ResponseEntity<TipoData> createTipoData(@RequestBody TipoData tipoData) {
        return ResponseEntity.ok(tipoDataService.save(tipoData));
    }

    @GetMapping
    public ResponseEntity<List<TipoData>> getTipoDataList() {
        return ResponseEntity.ok(tipoDataService.findAll());
    }

    @GetMapping("/{idTipoData}")
    public ResponseEntity<TipoData> getTipoDataById(@PathVariable("idTipoData") Long idTipoData) {

        Optional<TipoData> tipoData = tipoDataService.getById(idTipoData);

        return tipoData.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public ResponseEntity<TipoData> updateTipoData(@RequestBody TipoData tipoData) {
        return ResponseEntity.ok(tipoDataService.update(tipoData));
    }

    @DeleteMapping("/{idTipoData}")
    public ResponseEntity<TipoData> deleteTipoDataById(@PathVariable("idTipoData") Long idTipoData) {

        Optional<TipoData> tipoData = tipoDataService.getById(idTipoData);

        if (tipoData.isPresent()) {
            tipoDataService.deleteById(idTipoData);
            return ResponseEntity.ok(tipoData.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
