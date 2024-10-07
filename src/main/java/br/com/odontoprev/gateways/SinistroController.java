package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.Sinistro;
import br.com.odontoprev.usecases.impl.SinistroUsecaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sinistros")
public class SinistroController {

    private SinistroUsecaseImpl sinistroService;

    @GetMapping
    public ResponseEntity<List<Sinistro>> getAllSinistros() {
        return sinistroService.getAllSinistros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sinistro> getSinistroById(@PathVariable int id) {
        return sinistroService.getSinistroById(id);
    }

    @PostMapping
    public ResponseEntity<Sinistro> createSinistro(@RequestBody Sinistro sinistro) {
        return sinistroService.createSinistro(sinistro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sinistro> updateSinistro(@PathVariable int id, @RequestBody Sinistro sinistro) {
        return sinistroService.updateSinistro(id, sinistro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSinistro(@PathVariable int id) {
        return sinistroService.deleteSinistro(id);
    }
}