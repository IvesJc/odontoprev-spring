package br.com.odontoprev.gateways.mvc;

import br.com.odontoprev.dto.endereco.CreateEnderecoDto;
import br.com.odontoprev.dto.endereco.EnderecoDto;
import br.com.odontoprev.usecases.mvc.EnderecoMvcService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoMvcController {
    private final EnderecoMvcService enderecoService;



    @GetMapping
    public String listarEnderecos(Model model) {
        model.addAttribute("enderecos", enderecoService.getAllEnderecos());
        return "endereco/index";
    }

    @GetMapping("/novo")
    public String novoEndereco(Model model) {
        model.addAttribute("endereco", new EnderecoDto(null, "", 0, "", "", "", ""));
        return "endereco/form";
    }

    @PostMapping("/salvar")
    public String salvarEndereco(@ModelAttribute EnderecoDto endereco) {
        if (endereco.id() == null) {
            enderecoService.saveEndereco(endereco);
        }
        return "redirect:/enderecos";
    }

    @GetMapping("/{id}/editar")
    public String editarEndereco(@PathVariable int id, Model model) {
        var enderecoDto = enderecoService.getEnderecoById(id);
        if (enderecoDto == null) {
            return "redirect:/enderecos?error=notfound";
        }
        model.addAttribute("endereco", enderecoDto);
        return "endereco/form";
    }

    @PostMapping("/{id}/editar")
    public String editarEndereco(@PathVariable int id, @ModelAttribute EnderecoDto endereco) {
        enderecoService.updateEndereco(endereco);
        return "redirect:/enderecos";
    }

    @GetMapping("/{id}")
    public String detalhesEndereco(@PathVariable int id, Model model) {
        var enderecoDto = enderecoService.getEnderecoById(id);
        if (enderecoDto == null) {
            return "redirect:/enderecos?error=notfound";
        }
        model.addAttribute("endereco", enderecoDto);
        return "endereco/detalhes";
    }

    @GetMapping("/{id}/deletar")
    public String confirmarDelecao(@PathVariable int id, Model model) {
        var enderecoDto = enderecoService.getEnderecoById(id);
        if (enderecoDto == null) {
            return "redirect:/enderecos?error=notfound";
        }
        model.addAttribute("endereco", enderecoDto);
        return "endereco/confirmacao";
    }

    @PostMapping("/{id}/deletar")
    public String deletarEndereco(@PathVariable int id) {
        enderecoService.deleteEndereco(id);
        return "redirect:/enderecos";
    }
}

