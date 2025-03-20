package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.redeCredenciada.CreateRedeCredenciadaDto;
import br.com.odontoprev.dto.redeCredenciada.RedeCredenciadaDto;
import br.com.odontoprev.dto.redeCredenciada.UpdateRedeCredenciadaDto;
import br.com.odontoprev.entities.RedeCredenciada;
import br.com.odontoprev.usecases.impl.RedeCredenciadaUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redes")
@Tag(name = "Rede Credenciada", description = "Endpoints destinados para a classe Rede Credenciada")

public class RedeCredenciadaController {

    @Autowired
    private RedeCredenciadaUsecaseImpl redeCredenciadaService;

    @GetMapping
    public ResponseEntity<List<RedeCredenciadaDto>> getAllRedes() {
        return redeCredenciadaService.getAllRedeCredenciada();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RedeCredenciadaDto> getRedeById(@PathVariable int id) {
        return redeCredenciadaService.getRedeCredenciadaById(id);
    }

    @PostMapping
    public ResponseEntity<RedeCredenciadaDto> createRede(@RequestBody CreateRedeCredenciadaDto rede) {
        return redeCredenciadaService.createRedeCredenciada(rede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RedeCredenciadaDto> updateRede(@PathVariable int id, @RequestBody UpdateRedeCredenciadaDto rede) {
        return redeCredenciadaService.updateRedeCredenciada(id, rede);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRede(@PathVariable int id) {
        return redeCredenciadaService.deleteRedeCredenciada(id);
    }
}