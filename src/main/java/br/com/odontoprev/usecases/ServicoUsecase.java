package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.Servico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicoUsecase {
    ResponseEntity<List<Servico>> getAllServicos();
    ResponseEntity<Servico> getServicoById(int id);
    ResponseEntity<Servico> createServico(Servico servico);
    ResponseEntity<Servico> updateServico(int id, Servico servico);
    ResponseEntity<Void> deleteServico(int id);
}
