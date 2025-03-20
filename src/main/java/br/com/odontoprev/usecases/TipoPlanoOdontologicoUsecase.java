package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.tipoPlano.CreateTipoPlanoDto;
import br.com.odontoprev.dto.tipoPlano.TipoPlanoDto;
import br.com.odontoprev.dto.tipoPlano.UpdateTipoPlanoDto;
import br.com.odontoprev.entities.TipoPlanoOdontologico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoPlanoOdontologicoUsecase {
    ResponseEntity<List<TipoPlanoDto>> getAllTipoPlano();
    ResponseEntity<TipoPlanoDto> getTipoPlanoById(int id);
    ResponseEntity<TipoPlanoDto> createTipoPlano(CreateTipoPlanoDto tipoPlanoOdontologico);
    ResponseEntity<TipoPlanoDto> updateTipoPlano(int id, UpdateTipoPlanoDto tipoPlanoOdontologico);
    ResponseEntity<Void> deleteTipoPlanoOdontologico(int id);
}
