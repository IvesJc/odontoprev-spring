package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.PrestadorServico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrestadorServicoUsecase {
    ResponseEntity<List<PrestadorServico>> getAllPrestadores();
    ResponseEntity<PrestadorServico> getPrestadorById(int id);
    ResponseEntity<PrestadorServico> createPrestador(PrestadorServico prestador);
    ResponseEntity<PrestadorServico> updatePrestador(int id, PrestadorServico prestador);
    ResponseEntity<Void> deletePrestador(int id);
}
