package br.com.odontoprev.gateways;


import br.com.odontoprev.entities.ProgramaRelacionamentoStatus;
import br.com.odontoprev.usecases.impl.ProgramaRelacionamentoStatusUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programa-relacionamento-status")
@RequiredArgsConstructor
public class ProgramaRelacionamentoStatusController {

    private final ProgramaRelacionamentoStatusUsecaseImpl programaRelacionamentoStatusService;

    @GetMapping
    public ResponseEntity<List<ProgramaRelacionamentoStatus>> getAllProgramaRelacionamentoStatuses() {
        return programaRelacionamentoStatusService.getAllProgramaRelacionamentoStatus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaRelacionamentoStatus> getProgramaRelacionamentoStatusById(@PathVariable int id) {
        return programaRelacionamentoStatusService.getProgramaRelacionamentoStatusById(id);
    }

    @PostMapping
    public ResponseEntity<ProgramaRelacionamentoStatus> createProgramaRelacionamentoStatus(@RequestBody ProgramaRelacionamentoStatus status) {
        return programaRelacionamentoStatusService.createProgramaRelacionamentoStatus(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaRelacionamentoStatus> updateProgramaRelacionamentoStatus(@PathVariable int id, @RequestBody ProgramaRelacionamentoStatus status) {
        return programaRelacionamentoStatusService.updateProgramaRelacionamentoStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramaRelacionamentoStatus(@PathVariable int id) {
        return programaRelacionamentoStatusService.deleteProgramaRelacionamentoStatus(id);
    }
}
