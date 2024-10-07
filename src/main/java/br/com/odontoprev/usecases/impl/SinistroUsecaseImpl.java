package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.Sinistro;
import br.com.odontoprev.repositories.SinistroRepository;
import br.com.odontoprev.usecases.SinistroUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SinistroUsecaseImpl implements SinistroUsecase {

    private final SinistroRepository sinistroRepository;

    @Override
    public ResponseEntity<List<Sinistro>> getAllSinistros() {
        List<Sinistro> sinistros = sinistroRepository.findAll();
        return ResponseEntity.ok(sinistros);
    }

    @Override
    public ResponseEntity<Sinistro> getSinistroById(int id) {
        return sinistroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Sinistro> createSinistro(Sinistro sinistro) {
        Sinistro savedSinistro = sinistroRepository.save(sinistro);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSinistro);
    }

    @Override
    public ResponseEntity<Sinistro> updateSinistro(int id, Sinistro sinistro) {
        if (!sinistroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sinistro.setId(id);
        Sinistro updatedSinistro = sinistroRepository.save(sinistro);
        return ResponseEntity.ok(updatedSinistro);
    }

    @Override
    public ResponseEntity<Void> deleteSinistro(int id) {
        if (!sinistroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sinistroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
