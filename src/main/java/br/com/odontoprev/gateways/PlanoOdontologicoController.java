package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.plano.CreatePlanoDto;
import br.com.odontoprev.dto.plano.PlanoDto;
import br.com.odontoprev.dto.plano.UpdatePlanoDto;
import br.com.odontoprev.entities.PlanoOdontologico;
import br.com.odontoprev.usecases.impl.PlanoOdontologicoUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planos")
@Tag(name = "Plano Odontologico", description = "Endpoints destinados para a classe Plano Odontologico")

public class PlanoOdontologicoController {

    @Autowired
    private PlanoOdontologicoUsecaseImpl planoService;

    @GetMapping
    public ResponseEntity<List<PlanoDto>> getAllPlanos() {
        return planoService.getAllPlanoOdontologicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDto> getPlanoById(@PathVariable int id) {
        return planoService.getPlanoOdontologicoById(id);
    }

    @PostMapping
    public ResponseEntity<PlanoDto> createPlano(@RequestBody CreatePlanoDto plano) {
        return planoService.createPlanoOdontologico(plano);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDto> updatePlano(@PathVariable int id, @RequestBody UpdatePlanoDto plano) {
        return planoService.updatePlanoOdontologico(id, plano);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlano(@PathVariable int id) {
        return planoService.deletePlanoOdontologico(id);
    }
}