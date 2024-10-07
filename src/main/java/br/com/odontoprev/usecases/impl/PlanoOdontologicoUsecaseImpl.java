package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.PlanoOdontologico;
import br.com.odontoprev.repositories.PlanoOdontologicoRepository;
import br.com.odontoprev.usecases.PlanoOdontologicoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlanoOdontologicoUsecaseImpl implements PlanoOdontologicoUsecase {

    private final PlanoOdontologicoRepository planoOdontologicoRepository;

    @Override
    public ResponseEntity<List<PlanoOdontologico>> getAllPlanoOdontologicos() {
        List<PlanoOdontologico> planoOdontologicos = planoOdontologicoRepository.findAll();
        return ResponseEntity.ok(planoOdontologicos);
    }

    @Override
    public ResponseEntity<PlanoOdontologico> getPlanoOdontologicoById(int id) {
        return planoOdontologicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<PlanoOdontologico> createPlanoOdontologico(PlanoOdontologico planoOdontologico) {
        PlanoOdontologico savedPlanoOdontologicos = planoOdontologicoRepository.save(planoOdontologico);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlanoOdontologicos);
    }

    @Override
    public ResponseEntity<PlanoOdontologico> updatePlanoOdontologico(int id, PlanoOdontologico planoOdontologico) {
        if (!planoOdontologicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        planoOdontologico.setId(id);
        PlanoOdontologico updatedPlanoOdontologico = planoOdontologicoRepository.save(planoOdontologico);
        return ResponseEntity.ok(updatedPlanoOdontologico);
    }

    @Override
    public ResponseEntity<Void> deletePlanoOdontologico(int id) {
        if (!planoOdontologicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        planoOdontologicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
