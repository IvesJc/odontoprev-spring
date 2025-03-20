package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.recompensa.CreateRecompensaDto;
import br.com.odontoprev.dto.recompensa.RecompensaDto;
import br.com.odontoprev.dto.recompensa.UpdateRecompensaDto;
import br.com.odontoprev.entities.Recompensa;
import br.com.odontoprev.usecases.impl.RecompensaUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recompensas")
@RequiredArgsConstructor
@Tag(name = "Recompensa", description = "Endpoints destinados para a classe Recompensa")

public class RecompensaController {

    private final RecompensaUsecaseImpl recompensaService;

    @GetMapping
    public ResponseEntity<List<RecompensaDto>> getAllRecompensas() {
        return recompensaService.getAllRecompensas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecompensaDto> getRecompensaById(@PathVariable int id) {
        return recompensaService.getRecompensaById(id);
    }

    @PostMapping
    public ResponseEntity<RecompensaDto> createRecompensa(@RequestBody CreateRecompensaDto recompensa) {
        return recompensaService.createRecompensa(recompensa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecompensaDto> updateRecompensa(@PathVariable int id,
                                                          @RequestBody UpdateRecompensaDto recompensaDetails) {
        return recompensaService.updateRecompensa(id, recompensaDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecompensa(@PathVariable int id) {
        return recompensaService.deleteRecompensa(id);
    }
}