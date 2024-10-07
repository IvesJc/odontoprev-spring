package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.ProgramaRelacionamentoStatus;
import br.com.odontoprev.repositories.ProgramaRelacionamentoStatusRepository;
import br.com.odontoprev.usecases.ProgramaRelacionamentoStatusUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProgramaRelacionamentoStatusUsecaseImpl implements ProgramaRelacionamentoStatusUsecase {

    private final ProgramaRelacionamentoStatusRepository programaRelacionamentoStatusRepository;


    @Override
    public ResponseEntity<List<ProgramaRelacionamentoStatus>> getAllProgramaRelacionamentoStatus() {
        List<ProgramaRelacionamentoStatus> programaRelacionamentoStatuses = programaRelacionamentoStatusRepository.findAll();
        return ResponseEntity.ok(programaRelacionamentoStatuses);
    }

    @Override
    public ResponseEntity<ProgramaRelacionamentoStatus> getProgramaRelacionamentoStatusById(int id) {
        return programaRelacionamentoStatusRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<ProgramaRelacionamentoStatus> createProgramaRelacionamentoStatus(ProgramaRelacionamentoStatus programaRelacionamentoStatus) {
        ProgramaRelacionamentoStatus savedProgramaRelacionamentoStatus = programaRelacionamentoStatusRepository.save(programaRelacionamentoStatus);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProgramaRelacionamentoStatus);
    }

    @Override
    public ResponseEntity<ProgramaRelacionamentoStatus> updateProgramaRelacionamentoStatus(int id, ProgramaRelacionamentoStatus programaRelacionamentoStatus) {
        if (!programaRelacionamentoStatusRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        programaRelacionamentoStatus.setId(id);
        ProgramaRelacionamentoStatus updatedPrestador = programaRelacionamentoStatusRepository.save(programaRelacionamentoStatus);
        return ResponseEntity.ok(updatedPrestador);
    }

    @Override
    public ResponseEntity<Void> deleteProgramaRelacionamentoStatus(int id) {
        if (!programaRelacionamentoStatusRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        programaRelacionamentoStatusRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
