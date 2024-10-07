package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.Missao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MissaoUsecase {
    ResponseEntity<List<Missao>> getAllMissaos();
    ResponseEntity<Missao> getMissaoById(int id);
    ResponseEntity<Missao> createMissao(Missao missao);
    ResponseEntity<Missao> updateMissao(int id, Missao missao);
    ResponseEntity<Void> deleteMissao(int id);
}
