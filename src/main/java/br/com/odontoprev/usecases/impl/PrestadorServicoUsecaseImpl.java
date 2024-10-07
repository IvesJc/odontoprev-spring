package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.PrestadorServico;
import br.com.odontoprev.repositories.PrestadorServicoRepository;
import br.com.odontoprev.usecases.PrestadorServicoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PrestadorServicoUsecaseImpl implements PrestadorServicoUsecase {

    private final PrestadorServicoRepository prestadorServicoRepository;


    @Override
    public ResponseEntity<List<PrestadorServico>> getAllPrestadores() {
        List<PrestadorServico> prestadores = prestadorServicoRepository.findAll();
        return ResponseEntity.ok(prestadores);
    }

    @Override
    public ResponseEntity<PrestadorServico> getPrestadorById(int id) {
        return prestadorServicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<PrestadorServico> createPrestador(PrestadorServico prestador) {
        PrestadorServico savedPrestador = prestadorServicoRepository.save(prestador);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPrestador);
    }

    @Override
    public ResponseEntity<PrestadorServico> updatePrestador(int id, PrestadorServico prestador) {
        if (!prestadorServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        prestador.setId(id);
        PrestadorServico updatedPrestador = prestadorServicoRepository.save(prestador);
        return ResponseEntity.ok(updatedPrestador);
    }

    @Override
    public ResponseEntity<Void> deletePrestador(int id) {
        if (!prestadorServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        prestadorServicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
