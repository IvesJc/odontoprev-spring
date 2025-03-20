package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.tipoServico.CreateTipoServicoDto;
import br.com.odontoprev.dto.tipoServico.TipoServicoDto;
import br.com.odontoprev.dto.tipoServico.UpdateTipoServicoDto;
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
    public ResponseEntity<List<TipoServicoDto>> getAllTiposServico() {
        return tipoServicoService.getAllTipoServicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoServicoDto> getTipoServicoById(@PathVariable int id) {
        return tipoServicoService.getTipoServicoById(id);
    }

    @PostMapping
    public ResponseEntity<TipoServicoDto> createTipoServico(@RequestBody CreateTipoServicoDto tipoServico) {
        return tipoServicoService.createTipoServico(tipoServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoServicoDto> updateTipoServico(@PathVariable int id,
                                                            @RequestBody UpdateTipoServicoDto tipoServicoDetails) {
        return tipoServicoService.updateTipoServico(id, tipoServicoDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoServico(@PathVariable int id) {
        return tipoServicoService.deleteTipoServico(id);
    }
}