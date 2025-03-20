package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.tipoPlano.CreateTipoPlanoDto;
import br.com.odontoprev.dto.tipoPlano.TipoPlanoDto;
import br.com.odontoprev.dto.tipoPlano.UpdateTipoPlanoDto;
import br.com.odontoprev.entities.TipoPlanoOdontologico;
import br.com.odontoprev.usecases.impl.TipoPlanoOdontologicoUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-plano")
@RequiredArgsConstructor
@Tag(name = "Tipo Plano Odontologico", description = "Endpoints destinados para a classe Tipo Plano Odontologico")

public class TipoPlanoOdontologicoController {

    private final TipoPlanoOdontologicoUsecaseImpl TipoPlanoOdontologicoService;

    @GetMapping
    public ResponseEntity<List<TipoPlanoDto>> getAllTiposPlano() {
        return TipoPlanoOdontologicoService.getAllTipoPlano();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPlanoDto> getTipoPlanoOdontologicoById(@PathVariable int id) {
        return TipoPlanoOdontologicoService.getTipoPlanoById(id);
    }

    @PostMapping
    public ResponseEntity<TipoPlanoDto> createTipoPlanoOdontologico(@RequestBody CreateTipoPlanoDto TipoPlanoOdontologico) {
        return TipoPlanoOdontologicoService.createTipoPlano(TipoPlanoOdontologico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPlanoDto> updateTipoPlanoOdontologico(@PathVariable int id,
                                                                    @RequestBody UpdateTipoPlanoDto TipoPlanoOdontologicoDetails) {
        return TipoPlanoOdontologicoService.updateTipoPlano(id, TipoPlanoOdontologicoDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPlanoOdontologico(@PathVariable int id) {
        return TipoPlanoOdontologicoService.deleteTipoPlanoOdontologico(id);
    }
}