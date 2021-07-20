package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.Usuario;
import com.dio.projetocontroleponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarioList() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("idUsuario") Long idUsuario) {
        Optional<Usuario> usuario = usuarioService.findById(idUsuario);

        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Usuario> deleteUsuarioById(@PathVariable("idUsuario") Long idUsuario) {
        Optional<Usuario> usuario = usuarioService.findById(idUsuario);

        if (usuario.isPresent()) {
            usuarioService.deleteById(idUsuario);
            return ResponseEntity.ok(usuario.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
