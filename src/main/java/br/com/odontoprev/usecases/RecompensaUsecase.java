package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.recompensa.CreateRecompensaDto;
import br.com.odontoprev.dto.recompensa.RecompensaDto;
import br.com.odontoprev.dto.recompensa.UpdateRecompensaDto;
import br.com.odontoprev.entities.Recompensa;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecompensaUsecase {
    ResponseEntity<List<RecompensaDto>> getAllRecompensas();
    ResponseEntity<RecompensaDto> getRecompensaById(int id);
    ResponseEntity<RecompensaDto> createRecompensa(CreateRecompensaDto recompensa);
    ResponseEntity<RecompensaDto> updateRecompensa(int id, UpdateRecompensaDto recompensa);
    ResponseEntity<Void> deleteRecompensa(int id);
}
