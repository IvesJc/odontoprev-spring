package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.tipoRecompensa.CreateTipoRecompensaDto;
import br.com.odontoprev.dto.tipoRecompensa.TipoRecompensaDto;
import br.com.odontoprev.dto.tipoRecompensa.UpdateTipoRecompensaDto;
import br.com.odontoprev.entities.TipoRecompensa;
import br.com.odontoprev.mappers.TipoRecompensaMapper;
import br.com.odontoprev.mappers.TipoServicoMapper;
import br.com.odontoprev.repositories.TipoRecompensaRepository;
import br.com.odontoprev.usecases.TipoRecompensaUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TipoRecompensaUsecaseImpl implements TipoRecompensaUsecase {

    private final TipoRecompensaRepository tipoRecompensaRepository;

    @Override
    public ResponseEntity<List<TipoRecompensaDto>> getAllTipoRecompensas() {
        List<TipoRecompensa> tipoRecompensas = tipoRecompensaRepository.findAll();
        return ResponseEntity.ok(TipoRecompensaMapper.toDtoList(tipoRecompensas));
    }

    @Override
    public ResponseEntity<TipoRecompensaDto> getTipoRecompensaById(int id) {
        Optional<TipoRecompensa> tipoRecompensaOpt = tipoRecompensaRepository.findById(id);
        return tipoRecompensaOpt.map(tipoRecompensa -> ResponseEntity.ok(TipoRecompensaMapper.toDto(tipoRecompensa))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TipoRecompensaDto> createTipoRecompensa(CreateTipoRecompensaDto createDto) {
        TipoRecompensa tipoRecompensa = TipoRecompensaMapper.toEntity(createDto);
        TipoRecompensa savedTipoRecompensa = tipoRecompensaRepository.save(tipoRecompensa);
        return ResponseEntity.ok(TipoRecompensaMapper.toDto(savedTipoRecompensa));
    }

    @Override
    public ResponseEntity<TipoRecompensaDto> updateTipoRecompensa(int id, UpdateTipoRecompensaDto updateDto) {
        Optional<TipoRecompensa> tipoRecompensaOpt = tipoRecompensaRepository.findById(id);
        if (tipoRecompensaOpt.isPresent()) {
            TipoRecompensa tipoRecompensa = tipoRecompensaOpt.get();
            tipoRecompensa = TipoRecompensaMapper.toEntity(updateDto);
            tipoRecompensa.setId(id);
            TipoRecompensa updatedTipoRecompensa = tipoRecompensaRepository.save(tipoRecompensa);
            return ResponseEntity.ok(TipoRecompensaMapper.toDto(updatedTipoRecompensa));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteTipoRecompensa(int id) {
        if (!tipoRecompensaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoRecompensaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
