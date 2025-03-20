package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.servico.CreateServicoDto;
import br.com.odontoprev.dto.servico.ServicoDto;
import br.com.odontoprev.dto.servico.UpdateServicoDto;
import br.com.odontoprev.entities.Servico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicoUsecase {
    ResponseEntity<List<ServicoDto>> getAllServicos();
    ResponseEntity<ServicoDto> getServicoById(int id);
    ResponseEntity<ServicoDto> createServico(CreateServicoDto servico);
    ResponseEntity<ServicoDto> updateServico(int id, UpdateServicoDto servico);
    ResponseEntity<Void> deleteServico(int id);
}
