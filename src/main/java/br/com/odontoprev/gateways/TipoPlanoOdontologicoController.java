package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.TipoPlanoOdontologico;
import br.com.odontoprev.usecases.impl.TipoPlanoOdontologicoUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-plano")
@RequiredArgsConstructor
public class TipoPlanoOdontologicoController {

    private final TipoPlanoOdontologicoUsecaseImpl TipoPlanoOdontologicoService;

    @GetMapping
    public ResponseEntity<List<TipoPlanoOdontologico>> getAllTiposPlano() {
        return TipoPlanoOdontologicoService.getAllTipoPlanoOdontologicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPlanoOdontologico> getTipoPlanoOdontologicoById(@PathVariable int id) {
        return TipoPlanoOdontologicoService.getTipoPlanoOdontologicoById(id);
    }

    @PostMapping
    public ResponseEntity<TipoPlanoOdontologico> createTipoPlanoOdontologico(@RequestBody TipoPlanoOdontologico TipoPlanoOdontologico) {
        return TipoPlanoOdontologicoService.createTipoPlanoOdontologico(TipoPlanoOdontologico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPlanoOdontologico> updateTipoPlanoOdontologico(@PathVariable int id, @RequestBody TipoPlanoOdontologico TipoPlanoOdontologicoDetails) {
        return TipoPlanoOdontologicoService.updateTipoPlanoOdontologico(id, TipoPlanoOdontologicoDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPlanoOdontologico(@PathVariable int id) {
        return TipoPlanoOdontologicoService.deleteTipoPlanoOdontologico(id);
    }
}