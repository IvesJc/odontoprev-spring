package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.PrestadorServico;
import br.com.odontoprev.usecases.impl.PrestadorServicoUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestadores")
@RequiredArgsConstructor
public class PrestadorServicoController {

    private final PrestadorServicoUsecaseImpl prestadorServicoService;

    @GetMapping
    public ResponseEntity<List<PrestadorServico>> getAllPrestadores() {
        return prestadorServicoService.getAllPrestadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestadorServico> getPrestadorById(@PathVariable int id) {
        return prestadorServicoService.getPrestadorById(id);
    }

    @PostMapping
    public ResponseEntity<PrestadorServico> createPrestador(@RequestBody PrestadorServico prestador) {
        return prestadorServicoService.createPrestador(prestador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestadorServico> updatePrestador(@PathVariable int id, @RequestBody PrestadorServico prestador) {
        return prestadorServicoService.updatePrestador(id, prestador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestador(@PathVariable int id) {
        return prestadorServicoService.deletePrestador(id);
    }
}