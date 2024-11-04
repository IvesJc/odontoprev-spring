package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.Servico;
import br.com.odontoprev.usecases.impl.ServicoUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@RequiredArgsConstructor
@Tag(name = "Servico", description = "Endpoints destinados para a classe Servico")

public class ServicoController {

    private final ServicoUsecaseImpl servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> getAllServicos() {
        return servicoService.getAllServicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable int id) {
        return servicoService.getServicoById(id);
    }

    @PostMapping
    public ResponseEntity<Servico> createServico(@RequestBody Servico servico) {
        return servicoService.createServico(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable int id, @RequestBody Servico servicoDetails) {
        return servicoService.updateServico(id, servicoDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable int id) {
        return servicoService.deleteServico(id);
    }
}