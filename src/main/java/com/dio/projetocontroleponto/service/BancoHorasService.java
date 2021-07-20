package com.dio.projetocontroleponto.service;

import com.dio.projetocontroleponto.model.BancoHoras;
import com.dio.projetocontroleponto.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BancoHorasService {

    @Autowired
    BancoHorasRepository bancoHorasRepository;

    public BancoHoras save(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> findAll() {
        return bancoHorasRepository.findAll();
    }

    public Optional<BancoHoras> findByIdBancoHorasAndIdUsuario(Long idBancoHoras, Long idUsuario) {
        return bancoHorasRepository.findByIdIdBancoHorasAndIdIdUsuario(idBancoHoras, idUsuario);
    }

    public BancoHoras update(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public void deleteByIdBancoHorasAndIdUsuario(Long idBancoHoras, Long idUsuario) {
        bancoHorasRepository.deleteByIdIdBancoHorasAndIdIdUsuario(idBancoHoras, idUsuario);
    }
}
