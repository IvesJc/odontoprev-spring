package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.Sinistro;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SinistroUsecase {
    ResponseEntity<List<Sinistro>> getAllSinistros();
    ResponseEntity<Sinistro> getSinistroById(int id);
    ResponseEntity<Sinistro> createSinistro(Sinistro Sinistro);
    ResponseEntity<Sinistro> updateSinistro(int id, Sinistro sinistro);
    ResponseEntity<Void> deleteSinistro(int id);
}
