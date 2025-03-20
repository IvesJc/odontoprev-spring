package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.prestadorServico.CreatePrestadorServicoDto;
import br.com.odontoprev.dto.prestadorServico.PrestadorServicoDto;
import br.com.odontoprev.dto.prestadorServico.UpdatePrestadorServicoDto;
import br.com.odontoprev.entities.PrestadorServico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrestadorServicoUsecase {
    ResponseEntity<List<PrestadorServicoDto>> getAllPrestadores();
    ResponseEntity<PrestadorServicoDto> getPrestadorById(int id);
    ResponseEntity<PrestadorServicoDto> createPrestador(CreatePrestadorServicoDto prestador);
    ResponseEntity<PrestadorServicoDto> updatePrestador(int id, UpdatePrestadorServicoDto prestador);
    ResponseEntity<Void> deletePrestador(int id);
}
