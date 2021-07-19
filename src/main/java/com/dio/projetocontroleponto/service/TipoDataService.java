package com.dio.projetocontroleponto.service;

import com.dio.projetocontroleponto.model.TipoData;
import com.dio.projetocontroleponto.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {

    @Autowired
    TipoDataRepository tipoDataRepository;

    public TipoData save(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public List<TipoData> findAll() {
        return tipoDataRepository.findAll();
    }

    public Optional<TipoData> getById(Long id) {
        return tipoDataRepository.findById(id);
    }

    public TipoData update(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public void deleteById(Long id) {
        tipoDataRepository.deleteById(id);
    }
}
