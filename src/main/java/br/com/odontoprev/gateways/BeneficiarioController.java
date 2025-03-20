package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.beneficiario.BeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.CreateBeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.UpdateBeneficiarioDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.usecases.impl.BeneficiarioUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<BeneficiarioDto> buscarBeneficiarioPorId(@PathVariable Integer id) {
        return beneficiarioUsecase.buscarBeneficiarioPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioDto>> getAllBeneficiarios() {
        return beneficiarioUsecase.getAllBeneficiarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiarioDto> getBeneficiarioById(@PathVariable int id) {
        return beneficiarioUsecase.getBeneficiarioById(id);
    }

    @PostMapping
    public ResponseEntity<BeneficiarioDto> createBeneficiario(@RequestBody CreateBeneficiarioDto beneficiario) {
        return beneficiarioUsecase.createBeneficiario(beneficiario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioDto> updateBeneficiario(@PathVariable int id,
                                                              @RequestBody UpdateBeneficiarioDto beneficiario) {
        return beneficiarioUsecase.updateBeneficiario(id, beneficiario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiario(@PathVariable int id) {
        return beneficiarioUsecase.deleteBeneficiario(id);
    }
}