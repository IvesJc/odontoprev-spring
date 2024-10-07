package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.ProgramaRelacionamentoStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProgramaRelacionamentoStatusUsecase {
    ResponseEntity<List<ProgramaRelacionamentoStatus>> getAllProgramaRelacionamentoStatus();
    ResponseEntity<ProgramaRelacionamentoStatus> getProgramaRelacionamentoStatusById(int id);
    ResponseEntity<ProgramaRelacionamentoStatus> createProgramaRelacionamentoStatus(ProgramaRelacionamentoStatus prestador);
    ResponseEntity<ProgramaRelacionamentoStatus> updateProgramaRelacionamentoStatus(int id, ProgramaRelacionamentoStatus prestador);
    ResponseEntity<Void> deleteProgramaRelacionamentoStatus(int id);
}
