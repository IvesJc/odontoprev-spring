package br.com.odontoprev.gateways;


import br.com.odontoprev.dto.programaRelacionamentoStatus.CreateProgramaRelacionamentoStatusDto;
import br.com.odontoprev.dto.programaRelacionamentoStatus.ProgramaRelacionamentoStatusDto;
import br.com.odontoprev.dto.programaRelacionamentoStatus.UpdateProgramaRelacionamentoStatusDto;
import br.com.odontoprev.entities.ProgramaRelacionamentoStatus;
import br.com.odontoprev.usecases.impl.ProgramaRelacionamentoStatusUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programa-relacionamento-status")
@RequiredArgsConstructor
@Tag(name = "Programa Relacionamento Status", description = "Endpoints destinados para a classe Programa Relacionamento Status")

public class ProgramaRelacionamentoStatusController {

    private final ProgramaRelacionamentoStatusUsecaseImpl programaRelacionamentoStatusService;

    @GetMapping
    public ResponseEntity<List<ProgramaRelacionamentoStatusDto>> getAllProgramaRelacionamentoStatuses() {
        return programaRelacionamentoStatusService.getAllProgramaRelacionamentoStatus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaRelacionamentoStatusDto> getProgramaRelacionamentoStatusById(@PathVariable int id) {
        return programaRelacionamentoStatusService.getProgramaRelacionamentoStatusById(id);
    }

    @PostMapping
    public ResponseEntity<ProgramaRelacionamentoStatusDto> createProgramaRelacionamentoStatus(@RequestBody CreateProgramaRelacionamentoStatusDto status) {
        return programaRelacionamentoStatusService.createProgramaRelacionamentoStatus(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaRelacionamentoStatusDto> updateProgramaRelacionamentoStatus(@PathVariable int id, @RequestBody UpdateProgramaRelacionamentoStatusDto status) {
        return programaRelacionamentoStatusService.updateProgramaRelacionamentoStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramaRelacionamentoStatus(@PathVariable int id) {
        return programaRelacionamentoStatusService.deleteProgramaRelacionamentoStatusDto(id);
    }
}
