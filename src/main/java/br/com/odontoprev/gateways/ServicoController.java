package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.servico.CreateServicoDto;
import br.com.odontoprev.dto.servico.ServicoDto;
import br.com.odontoprev.dto.servico.UpdateServicoDto;
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
    public ResponseEntity<List<ServicoDto>> getAllServicos() {
        return servicoService.getAllServicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDto> getServicoById(@PathVariable int id) {
        return servicoService.getServicoById(id);
    }

    @PostMapping
    public ResponseEntity<ServicoDto> createServico(@RequestBody CreateServicoDto servico) {
        return servicoService.createServico(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDto> updateServico(@PathVariable int id,
                                                    @RequestBody UpdateServicoDto servicoDetails) {
        return servicoService.updateServico(id, servicoDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable int id) {
        return servicoService.deleteServico(id);
    }
}