package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.prestadorServico.CreatePrestadorServicoDto;
import br.com.odontoprev.dto.prestadorServico.PrestadorServicoDto;
import br.com.odontoprev.dto.prestadorServico.UpdatePrestadorServicoDto;
import br.com.odontoprev.entities.PrestadorServico;
import br.com.odontoprev.usecases.impl.PrestadorServicoUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestadores")
@RequiredArgsConstructor
@Tag(name = "Prestador Servico", description = "Endpoints destinados para a classe Prestador Servico")

public class PrestadorServicoController {

    private final PrestadorServicoUsecaseImpl prestadorServicoService;

    @GetMapping
    public ResponseEntity<List<PrestadorServicoDto>> getAllPrestadores() {
        return prestadorServicoService.getAllPrestadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestadorServicoDto> getPrestadorById(@PathVariable int id) {
        return prestadorServicoService.getPrestadorById(id);
    }

    @PostMapping
    public ResponseEntity<PrestadorServicoDto> createPrestador(@RequestBody CreatePrestadorServicoDto prestador) {
        return prestadorServicoService.createPrestador(prestador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestadorServicoDto> updatePrestador(@PathVariable int id,
                                                               @RequestBody UpdatePrestadorServicoDto prestador) {
        return prestadorServicoService.updatePrestador(id, prestador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestador(@PathVariable int id) {
        return prestadorServicoService.deletePrestador(id);
    }
}