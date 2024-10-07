package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.TipoRecompensa;
import br.com.odontoprev.repositories.TipoRecompensaRepository;
import br.com.odontoprev.usecases.TipoRecompensaUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TipoRecompensaUsecaseImpl implements TipoRecompensaUsecase {

    private final TipoRecompensaRepository tipoRecompensaRepository;

    @Override
    public ResponseEntity<List<TipoRecompensa>> getAllTipoRecompensas() {
        List<TipoRecompensa> tipoRecompensas = tipoRecompensaRepository.findAll();
        return ResponseEntity.ok(tipoRecompensas);
    }

    @Override
    public ResponseEntity<TipoRecompensa> getTipoRecompensaById(int id) {
        return tipoRecompensaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TipoRecompensa> createTipoRecompensa(TipoRecompensa tipoRecompensas) {
        TipoRecompensa savedTipoRecompensa = tipoRecompensaRepository.save(tipoRecompensas);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoRecompensa);
    }

    @Override
    public ResponseEntity<TipoRecompensa> updateTipoRecompensa(int id, TipoRecompensa tipoRecompensas) {
        if (!tipoRecompensaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoRecompensas.setId(id);
        TipoRecompensa updatedTipoRecompensa = tipoRecompensaRepository.save(tipoRecompensas);
        return ResponseEntity.ok(updatedTipoRecompensa);
    }

    @Override
    public ResponseEntity<Void> deleteTipoRecompensa(int id) {
        if (!tipoRecompensaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoRecompensaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
