package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.TipoPlanoOdontologico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoPlanoOdontologicoUsecase {
    ResponseEntity<List<TipoPlanoOdontologico>> getAllTipoPlanoOdontologicos();
    ResponseEntity<TipoPlanoOdontologico> getTipoPlanoOdontologicoById(int id);
    ResponseEntity<TipoPlanoOdontologico> createTipoPlanoOdontologico(TipoPlanoOdontologico tipoPlanoOdontologico);
    ResponseEntity<TipoPlanoOdontologico> updateTipoPlanoOdontologico(int id, TipoPlanoOdontologico tipoPlanoOdontologico);
    ResponseEntity<Void> deleteTipoPlanoOdontologico(int id);
}
