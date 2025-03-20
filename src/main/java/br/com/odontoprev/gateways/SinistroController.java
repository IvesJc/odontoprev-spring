package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.sinistro.CreateSinistroDto;
import br.com.odontoprev.dto.sinistro.SinistroDto;
import br.com.odontoprev.dto.sinistro.UpdateSinistroDto;
import br.com.odontoprev.entities.Sinistro;
import br.com.odontoprev.usecases.impl.SinistroUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sinistros")
@Tag(name = "Sinistro", description = "Endpoints destinados para a classe Sinistro")

public class SinistroController {

    private SinistroUsecaseImpl sinistroService;

    @GetMapping
    public ResponseEntity<List<SinistroDto>> getAllSinistros() {
        return sinistroService.getAllSinistros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SinistroDto> getSinistroById(@PathVariable int id) {
        return sinistroService.getSinistroById(id);
    }

    @PostMapping
    public ResponseEntity<SinistroDto> createSinistro(@RequestBody CreateSinistroDto sinistro) {
        return sinistroService.createSinistro(sinistro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SinistroDto> updateSinistro(@PathVariable int id, @RequestBody UpdateSinistroDto sinistro) {
        return sinistroService.updateSinistro(id, sinistro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSinistro(@PathVariable int id) {
        return sinistroService.deleteSinistro(id);
    }
}