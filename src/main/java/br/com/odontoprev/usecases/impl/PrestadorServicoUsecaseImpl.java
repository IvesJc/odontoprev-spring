package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.prestadorServico.CreatePrestadorServicoDto;
import br.com.odontoprev.dto.prestadorServico.PrestadorServicoDto;
import br.com.odontoprev.dto.prestadorServico.UpdatePrestadorServicoDto;
import br.com.odontoprev.entities.PrestadorServico;
import br.com.odontoprev.entities.RedeCredenciada;
import br.com.odontoprev.mappers.PrestadorServicoMapper;
import br.com.odontoprev.repositories.PrestadorServicoRepository;
import br.com.odontoprev.repositories.RedeCredenciadaRepository;
import br.com.odontoprev.usecases.PrestadorServicoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PrestadorServicoUsecaseImpl implements PrestadorServicoUsecase {

    private final PrestadorServicoRepository prestadorServicoRepository;

    private final RedeCredenciadaRepository redeCredenciadaRepository;

    public ResponseEntity<List<PrestadorServicoDto>> getAllPrestadores() {
        List<PrestadorServico> prestadores = prestadorServicoRepository.findAll();
        List<PrestadorServicoDto> prestadoresDto = prestadores.stream()
                .map(PrestadorServicoMapper::toPrestadorServicoDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(prestadoresDto);
    }

    public ResponseEntity<PrestadorServicoDto> getPrestadorById(int id) {
        return prestadorServicoRepository.findById(id)
                .map(prestador -> ResponseEntity.ok(PrestadorServicoMapper.toPrestadorServicoDto(prestador)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PrestadorServicoDto> createPrestador(CreatePrestadorServicoDto createDto) {
        PrestadorServico prestador = PrestadorServicoMapper.toPrestadorServicoFromCreate(createDto);

        // Buscar a RedeCredenciada pelo ID
        RedeCredenciada redeCredenciada =
                redeCredenciadaRepository.findById(createDto.redeCredenciadaId()).orElseThrow(() -> new NoSuchElementException(
                        "RedeCredenciada não encontrada"));
        prestador.setRedeCredenciada(redeCredenciada);

        PrestadorServico savedPrestador = prestadorServicoRepository.save(prestador);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PrestadorServicoMapper.toPrestadorServicoDto(savedPrestador));
    }

    public ResponseEntity<PrestadorServicoDto> updatePrestador(int id, UpdatePrestadorServicoDto updateDto) {
        if (!prestadorServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        PrestadorServico prestador = PrestadorServicoMapper.toPrestadorServicoFromUpdate(updateDto);
        prestador.setId(id);

        // Buscar a RedeCredenciada pelo ID
        RedeCredenciada redeCredenciada =
                redeCredenciadaRepository.findById(updateDto.redeCredenciadaId()).orElseThrow(() -> new NoSuchElementException(
                        "RedeCredenciada não encontrada"));
        prestador.setRedeCredenciada(redeCredenciada);

        PrestadorServico updatedPrestador = prestadorServicoRepository.save(prestador);
        return ResponseEntity.ok(PrestadorServicoMapper.toPrestadorServicoDto(updatedPrestador));
    }

    @Override
    public ResponseEntity<Void> deletePrestador(int id) {
        if (!prestadorServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        prestadorServicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
