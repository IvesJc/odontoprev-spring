package br.com.odontoprev.gateways;

import br.com.odontoprev.database.EmpresaContratanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresaContratante")
public class DatabaseServiceEmpresaContratanteController {

    @Autowired
    private EmpresaContratanteService empresaContratanteService;

    @PostMapping("/executarCrud")
    public String insertEmpresaContratante() {
        empresaContratanteService.insertEmpresa();
        return "Operações INSERT executadas com sucesso.";
    }

    @DeleteMapping()
    public String deleteEmpresaContratante() {
        empresaContratanteService.deleteEmpresa();
        return "Operações DELETE executadas com sucesso.";
    }

    @GetMapping
    public String updateEmpresaContratante() {
        empresaContratanteService.updateEmpresa();
        return "Operações UPDATE executadas com sucesso.";
    }
}
