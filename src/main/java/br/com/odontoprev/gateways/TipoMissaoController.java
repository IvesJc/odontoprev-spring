package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.tipoMissao.CreateTipoMissaoDto;
import br.com.odontoprev.dto.tipoMissao.TipoMissaoDto;
import br.com.odontoprev.dto.tipoMissao.UpdateTipoMissaoDto;
import br.com.odontoprev.entities.TipoMissao;
import br.com.odontoprev.usecases.impl.TipoMissaoUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-missao")
@RequiredArgsConstructor
@Tag(name = "Tipo Missao", description = "Endpoints destinados para a classe Tipo Missao")

public class TipoMissaoController {

    private final TipoMissaoUsecaseImpl tipoMissaoService;

    @GetMapping
    public ResponseEntity<List<TipoMissaoDto>> getAllTiposMissao() {
        return tipoMissaoService.getAllTipoMissoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMissaoDto> getTipoMissaoById(@PathVariable int id) {
        return tipoMissaoService.getTipoMissaoById(id);
    }

    @PostMapping
    public ResponseEntity<TipoMissaoDto> createTipoMissao(@RequestBody CreateTipoMissaoDto tipoMissao) {
        return tipoMissaoService.createTipoMissao(tipoMissao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoMissaoDto> updateTipoMissao(@PathVariable int id,
                                                          @RequestBody UpdateTipoMissaoDto tipoMissaoDetails) {
        return tipoMissaoService.updateTipoMissao(id, tipoMissaoDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoMissao(@PathVariable int id) {
        return tipoMissaoService.deleteTipoMissao(id);
    }
}