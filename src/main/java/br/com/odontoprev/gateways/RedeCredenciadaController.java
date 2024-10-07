package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.RedeCredenciada;
import br.com.odontoprev.usecases.impl.RedeCredenciadaUsecaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redes")
public class RedeCredenciadaController {

    @Autowired
    private RedeCredenciadaUsecaseImpl redeCredenciadaService;

    @GetMapping
    public ResponseEntity<List<RedeCredenciada>> getAllRedes() {
        return redeCredenciadaService.getAllRedeCredenciada();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RedeCredenciada> getRedeById(@PathVariable int id) {
        return redeCredenciadaService.getRedeCredenciadaById(id);
    }

    @PostMapping
    public ResponseEntity<RedeCredenciada> createRede(@RequestBody RedeCredenciada rede) {
        return redeCredenciadaService.createRedeCredenciada(rede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RedeCredenciada> updateRede(@PathVariable int id, @RequestBody RedeCredenciada rede) {
        return redeCredenciadaService.updateRedeCredenciada(id, rede);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRede(@PathVariable int id) {
        return redeCredenciadaService.deleteRedeCredenciada(id);
    }
}