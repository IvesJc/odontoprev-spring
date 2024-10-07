package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.TipoPlanoOdontologico;
import br.com.odontoprev.repositories.TipoPlanoOdontologicoRepository;
import br.com.odontoprev.usecases.TipoPlanoOdontologicoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TipoPlanoOdontologicoUsecaseImpl implements TipoPlanoOdontologicoUsecase {

    private final TipoPlanoOdontologicoRepository tipoPlanoOdontologicoRepository;

    @Override
    public ResponseEntity<List<TipoPlanoOdontologico>> getAllTipoPlanoOdontologicos() {
        List<TipoPlanoOdontologico> tipoPlanoOdontologico = tipoPlanoOdontologicoRepository.findAll();
        return ResponseEntity.ok(tipoPlanoOdontologico);
    }

    @Override
    public ResponseEntity<TipoPlanoOdontologico> getTipoPlanoOdontologicoById(int id) {
        return tipoPlanoOdontologicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TipoPlanoOdontologico> createTipoPlanoOdontologico(TipoPlanoOdontologico tipoPlanoOdontologico) {
        TipoPlanoOdontologico savedTipoPlanoOdontologico = tipoPlanoOdontologicoRepository.save(tipoPlanoOdontologico);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoPlanoOdontologico);
    }

    @Override
    public ResponseEntity<TipoPlanoOdontologico> updateTipoPlanoOdontologico(int id, TipoPlanoOdontologico tipoPlanoOdontologico) {
        if (!tipoPlanoOdontologicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoPlanoOdontologico.setId(id);
        TipoPlanoOdontologico updatedTipoPlanoOdontologico = tipoPlanoOdontologicoRepository.save(tipoPlanoOdontologico);
        return ResponseEntity.ok(updatedTipoPlanoOdontologico);
    }

    @Override
    public ResponseEntity<Void> deleteTipoPlanoOdontologico(int id) {
        if (!tipoPlanoOdontologicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoPlanoOdontologicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
