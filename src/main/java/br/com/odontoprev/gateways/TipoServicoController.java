package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.TipoServico;
import br.com.odontoprev.usecases.impl.TipoServicoUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-servico")
@RequiredArgsConstructor
@Tag(name = "Tipo Servico", description = "Endpoints destinados para a classe Tipo Servico")

public class TipoServicoController {

    private final TipoServicoUsecaseImpl tipoServicoService;

    @GetMapping
    public ResponseEntity<List<TipoServico>> getAllTiposServico() {
        return tipoServicoService.getAllTipoServicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoServico> getTipoServicoById(@PathVariable int id) {
        return tipoServicoService.getTipoServicoById(id);
    }

    @PostMapping
    public ResponseEntity<TipoServico> createTipoServico(@RequestBody TipoServico tipoServico) {
        return tipoServicoService.createTipoServico(tipoServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoServico> updateTipoServico(@PathVariable int id, @RequestBody TipoServico tipoServicoDetails) {
        return tipoServicoService.updateTipoServico(id, tipoServicoDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoServico(@PathVariable int id) {
        return tipoServicoService.deleteTipoServico(id);
    }
}