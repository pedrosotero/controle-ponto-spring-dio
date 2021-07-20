package com.dio.projetocontroleponto.service;

import com.dio.projetocontroleponto.model.Localidade;
import com.dio.projetocontroleponto.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    @Autowired
    LocalidadeRepository localidadeRepository;

    public Localidade save(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    public List<Localidade> findAll() {
        return localidadeRepository.findAll();
    }

    public Optional<Localidade> findById(Long id) {
        return localidadeRepository.findById(id);
    }

    public Localidade update(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    public void deleteById(Long id) {
        localidadeRepository.deleteById(id);
    }
}
