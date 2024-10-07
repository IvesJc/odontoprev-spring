package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.Missao;
import br.com.odontoprev.repositories.MissaoRepository;
import br.com.odontoprev.usecases.MissaoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MissaoUsecaseImpl implements MissaoUsecase {

    private final MissaoRepository missaoRepository;

    @Override
    public ResponseEntity<List<Missao>> getAllMissaos() {
        List<Missao> Missaos = missaoRepository.findAll();
        return ResponseEntity.ok(Missaos);
    }

    @Override
    public ResponseEntity<Missao> getMissaoById(int id) {
        return missaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Missao> createMissao(Missao missao) {
        Missao savedMissao = missaoRepository.save(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMissao);
    }

    @Override
    public ResponseEntity<Missao> updateMissao(int id, Missao missao) {
        if (!missaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        missao.setId(id);
        Missao updatedMissao = missaoRepository.save(missao);
        return ResponseEntity.ok(updatedMissao);
    }

    @Override
    public ResponseEntity<Void> deleteMissao(int id) {
        if (!missaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        missaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
