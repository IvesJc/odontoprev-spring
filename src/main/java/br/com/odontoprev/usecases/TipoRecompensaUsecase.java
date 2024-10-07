package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.TipoRecompensa;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoRecompensaUsecase {
    ResponseEntity<List<TipoRecompensa>> getAllTipoRecompensas();
    ResponseEntity<TipoRecompensa> getTipoRecompensaById(int id);
    ResponseEntity<TipoRecompensa> createTipoRecompensa(TipoRecompensa tipoRecompensa);
    ResponseEntity<TipoRecompensa> updateTipoRecompensa(int id, TipoRecompensa tipoRecompensa);
    ResponseEntity<Void> deleteTipoRecompensa(int id);
}
