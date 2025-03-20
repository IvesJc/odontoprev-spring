package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.redeCredenciada.CreateRedeCredenciadaDto;
import br.com.odontoprev.dto.redeCredenciada.RedeCredenciadaDto;
import br.com.odontoprev.dto.redeCredenciada.UpdateRedeCredenciadaDto;
import br.com.odontoprev.entities.RedeCredenciada;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RedeCredenciadaUsecase {
    ResponseEntity<List<RedeCredenciadaDto>> getAllRedeCredenciada();
    ResponseEntity<RedeCredenciadaDto> getRedeCredenciadaById(int id);
    ResponseEntity<RedeCredenciadaDto> createRedeCredenciada(CreateRedeCredenciadaDto redeCredenciada);
    ResponseEntity<RedeCredenciadaDto> updateRedeCredenciada(int id, UpdateRedeCredenciadaDto redeCredenciada);
    ResponseEntity<Void> deleteRedeCredenciada(int id);
}
