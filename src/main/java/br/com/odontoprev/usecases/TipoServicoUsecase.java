package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.TipoServico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoServicoUsecase {
    ResponseEntity<List<TipoServico>> getAllTipoServicos();
    ResponseEntity<TipoServico> getTipoServicoById(int id);
    ResponseEntity<TipoServico> createTipoServico(TipoServico tipoServico);
    ResponseEntity<TipoServico> updateTipoServico(int id, TipoServico tipoServico);
    ResponseEntity<Void> deleteTipoServico(int id);
}
