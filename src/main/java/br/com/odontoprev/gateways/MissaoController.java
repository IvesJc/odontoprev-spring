package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.Missao;
import br.com.odontoprev.usecases.impl.MissaoUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missoes")
@RequiredArgsConstructor
public class MissaoController {

    private final MissaoUsecaseImpl missaoUsecase;

    @GetMapping
    public ResponseEntity<List<Missao>> getAllMissoes() {
        return missaoUsecase.getAllMissaos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Missao> getMissaoById(@PathVariable int id) {
        return missaoUsecase.getMissaoById(id);
    }

    @PostMapping
    public ResponseEntity<Missao> createMissao(@RequestBody Missao missao) {
        return missaoUsecase.createMissao(missao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Missao> updateMissao(@PathVariable int id, @RequestBody Missao missao) {
        return missaoUsecase.updateMissao(id, missao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMissao(@PathVariable int id) {
        return missaoUsecase.deleteMissao(id);
    }
}