package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.tipoPlano.CreateTipoPlanoDto;
import br.com.odontoprev.dto.tipoPlano.TipoPlanoDto;
import br.com.odontoprev.dto.tipoPlano.UpdateTipoPlanoDto;
import br.com.odontoprev.entities.TipoPlanoOdontologico;
import br.com.odontoprev.mappers.TipoPlanoOdontologicoMapper;
import br.com.odontoprev.repositories.TipoPlanoOdontologicoRepository;
import br.com.odontoprev.usecases.TipoPlanoOdontologicoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TipoPlanoOdontologicoUsecaseImpl implements TipoPlanoOdontologicoUsecase {

    private final TipoPlanoOdontologicoRepository tipoPlanoOdontologicoRepository;
    @Override
    public ResponseEntity<List<TipoPlanoDto>> getAllTipoPlano() {
        List<TipoPlanoOdontologico> tipoPlanoOdontologicos = tipoPlanoOdontologicoRepository.findAll();
        return ResponseEntity.ok(TipoPlanoOdontologicoMapper.toDtoList(tipoPlanoOdontologicos));
    }

    @Override
    public ResponseEntity<TipoPlanoDto> getTipoPlanoById(int id) {
        Optional<TipoPlanoOdontologico> tipoPlanoOdontologicoOpt = tipoPlanoOdontologicoRepository.findById(id);
        return tipoPlanoOdontologicoOpt.map(tipoPlanoOdontologico -> ResponseEntity.ok(TipoPlanoOdontologicoMapper.toDto(tipoPlanoOdontologico))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Override
    public ResponseEntity<TipoPlanoDto> createTipoPlano(CreateTipoPlanoDto createDto) {
        TipoPlanoOdontologico tipoPlanoOdontologico = TipoPlanoOdontologicoMapper.toEntity(createDto);
        TipoPlanoOdontologico savedTipoPlanoOdontologico = tipoPlanoOdontologicoRepository.save(tipoPlanoOdontologico);
        return ResponseEntity.ok(TipoPlanoOdontologicoMapper.toDto(savedTipoPlanoOdontologico));
    }

    @Override
    public ResponseEntity<TipoPlanoDto> updateTipoPlano(int id, UpdateTipoPlanoDto updateDto) {
        Optional<TipoPlanoOdontologico> tipoPlanoOdontologicoOpt = tipoPlanoOdontologicoRepository.findById(id);
        if (tipoPlanoOdontologicoOpt.isPresent()) {
            TipoPlanoOdontologico tipoPlanoOdontologico = tipoPlanoOdontologicoOpt.get();
            tipoPlanoOdontologico = TipoPlanoOdontologicoMapper.toEntity(updateDto);
            tipoPlanoOdontologico.setId(id);
            TipoPlanoOdontologico updatedTipoPlanoOdontologico = tipoPlanoOdontologicoRepository.save(tipoPlanoOdontologico);
            return ResponseEntity.ok(TipoPlanoOdontologicoMapper.toDto(updatedTipoPlanoOdontologico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteTipoPlanoOdontologico(int id) {
        if (!tipoPlanoOdontologicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoPlanoOdontologicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
