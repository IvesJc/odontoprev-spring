package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.redeCredenciada.CreateRedeCredenciadaDto;
import br.com.odontoprev.dto.redeCredenciada.RedeCredenciadaDto;
import br.com.odontoprev.dto.redeCredenciada.UpdateRedeCredenciadaDto;
import br.com.odontoprev.entities.RedeCredenciada;
import br.com.odontoprev.mappers.RedeCredenciadaMapper;
import br.com.odontoprev.repositories.RedeCredenciadaRepository;
import br.com.odontoprev.usecases.RedeCredenciadaUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RedeCredenciadaUsecaseImpl implements RedeCredenciadaUsecase {

    private final RedeCredenciadaRepository redeCredenciadaRepository;

    @Override
    public ResponseEntity<List<RedeCredenciadaDto>> getAllRedeCredenciada() {
        List<RedeCredenciada> redesCredenciadas = redeCredenciadaRepository.findAll();
        List<RedeCredenciadaDto> redesCredenciadasDto = redesCredenciadas.stream()
                .map(RedeCredenciadaMapper::toRedeCredenciadaDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(redesCredenciadasDto);
    }

    @Override
    public ResponseEntity<RedeCredenciadaDto> getRedeCredenciadaById(int id) {
        return redeCredenciadaRepository.findById(id)
                .map(redeCredenciada -> ResponseEntity.ok(RedeCredenciadaMapper.toRedeCredenciadaDto(redeCredenciada)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<RedeCredenciadaDto> createRedeCredenciada(CreateRedeCredenciadaDto createDto) {
        RedeCredenciada redeCredenciada = RedeCredenciadaMapper.toRedeCredenciadaFromCreate(createDto);
        RedeCredenciada savedRedeCredenciada = redeCredenciadaRepository.save(redeCredenciada);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RedeCredenciadaMapper.toRedeCredenciadaDto(savedRedeCredenciada));
    }

    @Override
    public ResponseEntity<RedeCredenciadaDto> updateRedeCredenciada(int id, UpdateRedeCredenciadaDto updateDto) {
        if (!redeCredenciadaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        RedeCredenciada redeCredenciada = RedeCredenciadaMapper.toRedeCredenciadaFromUpdate(updateDto);
        redeCredenciada.setId(id);

        RedeCredenciada updatedRedeCredenciada = redeCredenciadaRepository.save(redeCredenciada);
        return ResponseEntity.ok(RedeCredenciadaMapper.toRedeCredenciadaDto(updatedRedeCredenciada));
    }

    @Override
    public ResponseEntity<Void> deleteRedeCredenciada(int id) {
        if (!redeCredenciadaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        redeCredenciadaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
