package com.dio.projetocontroleponto.service;

import com.dio.projetocontroleponto.model.NivelAcesso;
import com.dio.projetocontroleponto.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {

    @Autowired
    NivelAcessoRepository nivelAcessoRepository;

    public NivelAcesso save(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public List<NivelAcesso> findAll() {
        return nivelAcessoRepository.findAll();
    }

    public Optional<NivelAcesso> getById(Long id) {
        return nivelAcessoRepository.findById(id);
    }

    public NivelAcesso update(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public void deleteById(Long id) {
        nivelAcessoRepository.deleteById(id);
    }
}
