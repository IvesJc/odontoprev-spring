package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.programaRelacionamentoStatus.CreateProgramaRelacionamentoStatusDto;
import br.com.odontoprev.dto.programaRelacionamentoStatus.ProgramaRelacionamentoStatusDto;
import br.com.odontoprev.dto.programaRelacionamentoStatus.UpdateProgramaRelacionamentoStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProgramaRelacionamentoStatusUsecase {
    ResponseEntity<List<ProgramaRelacionamentoStatusDto>> getAllProgramaRelacionamentoStatus();
    ResponseEntity<ProgramaRelacionamentoStatusDto> getProgramaRelacionamentoStatusById(int id);
    ResponseEntity<ProgramaRelacionamentoStatusDto> createProgramaRelacionamentoStatus(CreateProgramaRelacionamentoStatusDto prestador);
    ResponseEntity<ProgramaRelacionamentoStatusDto> updateProgramaRelacionamentoStatus(int id,
                                                                                          UpdateProgramaRelacionamentoStatusDto prestador);
    ResponseEntity<Void> deleteProgramaRelacionamentoStatusDto(int id);
}
