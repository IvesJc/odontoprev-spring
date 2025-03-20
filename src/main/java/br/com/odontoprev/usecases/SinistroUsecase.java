package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.servico.UpdateServicoDto;
import br.com.odontoprev.dto.sinistro.CreateSinistroDto;
import br.com.odontoprev.dto.sinistro.SinistroDto;
import br.com.odontoprev.dto.sinistro.UpdateSinistroDto;
import br.com.odontoprev.entities.Sinistro;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SinistroUsecase {
    ResponseEntity<List<SinistroDto>> getAllSinistros();
    ResponseEntity<SinistroDto> getSinistroById(int id);
    ResponseEntity<SinistroDto> createSinistro(CreateSinistroDto Sinistro);
    ResponseEntity<SinistroDto> updateSinistro(int id, UpdateSinistroDto sinistro);
    ResponseEntity<Void> deleteSinistro(int id);
}
