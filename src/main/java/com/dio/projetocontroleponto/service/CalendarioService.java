package com.dio.projetocontroleponto.service;

import com.dio.projetocontroleponto.model.Calendario;
import com.dio.projetocontroleponto.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {

    @Autowired
    CalendarioRepository calendarioRepository;

    public Calendario save(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public List<Calendario> findAll() {
        return calendarioRepository.findAll();
    }

    public Optional<Calendario> findById(Long id) {
        return calendarioRepository.findById(id);
    }

    public Calendario update(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public void deleteById(Long id) {
        calendarioRepository.deleteById(id);
    }
}
