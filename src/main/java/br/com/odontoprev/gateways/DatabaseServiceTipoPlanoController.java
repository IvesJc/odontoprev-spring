package br.com.odontoprev.gateways;

import br.com.odontoprev.database.TipoPlanoOdontologicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipoPlano")
public class DatabaseServiceTipoPlanoController {

    @Autowired
    private TipoPlanoOdontologicoService tipoPlanoOdontologicoService;

    @PostMapping("/executarCrud")
    public String insertTipoPlano() {
        tipoPlanoOdontologicoService.insertDatabase();
        return "Operações INSERT executadas com sucesso.";
    }

    @DeleteMapping()
    public String deleteTipoPlano() {
        tipoPlanoOdontologicoService.deleteDatabase();
        return "Operações DELETE executadas com sucesso.";
    }

    @GetMapping
    public String updateTipoPlano() {
        tipoPlanoOdontologicoService.updateDatabase();
        return "Operações UPDATE executadas com sucesso.";
    }

}
