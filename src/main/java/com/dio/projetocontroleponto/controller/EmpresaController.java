package com.dio.projetocontroleponto.controller;

import com.dio.projetocontroleponto.model.Empresa;
import com.dio.projetocontroleponto.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.save(empresa));
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getEmpresaList() {
        return ResponseEntity.ok(empresaService.findAll());
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("idEmpresa") Long idEmpresa) {

        Optional<Empresa> empresa = empresaService.getById(idEmpresa);

        return empresa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping
    public ResponseEntity<Empresa> updateEmpresa(@RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.update(empresa));
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> deleteEmpresaById(@PathVariable("idEmpresa") Long idEmpresa) {

        Optional<Empresa> empresa = empresaService.getById(idEmpresa);

        if (empresa.isPresent()) {
            empresaService.deleteById(idEmpresa);
            return ResponseEntity.ok(empresa.get());
        }

        return ResponseEntity.notFound().build();
    }
}
