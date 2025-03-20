package br.com.odontoprev.gateways.mvc;

import br.com.odontoprev.dto.empresaContratante.EmpresaContratanteDto;
import br.com.odontoprev.usecases.mvc.EmpresaContratanteMvcService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaContratanteMvcController {

    private final EmpresaContratanteMvcService empresaService;

    @GetMapping
    public String listarEmpresas(Model model) {
        model.addAttribute("empresas", empresaService.getAllEmpresas());
        return "empresa/index";
    }

    @GetMapping("/novo")
    public String novaEmpresa(Model model) {
        model.addAttribute("empresa", new EmpresaContratanteDto(null, "", "", ""));
        return "empresa/form";
    }

    @PostMapping("/salvar")
    public String salvarEmpresa(@ModelAttribute EmpresaContratanteDto empresa) {
        if (empresa.id() == null) {
            empresaService.saveEmpresa(empresa);
        } else {
            empresaService.updateEmpresa(empresa);
        }
        return "redirect:/empresas";
    }
    @GetMapping("/{id}/editar")
    public String editarEmpresa(@PathVariable int id, Model model) {
        empresaService.getEmpresaById(id).ifPresent(empresa -> model.addAttribute("empresa", empresa));
        return "empresa/form";
    }

    @PostMapping("/{id}/deletar")
    public String deletarEmpresa(@PathVariable int id) {
        empresaService.deleteEmpresa(id);
        return "redirect:/empresas";
    }

    @GetMapping("/{id}")
    public String detalhesEmpresa(@PathVariable int id, Model model) {
        empresaService.getEmpresaById(id).ifPresent(empresa -> model.addAttribute("empresa", empresa));
        return "empresa/detalhes";
    }
}