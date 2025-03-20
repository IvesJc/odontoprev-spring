package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.tipoRecompensa.CreateTipoRecompensaDto;
import br.com.odontoprev.dto.tipoRecompensa.TipoRecompensaDto;
import br.com.odontoprev.dto.tipoRecompensa.UpdateTipoRecompensaDto;
import br.com.odontoprev.entities.TipoRecompensa;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoRecompensaUsecase {
    ResponseEntity<List<TipoRecompensaDto>> getAllTipoRecompensas();
    ResponseEntity<TipoRecompensaDto> getTipoRecompensaById(int id);
    ResponseEntity<TipoRecompensaDto> createTipoRecompensa(CreateTipoRecompensaDto tipoRecompensa);
    ResponseEntity<TipoRecompensaDto> updateTipoRecompensa(int id, UpdateTipoRecompensaDto tipoRecompensa);
    ResponseEntity<Void> deleteTipoRecompensa(int id);
}
