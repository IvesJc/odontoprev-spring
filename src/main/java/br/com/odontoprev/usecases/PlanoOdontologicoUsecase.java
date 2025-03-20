package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.endereco.UpdateEnderecoDto;
import br.com.odontoprev.dto.plano.CreatePlanoDto;
import br.com.odontoprev.dto.plano.PlanoDto;
import br.com.odontoprev.dto.plano.UpdatePlanoDto;
import br.com.odontoprev.entities.PlanoOdontologico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanoOdontologicoUsecase {
    ResponseEntity<List<PlanoDto>> getAllPlanoOdontologicos();
    ResponseEntity<PlanoDto> getPlanoOdontologicoById(int id);
    ResponseEntity<PlanoDto> createPlanoOdontologico(CreatePlanoDto planoOdontologico);
    ResponseEntity<PlanoDto> updatePlanoOdontologico(int id, UpdatePlanoDto planoOdontologico);
    ResponseEntity<Void> deletePlanoOdontologico(int id);
}
