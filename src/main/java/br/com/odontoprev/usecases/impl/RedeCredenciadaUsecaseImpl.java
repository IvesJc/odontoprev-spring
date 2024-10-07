package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.RedeCredenciada;
import br.com.odontoprev.repositories.RedeCredenciadaRepository;
import br.com.odontoprev.usecases.RedeCredenciadaUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RedeCredenciadaUsecaseImpl implements RedeCredenciadaUsecase {

    private final RedeCredenciadaRepository redeCredenciadaRepository;

    @Override
    public ResponseEntity<List<RedeCredenciada>> getAllRedeCredenciada() {
        List<RedeCredenciada> redeCredenciadas = redeCredenciadaRepository.findAll();
        return ResponseEntity.ok(redeCredenciadas);
    }

    @Override
    public ResponseEntity<RedeCredenciada> getRedeCredenciadaById(int id) {
        return redeCredenciadaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<RedeCredenciada> createRedeCredenciada(RedeCredenciada redeCredenciadas) {
        RedeCredenciada savedRedeCredenciada = redeCredenciadaRepository.save(redeCredenciadas);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRedeCredenciada);
    }

    @Override
    public ResponseEntity<RedeCredenciada> updateRedeCredenciada(int id, RedeCredenciada redeCredenciadas) {
        if (!redeCredenciadaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        redeCredenciadas.setId(id);
        RedeCredenciada updatedRedeCredenciada = redeCredenciadaRepository.save(redeCredenciadas);
        return ResponseEntity.ok(updatedRedeCredenciada);
    }

    @Override
    public ResponseEntity<Void> deleteRedeCredenciada(int id) {
        if (!redeCredenciadaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        redeCredenciadaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
