package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.sinistro.CreateSinistroDto;
import br.com.odontoprev.dto.sinistro.SinistroDto;
import br.com.odontoprev.dto.sinistro.UpdateSinistroDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.entities.PrestadorServico;
import br.com.odontoprev.entities.Sinistro;
import br.com.odontoprev.mappers.SinistroMapper;
import br.com.odontoprev.repositories.BeneficiarioRepository;
import br.com.odontoprev.repositories.PrestadorServicoRepository;
import br.com.odontoprev.repositories.SinistroRepository;
import br.com.odontoprev.usecases.SinistroUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SinistroUsecaseImpl implements SinistroUsecase {

    private final SinistroRepository sinistroRepository;

    private final BeneficiarioRepository beneficiarioRepository;

    private final PrestadorServicoRepository prestadorServicoRepository;

    @Override
    public ResponseEntity<List<SinistroDto>> getAllSinistros() {
        List<Sinistro> sinistros = sinistroRepository.findAll();
        List<SinistroDto> sinistrosDto = sinistros.stream()
                .map(SinistroMapper::toSinistroDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(sinistrosDto);
    }

    @Override
    public ResponseEntity<SinistroDto> getSinistroById(int id) {
        return sinistroRepository.findById(id)
                .map(sinistro -> ResponseEntity.ok(SinistroMapper.toSinistroDto(sinistro)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<SinistroDto> createSinistro(CreateSinistroDto createDto) {
        Beneficiario beneficiario = beneficiarioRepository.findById(createDto.beneficiarioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beneficiário não encontrado"));

        PrestadorServico prestadorServico = prestadorServicoRepository.findById(createDto.prestadorServicoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prestador de serviço não encontrado"));

        Sinistro sinistro = SinistroMapper.toSinistroFromCreate(createDto, beneficiario, prestadorServico);
        Sinistro savedSinistro = sinistroRepository.save(sinistro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SinistroMapper.toSinistroDto(savedSinistro));
    }

    @Override
    public ResponseEntity<SinistroDto> updateSinistro(int id, UpdateSinistroDto updateDto) {
        if (!sinistroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Beneficiario beneficiario = beneficiarioRepository.findById(updateDto.beneficiarioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beneficiário não encontrado"));

        PrestadorServico prestadorServico = prestadorServicoRepository.findById(updateDto.prestadorServicoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prestador de serviço não encontrado"));

        Sinistro sinistro = SinistroMapper.toSinistroFromUpdate(updateDto, id, beneficiario, prestadorServico);
        Sinistro updatedSinistro = sinistroRepository.save(sinistro);
        return ResponseEntity.ok(SinistroMapper.toSinistroDto(updatedSinistro));
    }

    @Override
    public ResponseEntity<Void> deleteSinistro(int id) {
        if (!sinistroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sinistroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
