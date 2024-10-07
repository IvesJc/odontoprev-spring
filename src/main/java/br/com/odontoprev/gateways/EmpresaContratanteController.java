package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.EmpresaContratante;
import br.com.odontoprev.usecases.impl.EmpresaContratanteUsecaseImpl;
import br.com.odontoprev.usecases.impl.EmpresaContratanteUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaContratanteController {

    private final EmpresaContratanteUsecaseImpl empresaContratanteUsecase;

    @GetMapping
    public ResponseEntity<List<EmpresaContratante>> getAllEmpresaContratantes() {
        return empresaContratanteUsecase.getAllEmpresas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaContratante> getEmpresaContratanteById(@PathVariable int id) {
        return empresaContratanteUsecase.getEmpresaById(id);
    }

    @PostMapping
    public ResponseEntity<EmpresaContratante> createEmpresaContratante(@RequestBody EmpresaContratante empresaContratante) {
        return empresaContratanteUsecase.createEmpresa(empresaContratante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaContratante> updateEmpresaContratante(@PathVariable int id, @RequestBody EmpresaContratante empresaContratante) {
        return empresaContratanteUsecase.updateEmpresa(id, empresaContratante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresaContratante(@PathVariable int id) {
        return empresaContratanteUsecase.deleteEmpresa(id);
    }
}