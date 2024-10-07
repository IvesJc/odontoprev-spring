package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.PlanoOdontologico;
import br.com.odontoprev.usecases.impl.PlanoOdontologicoUsecaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planos")
public class PlanoOdontologicoController {

    @Autowired
    private PlanoOdontologicoUsecaseImpl planoService;

    @GetMapping
    public ResponseEntity<List<PlanoOdontologico>> getAllPlanos() {
        return planoService.getAllPlanoOdontologicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoOdontologico> getPlanoById(@PathVariable int id) {
        return planoService.getPlanoOdontologicoById(id);
    }

    @PostMapping
    public ResponseEntity<PlanoOdontologico> createPlano(@RequestBody PlanoOdontologico plano) {
        return planoService.createPlanoOdontologico(plano);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoOdontologico> updatePlano(@PathVariable int id, @RequestBody PlanoOdontologico plano) {
        return planoService.updatePlanoOdontologico(id, plano);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlano(@PathVariable int id) {
        return planoService.deletePlanoOdontologico(id);
    }
}