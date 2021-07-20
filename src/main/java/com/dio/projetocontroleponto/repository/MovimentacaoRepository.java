package com.dio.projetocontroleponto.repository;

import com.dio.projetocontroleponto.Ids.MovimentacaoId;
import com.dio.projetocontroleponto.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, MovimentacaoId> {

    Optional<Movimentacao> findByIdIdMovimentoAndIdIdUsuario(Long idMovimento, Long idUsuario);

    void deleteByIdIdMovimentoAndIdIdUsuario(Long idMovimento, Long idUsuario);
}
