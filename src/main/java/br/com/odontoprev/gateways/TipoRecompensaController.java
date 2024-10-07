package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.TipoRecompensa;
import br.com.odontoprev.usecases.impl.TipoRecompensaUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-recompensa")
@RequiredArgsConstructor
public class TipoRecompensaController {

    private final TipoRecompensaUsecaseImpl tipoRecompensaService;

    @GetMapping
    public ResponseEntity<List<TipoRecompensa>> getAllTiposRecompensa() {
        return tipoRecompensaService.getAllTipoRecompensas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoRecompensa> getTipoRecompensaById(@PathVariable int id) {
        return tipoRecompensaService.getTipoRecompensaById(id);
    }

    @PostMapping
    public ResponseEntity<TipoRecompensa> createTipoRecompensa(@RequestBody TipoRecompensa tipoRecompensa) {
        return tipoRecompensaService.createTipoRecompensa(tipoRecompensa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoRecompensa> updateTipoRecompensa(@PathVariable int id, @RequestBody TipoRecompensa tipoRecompensaDetails) {
        return tipoRecompensaService.updateTipoRecompensa(id, tipoRecompensaDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoRecompensa(@PathVariable int id) {
        return tipoRecompensaService.deleteTipoRecompensa(id);
    }
}