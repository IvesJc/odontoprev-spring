package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.recompensa.CreateRecompensaDto;
import br.com.odontoprev.dto.recompensa.RecompensaDto;
import br.com.odontoprev.dto.recompensa.UpdateRecompensaDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.entities.Recompensa;
import br.com.odontoprev.entities.TipoRecompensa;
import br.com.odontoprev.mappers.RecompensaMapper;
import br.com.odontoprev.repositories.BeneficiarioRepository;
import br.com.odontoprev.repositories.RecompensaRepository;
import br.com.odontoprev.repositories.TipoRecompensaRepository;
import br.com.odontoprev.usecases.RecompensaUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecompensaUsecaseImpl implements RecompensaUsecase {

    private final RecompensaRepository recompensaRepository;

    private final BeneficiarioRepository beneficiarioRepository;

    private final TipoRecompensaRepository tipoRecompensaRepository;

    // Método para obter todas as recompensas
    public ResponseEntity<List<RecompensaDto>> getAllRecompensas() {
        List<Recompensa> recompensas = recompensaRepository.findAll();
        List<RecompensaDto> recompensasDto = recompensas.stream()
                .map(RecompensaMapper::toRecompensaDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(recompensasDto);
    }

    // Método para obter uma recompensa por ID
    public ResponseEntity<RecompensaDto> getRecompensaById(int id) {
        return recompensaRepository.findById(id)
                .map(recompensa -> ResponseEntity.ok(RecompensaMapper.toRecompensaDto(recompensa)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para criar uma nova recompensa
    public ResponseEntity<RecompensaDto> createRecompensa(CreateRecompensaDto createDto) {
        Recompensa recompensa = RecompensaMapper.toRecompensaFromCreate(createDto);

        // Buscar o Beneficiario pelo ID
        Beneficiario beneficiario = beneficiarioRepository.findById(createDto.beneficiarioId())
                .orElseThrow(() -> new NoSuchElementException("Beneficiario não encontrado"));
        recompensa.setBeneficiario(beneficiario);

        // Buscar o TipoRecompensa pelo ID
        TipoRecompensa tipoRecompensa = tipoRecompensaRepository.findById(createDto.tipoRecompensaId())
                .orElseThrow(() -> new NoSuchElementException("Tipo de recompensa não encontrado"));
        recompensa.setTipoRecompensa(tipoRecompensa);

        Recompensa savedRecompensa = recompensaRepository.save(recompensa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RecompensaMapper.toRecompensaDto(savedRecompensa));
    }

    // Método para atualizar uma recompensa existente
    public ResponseEntity<RecompensaDto> updateRecompensa(int id, UpdateRecompensaDto updateDto) {
        if (!recompensaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Recompensa recompensa = RecompensaMapper.toRecompensaFromUpdate(updateDto);
        recompensa.setId(id);

        // Buscar o Beneficiario pelo ID
        Beneficiario beneficiario = beneficiarioRepository.findById(updateDto.beneficiarioId())
                .orElseThrow(() -> new NoSuchElementException("Beneficiario não encontrado"));
        recompensa.setBeneficiario(beneficiario);

        // Buscar o TipoRecompensa pelo ID
        TipoRecompensa tipoRecompensa = tipoRecompensaRepository.findById(updateDto.tipoRecompensaId())
                .orElseThrow(() -> new NoSuchElementException("Tipo de recompensa não encontrado"));
        recompensa.setTipoRecompensa(tipoRecompensa);

        Recompensa updatedRecompensa = recompensaRepository.save(recompensa);
        return ResponseEntity.ok(RecompensaMapper.toRecompensaDto(updatedRecompensa));
    }

    @Override
    public ResponseEntity<Void> deleteRecompensa(int id) {
        if (!recompensaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        recompensaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
