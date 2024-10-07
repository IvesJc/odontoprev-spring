package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.TipoMissao;
import br.com.odontoprev.usecases.impl.TipoMissaoUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-missao")
@RequiredArgsConstructor
public class TipoMissaoController {

    private final TipoMissaoUsecaseImpl tipoMissaoService;

    @GetMapping
    public ResponseEntity<List<TipoMissao>> getAllTiposMissao() {
        return tipoMissaoService.getAllTipoMissaos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMissao> getTipoMissaoById(@PathVariable int id) {
        return tipoMissaoService.getTipoMissaoById(id);
    }

    @PostMapping
    public ResponseEntity<TipoMissao> createTipoMissao(@RequestBody TipoMissao tipoMissao) {
        return tipoMissaoService.createTipoMissao(tipoMissao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoMissao> updateTipoMissao(@PathVariable int id, @RequestBody TipoMissao tipoMissaoDetails) {
        return tipoMissaoService.updateTipoMissao(id, tipoMissaoDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoMissao(@PathVariable int id) {
        return tipoMissaoService.deleteTipoMissao(id);
    }
}