package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.tipoRecompensa.CreateTipoRecompensaDto;
import br.com.odontoprev.dto.tipoRecompensa.TipoRecompensaDto;
import br.com.odontoprev.dto.tipoRecompensa.UpdateTipoRecompensaDto;
import br.com.odontoprev.entities.TipoRecompensa;
import br.com.odontoprev.usecases.impl.TipoRecompensaUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-recompensa")
@RequiredArgsConstructor
@Tag(name = "Tipo Recompensa", description = "Endpoints destinados para a classe Tipo Recompensa")


public class TipoRecompensaController {

    private final TipoRecompensaUsecaseImpl tipoRecompensaService;

    @GetMapping
    public ResponseEntity<List<TipoRecompensaDto>> getAllTiposRecompensa() {
        return tipoRecompensaService.getAllTipoRecompensas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoRecompensaDto> getTipoRecompensaById(@PathVariable int id) {
        return tipoRecompensaService.getTipoRecompensaById(id);
    }

    @PostMapping
    public ResponseEntity<TipoRecompensaDto> createTipoRecompensa(@RequestBody CreateTipoRecompensaDto tipoRecompensa) {
        return tipoRecompensaService.createTipoRecompensa(tipoRecompensa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoRecompensaDto> updateTipoRecompensa(@PathVariable int id,
                                                                  @RequestBody UpdateTipoRecompensaDto tipoRecompensaDetails) {
        return tipoRecompensaService.updateTipoRecompensa(id, tipoRecompensaDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoRecompensa(@PathVariable int id) {
        return tipoRecompensaService.deleteTipoRecompensa(id);
    }
}