package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.empresaContratante.CreateEmpresaContratanteDto;
import br.com.odontoprev.dto.empresaContratante.EmpresaContratanteDto;
import br.com.odontoprev.dto.empresaContratante.UpdateEmpresaContratanteDto;
import br.com.odontoprev.entities.EmpresaContratante;
import br.com.odontoprev.usecases.impl.EmpresaContratanteUsecaseImpl;
import br.com.odontoprev.usecases.impl.EmpresaContratanteUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
@Tag(name = "Empresa Contratante", description = "Endpoints destinados para a classe Empresa Contratante")
public class EmpresaContratanteController {

    private final EmpresaContratanteUsecaseImpl empresaContratanteUsecase;

    @GetMapping
    public ResponseEntity<List<EmpresaContratanteDto>> getAllEmpresaContratantes() {
        return empresaContratanteUsecase.getAllEmpresas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaContratanteDto> getEmpresaContratanteById(@PathVariable int id) {
        return empresaContratanteUsecase.getEmpresaById(id);
    }

    @PostMapping
    public ResponseEntity<EmpresaContratanteDto> createEmpresaContratante(@RequestBody CreateEmpresaContratanteDto empresaContratante) {
        return empresaContratanteUsecase.createEmpresa(empresaContratante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaContratanteDto> updateEmpresaContratante(@PathVariable int id,
                                                                          @RequestBody UpdateEmpresaContratanteDto empresaContratante) {
        return empresaContratanteUsecase.updateEmpresa(id, empresaContratante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresaContratante(@PathVariable int id) {
        return empresaContratanteUsecase.deleteEmpresa(id);
    }
}