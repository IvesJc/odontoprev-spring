package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.Recompensa;
import br.com.odontoprev.usecases.impl.RecompensaUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recompensas")
@RequiredArgsConstructor
public class RecompensaController {

    private final RecompensaUsecaseImpl recompensaService;

    @GetMapping
    public ResponseEntity<List<Recompensa>> getAllRecompensas() {
        return recompensaService.getAllRecompensa();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recompensa> getRecompensaById(@PathVariable int id) {
        return recompensaService.getRecompensaById(id);
    }

    @PostMapping
    public ResponseEntity<Recompensa> createRecompensa(@RequestBody Recompensa recompensa) {
        return recompensaService.createRecompensa(recompensa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recompensa> updateRecompensa(@PathVariable int id, @RequestBody Recompensa recompensaDetails) {
        return recompensaService.updateRecompensa(id, recompensaDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecompensa(@PathVariable int id) {
        return recompensaService.deleteRecompensa(id);
    }
}