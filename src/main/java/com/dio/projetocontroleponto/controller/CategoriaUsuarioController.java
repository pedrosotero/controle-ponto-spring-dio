package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.CategoriaUsuario;
import com.dio.projetocontroleponto.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria_usuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public ResponseEntity<CategoriaUsuario> createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        return ResponseEntity.ok(categoriaUsuarioService.save(categoriaUsuario));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaUsuario>> getCategoriaUsuarioList() {
        return ResponseEntity.ok(categoriaUsuarioService.findAll());
    }

    @GetMapping("/{idCategoriaUsuario}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioById(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) {
        Optional<CategoriaUsuario> categoriaUsuario = categoriaUsuarioService.findById(idCategoriaUsuario);

        return categoriaUsuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public ResponseEntity<CategoriaUsuario> updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        return ResponseEntity.ok(categoriaUsuarioService.update(categoriaUsuario));
    }

    @DeleteMapping("/{idCategoriaUsuario}")
    public ResponseEntity<CategoriaUsuario> deleteCategoriaUsuarioById(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) {
        Optional<CategoriaUsuario> categoriaUsuario = categoriaUsuarioService.findById(idCategoriaUsuario);

        if (categoriaUsuario.isPresent()) {
            categoriaUsuarioService.deleteById(idCategoriaUsuario);
            return ResponseEntity.ok(categoriaUsuario.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
