package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.TipoMissao;
import br.com.odontoprev.repositories.TipoMissaoRepository;
import br.com.odontoprev.usecases.TipoMissaoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TipoMissaoUsecaseImpl implements TipoMissaoUsecase {

    private final TipoMissaoRepository tipoMissaoRepository;

    @Override
    public ResponseEntity<List<TipoMissao>> getAllTipoMissaos() {
        List<TipoMissao> tipoMissaos = tipoMissaoRepository.findAll();
        return ResponseEntity.ok(tipoMissaos);
    }

    @Override
    public ResponseEntity<TipoMissao> getTipoMissaoById(int id) {
        return tipoMissaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TipoMissao> createTipoMissao(TipoMissao tipoMissaos) {
        TipoMissao savedTipoMissao = tipoMissaoRepository.save(tipoMissaos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoMissao);
    }

    @Override
    public ResponseEntity<TipoMissao> updateTipoMissao(int id, TipoMissao tipoMissaos) {
        if (!tipoMissaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoMissaos.setId(id);
        TipoMissao updatedTipoMissao = tipoMissaoRepository.save(tipoMissaos);
        return ResponseEntity.ok(updatedTipoMissao);
    }

    @Override
    public ResponseEntity<Void> deleteTipoMissao(int id) {
        if (!tipoMissaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoMissaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
