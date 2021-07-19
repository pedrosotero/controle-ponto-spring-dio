package com.dio.projetocontroleponto.service;

import com.dio.projetocontroleponto.model.CategoriaUsuario;
import com.dio.projetocontroleponto.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaUsuarioService {

    @Autowired
    CategoriaUsuarioRepository categoriaUsuarioRepository;

    public CategoriaUsuario save(CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public List<CategoriaUsuario> findAll() {
        return categoriaUsuarioRepository.findAll();
    }

    public Optional<CategoriaUsuario> findById(Long id) {
        return categoriaUsuarioRepository.findById(id);
    }

    public CategoriaUsuario update(CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public void deleteById(Long id) {
        categoriaUsuarioRepository.deleteById(id);
    }
}
