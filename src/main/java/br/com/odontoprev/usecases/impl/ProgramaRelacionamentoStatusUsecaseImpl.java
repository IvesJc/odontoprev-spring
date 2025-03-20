package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.programaRelacionamentoStatus.CreateProgramaRelacionamentoStatusDto;
import br.com.odontoprev.dto.programaRelacionamentoStatus.ProgramaRelacionamentoStatusDto;
import br.com.odontoprev.dto.programaRelacionamentoStatus.UpdateProgramaRelacionamentoStatusDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.entities.ProgramaRelacionamentoStatus;
import br.com.odontoprev.mappers.ProgramaRelacionamentoStatusMapper;
import br.com.odontoprev.repositories.BeneficiarioRepository;
import br.com.odontoprev.repositories.ProgramaRelacionamentoStatusRepository;
import br.com.odontoprev.usecases.ProgramaRelacionamentoStatusUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProgramaRelacionamentoStatusUsecaseImpl implements ProgramaRelacionamentoStatusUsecase {

    private final ProgramaRelacionamentoStatusRepository programaRelacionamentoStatusRepository;

    private final BeneficiarioRepository beneficiarioRepository;

    @Override
    public ResponseEntity<List<ProgramaRelacionamentoStatusDto>> getAllProgramaRelacionamentoStatus() {
        List<ProgramaRelacionamentoStatus> programas = programaRelacionamentoStatusRepository.findAll();
        List<ProgramaRelacionamentoStatusDto> programasDto = programas.stream()
                .map(ProgramaRelacionamentoStatusMapper::toProgramaRelacionamentoStatusDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(programasDto);
    }

    public ResponseEntity<ProgramaRelacionamentoStatusDto> getProgramaRelacionamentoStatusById(int id) {
        return programaRelacionamentoStatusRepository.findById(id)
                .map(programa -> ResponseEntity.ok(ProgramaRelacionamentoStatusMapper.toProgramaRelacionamentoStatusDto(programa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<ProgramaRelacionamentoStatusDto> createProgramaRelacionamentoStatus(CreateProgramaRelacionamentoStatusDto createDto) {
        ProgramaRelacionamentoStatus programa = ProgramaRelacionamentoStatusMapper.toProgramaRelacionamentoStatusFromCreate(createDto);

        // Buscar o Beneficiario pelo ID
        Beneficiario beneficiario =
                beneficiarioRepository.findById(createDto.beneficiarioId()).orElseThrow(() -> new NoSuchElementException(
                        "Beneficiario não encontrado"));
        programa.setBeneficiario(beneficiario);

        ProgramaRelacionamentoStatus savedPrograma = programaRelacionamentoStatusRepository.save(programa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProgramaRelacionamentoStatusMapper.toProgramaRelacionamentoStatusDto(savedPrograma));
    }

    @Override
    public ResponseEntity<ProgramaRelacionamentoStatusDto> updateProgramaRelacionamentoStatus(int id, UpdateProgramaRelacionamentoStatusDto updateDto) {
        if (!programaRelacionamentoStatusRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        ProgramaRelacionamentoStatus programa = ProgramaRelacionamentoStatusMapper.toProgramaRelacionamentoStatusFromUpdate(updateDto);
        programa.setId(id);

        // Buscar o Beneficiario pelo ID
        Beneficiario beneficiario = beneficiarioRepository.findById(updateDto.beneficiarioId()).orElseThrow(() -> new NoSuchElementException("Beneficiario não encontrado"));
        programa.setBeneficiario(beneficiario);

        ProgramaRelacionamentoStatus updatedPrograma = programaRelacionamentoStatusRepository.save(programa);
        return ResponseEntity.ok(ProgramaRelacionamentoStatusMapper.toProgramaRelacionamentoStatusDto(updatedPrograma));
    }

    @Override
    public ResponseEntity<Void> deleteProgramaRelacionamentoStatusDto(int id) {
        if (!programaRelacionamentoStatusRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        programaRelacionamentoStatusRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
