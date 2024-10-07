package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.Recompensa;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecompensaUsecase {
    ResponseEntity<List<Recompensa>> getAllRecompensa();
    ResponseEntity<Recompensa> getRecompensaById(int id);
    ResponseEntity<Recompensa> createRecompensa(Recompensa recompensa);
    ResponseEntity<Recompensa> updateRecompensa(int id, Recompensa recompensa);
    ResponseEntity<Void> deleteRecompensa(int id);
}
