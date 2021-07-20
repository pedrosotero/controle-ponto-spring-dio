package com.dio.projetocontroleponto.service;

import com.dio.projetocontroleponto.model.Movimentacao;
import com.dio.projetocontroleponto.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MovimentacaoService {

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    public Movimentacao save(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public Optional<Movimentacao> findByIdMovimentoAndIdUsuario(Long idMovimento, Long idUsuario) {
        return movimentacaoRepository.findByIdIdMovimentoAndIdIdUsuario(idMovimento, idUsuario);
    }

    public Movimentacao update(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public void deleteByIdMovimentoAndIdUsuario(Long idMovimento, Long idUsuario) {
        movimentacaoRepository.deleteByIdIdMovimentoAndIdIdUsuario(idMovimento, idUsuario);
    }
}
