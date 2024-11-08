package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.BeneficiarioRequestTelaPrincipalDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.usecases.impl.BeneficiarioUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiarios")
@RequiredArgsConstructor
@Tag(name = "Beneficiario", description = "Endpoints destinados para a classe Beneficiário")
public class BeneficiarioController {

    private final BeneficiarioUsecaseImpl beneficiarioUsecase;

    @GetMapping("/android/{id}")
    public ResponseEntity<BeneficiarioRequestTelaPrincipalDto> buscarBeneficiarioPorId(@PathVariable Integer id) {
        return beneficiarioUsecase.buscarBeneficiarioPorId(id);
    }

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