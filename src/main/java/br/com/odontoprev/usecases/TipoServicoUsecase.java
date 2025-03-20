package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.tipoServico.CreateTipoServicoDto;
import br.com.odontoprev.dto.tipoServico.TipoServicoDto;
import br.com.odontoprev.dto.tipoServico.UpdateTipoServicoDto;
import br.com.odontoprev.entities.TipoServico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoServicoUsecase {
    ResponseEntity<List<TipoServicoDto>> getAllTipoServicos();
    ResponseEntity<TipoServicoDto> getTipoServicoById(int id);
    ResponseEntity<TipoServicoDto> createTipoServico(CreateTipoServicoDto tipoServico);
    ResponseEntity<TipoServicoDto> updateTipoServico(int id, UpdateTipoServicoDto tipoServico);
    ResponseEntity<Void> deleteTipoServico(int id);
}
