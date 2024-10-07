package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.TipoServico;
import br.com.odontoprev.repositories.TipoServicoRepository;
import br.com.odontoprev.usecases.TipoServicoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TipoServicoUsecaseImpl implements TipoServicoUsecase {

    private final TipoServicoRepository tipoServicoRepository;

    @Override
    public ResponseEntity<List<TipoServico>> getAllTipoServicos() {
        List<TipoServico> tipoServicos = tipoServicoRepository.findAll();
        return ResponseEntity.ok(tipoServicos);
    }

    @Override
    public ResponseEntity<TipoServico> getTipoServicoById(int id) {
        return tipoServicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TipoServico> createTipoServico(TipoServico tipoServicos) {
        TipoServico savedTipoServico = tipoServicoRepository.save(tipoServicos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoServico);
    }

    @Override
    public ResponseEntity<TipoServico> updateTipoServico(int id, TipoServico tipoServicos) {
        if (!tipoServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoServicos.setId(id);
        TipoServico updatedTipoServico = tipoServicoRepository.save(tipoServicos);
        return ResponseEntity.ok(updatedTipoServico);
    }

    @Override
    public ResponseEntity<Void> deleteTipoServico(int id) {
        if (!tipoServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoServicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
