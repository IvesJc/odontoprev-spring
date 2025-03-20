package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.missao.CreateMissaoDto;
import br.com.odontoprev.dto.missao.MissaoDto;
import br.com.odontoprev.dto.missao.UpdateMissaoDto;
import br.com.odontoprev.entities.Missao;
import br.com.odontoprev.usecases.impl.MissaoUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missoes")
@RequiredArgsConstructor
@Tag(name = "Missao", description = "Endpoints destinados para a classe Missao")

public class MissaoController {

    private final MissaoUsecaseImpl missaoUsecase;

    @GetMapping
    public ResponseEntity<List<MissaoDto>> getAllMissoes() {
        return missaoUsecase.getAllMissaos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissaoDto> getMissaoById(@PathVariable int id) {
        return missaoUsecase.getMissaoById(id);
    }

    @PostMapping
    public ResponseEntity<MissaoDto> createMissao(@RequestBody CreateMissaoDto missao) {
        return missaoUsecase.createMissao(missao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissaoDto> updateMissao(@PathVariable int id, @RequestBody UpdateMissaoDto missao) {
        return missaoUsecase.updateMissao(id, missao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMissao(@PathVariable int id) {
        return missaoUsecase.deleteMissao(id);
    }
}