package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.Recompensa;
import br.com.odontoprev.repositories.RecompensaRepository;
import br.com.odontoprev.usecases.RecompensaUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecompensaUsecaseImpl implements RecompensaUsecase {

    private final RecompensaRepository recompensaRepository;

    @Override
    public ResponseEntity<List<Recompensa>> getAllRecompensa() {
        List<Recompensa> recompensas = recompensaRepository.findAll();
        return ResponseEntity.ok(recompensas);
    }

    @Override
    public ResponseEntity<Recompensa> getRecompensaById(int id) {
        return recompensaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Recompensa> createRecompensa(Recompensa recompensas) {
        Recompensa savedRecompensa = recompensaRepository.save(recompensas);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecompensa);
    }

    @Override
    public ResponseEntity<Recompensa> updateRecompensa(int id, Recompensa recompensas) {
        if (!recompensaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        recompensas.setId(id);
        Recompensa updatedRecompensa = recompensaRepository.save(recompensas);
        return ResponseEntity.ok(updatedRecompensa);
    }

    @Override
    public ResponseEntity<Void> deleteRecompensa(int id) {
        if (!recompensaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        recompensaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
