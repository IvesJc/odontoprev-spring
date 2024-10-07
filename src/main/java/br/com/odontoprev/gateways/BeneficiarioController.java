package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.usecases.impl.BeneficiarioUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiarios")
@RequiredArgsConstructor
public class BeneficiarioController {

    private final BeneficiarioUsecaseImpl beneficiarioUsecase;

    @GetMapping
    public ResponseEntity<List<Beneficiario>> getAllBeneficiarios() {
        return beneficiarioUsecase.getAllBeneficiarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> getBeneficiarioById(@PathVariable int id) {
        return beneficiarioUsecase.getBeneficiarioById(id);
    }

    @PostMapping
    public ResponseEntity<Beneficiario> createBeneficiario(@RequestBody Beneficiario beneficiario) {
        return beneficiarioUsecase.createBeneficiario(beneficiario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable int id, @RequestBody Beneficiario beneficiario) {
        return beneficiarioUsecase.updateBeneficiario(id, beneficiario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiario(@PathVariable int id) {
        return beneficiarioUsecase.deleteBeneficiario(id);
    }
}