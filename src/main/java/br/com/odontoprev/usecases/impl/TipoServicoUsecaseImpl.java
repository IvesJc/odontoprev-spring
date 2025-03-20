package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.tipoServico.CreateTipoServicoDto;
import br.com.odontoprev.dto.tipoServico.TipoServicoDto;
import br.com.odontoprev.dto.tipoServico.UpdateTipoServicoDto;
import br.com.odontoprev.entities.TipoServico;
import br.com.odontoprev.mappers.TipoServicoMapper;
import br.com.odontoprev.repositories.TipoServicoRepository;
import br.com.odontoprev.usecases.TipoServicoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TipoServicoUsecaseImpl implements TipoServicoUsecase {

    private final TipoServicoRepository tipoServicoRepository;

    @Override
    public ResponseEntity<TipoServicoDto> getTipoServicoById(int id) {
        return tipoServicoRepository.findById(id)
                .map(TipoServico -> ResponseEntity.ok(
                        TipoServicoMapper.totipoServicoDto(TipoServico)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<TipoServicoDto>> getAllTipoServicos() {
        List<TipoServico> TipoServicoList = tipoServicoRepository.findAll();
        if (TipoServicoList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            List<TipoServicoDto> TipoServicoDtos = TipoServicoList.stream()
                    .map(TipoServicoMapper::totipoServicoDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(TipoServicoDtos);
        }
    }

    @Override
    public ResponseEntity<TipoServicoDto> createTipoServico(CreateTipoServicoDto createDto) {
        TipoServico TipoServico = TipoServicoMapper.toTipoServicoFromCreate(createDto);
        TipoServico = tipoServicoRepository.save(TipoServico);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TipoServicoMapper.totipoServicoDto(TipoServico));
    }

    @Override
    public ResponseEntity<TipoServicoDto> updateTipoServico(int id, UpdateTipoServicoDto updateDto) {
        return tipoServicoRepository.findById(id)
                .map(TipoServico -> {
                    TipoServico = TipoServicoMapper.toTipoServicoFromUpdate(updateDto, id);
                    TipoServico = tipoServicoRepository.save(TipoServico);
                    return ResponseEntity.ok(TipoServicoMapper.totipoServicoDto(TipoServico));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteTipoServico(int id) {
        if (!tipoServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoServicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
