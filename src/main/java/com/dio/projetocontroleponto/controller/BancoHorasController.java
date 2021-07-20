package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.BancoHoras;
import com.dio.projetocontroleponto.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/banco_horas")
public class BancoHorasController {

    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public ResponseEntity<BancoHoras> createBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return ResponseEntity.ok(bancoHorasService.save(bancoHoras));
    }

    @GetMapping
    public ResponseEntity<List<BancoHoras>> getBancoHorasList() {
        return ResponseEntity.ok(bancoHorasService.findAll());
    }

    @GetMapping("/banco_horas={idBancoHoras}&usuario={idUsuario}")
    public ResponseEntity<BancoHoras> getBancoHorasByIdBancoHorasAndIdUsuario(@PathVariable("idBancoHoras") Long idBancoHoras,
                                                                              @PathVariable("idUsuario") Long idUsuario) {
        Optional<BancoHoras> bancoHoras = bancoHorasService.findByIdBancoHorasAndIdUsuario(idBancoHoras, idUsuario);

        return bancoHoras.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public ResponseEntity<BancoHoras> updateBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return ResponseEntity.ok(bancoHorasService.save(bancoHoras));
    }

    @DeleteMapping("/banco_horas={idBancoHoras}&usuario={idUsuario}")
    public ResponseEntity<BancoHoras> deleteBancoHorasByIdBancoHorasAndIdUsuario(@PathVariable("idBancoHoras") Long idBancoHoras,
                                                                                 @PathVariable("idUsuario") Long idUsuario) {
        Optional<BancoHoras> bancoHoras = bancoHorasService.findByIdBancoHorasAndIdUsuario(idBancoHoras, idUsuario);

        if (bancoHoras.isPresent()) {
            bancoHorasService.deleteByIdBancoHorasAndIdUsuario(idBancoHoras, idUsuario);
            return ResponseEntity.ok(bancoHoras.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
