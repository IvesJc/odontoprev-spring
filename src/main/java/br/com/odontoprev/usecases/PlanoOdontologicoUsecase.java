package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.PlanoOdontologico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanoOdontologicoUsecase {
    ResponseEntity<List<PlanoOdontologico>> getAllPlanoOdontologicos();
    ResponseEntity<PlanoOdontologico> getPlanoOdontologicoById(int id);
    ResponseEntity<PlanoOdontologico> createPlanoOdontologico(PlanoOdontologico planoOdontologico);
    ResponseEntity<PlanoOdontologico> updatePlanoOdontologico(int id, PlanoOdontologico planoOdontologico);
    ResponseEntity<Void> deletePlanoOdontologico(int id);
}
