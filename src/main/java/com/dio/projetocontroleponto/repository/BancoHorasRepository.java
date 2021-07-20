package com.dio.projetocontroleponto.repository;

import com.dio.projetocontroleponto.Ids.BancoHorasId;
import com.dio.projetocontroleponto.model.BancoHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, BancoHorasId> {

    Optional<BancoHoras> findByIdIdBancoHorasAndIdIdUsuario(Long idBancoHoras, Long idUsuario);

    void deleteByIdIdBancoHorasAndIdIdUsuario(Long idBancoHoras, Long idUsuario);
}
