package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.beneficiario.BeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.CreateBeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.UpdateBeneficiarioDto;
import br.com.odontoprev.infra.LocaleUtil;
import br.com.odontoprev.usecases.impl.BeneficiarioUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/beneficiarios")
@RequiredArgsConstructor
@Tag(name = "Beneficiario", description = "Endpoints destinados para a classe Beneficiário")
public class BeneficiarioController {

    private final BeneficiarioUsecaseImpl beneficiarioUsecase;
    private final LocaleUtil localeUtil;

    @GetMapping("/android/{id}")
    public ResponseEntity<BeneficiarioDto> buscarBeneficiarioPorId(@PathVariable Integer id,
                                                                   @RequestHeader(name = "Accept-Language", required = false) String acceptLanguage) {
        Locale locale = localeUtil.resolveLocale(acceptLanguage);
        return beneficiarioUsecase.buscarBeneficiarioPorId(id, locale); // (adicione locale se for usar no usecase)
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioDto>> getAllBeneficiarios(
            @RequestHeader(name = "Accept-Language", required = false) String acceptLanguage) {
        Locale locale = localeUtil.resolveLocale(acceptLanguage);
        return beneficiarioUsecase.getAllBeneficiarios(locale); // (adicione locale se for usar no usecase)
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiarioDto> getBeneficiarioById(@PathVariable int id,
                                                               @RequestHeader(name = "Accept-Language", required = false) String acceptLanguage) {
        Locale locale = localeUtil.resolveLocale(acceptLanguage);
        return beneficiarioUsecase.getBeneficiarioById(id, locale); // (adicione locale se for usar no usecase)
    }

    @PostMapping
    public ResponseEntity<BeneficiarioDto> createBeneficiario(@RequestBody CreateBeneficiarioDto beneficiario,
                                                              @RequestHeader(name = "Accept-Language", required = false) String acceptLanguage) {
        Locale locale = localeUtil.resolveLocale(acceptLanguage);
        return beneficiarioUsecase.createBeneficiario(beneficiario, locale); // (adicione locale se for usar no usecase)
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioDto> updateBeneficiario(@PathVariable int id,
                                                              @RequestBody UpdateBeneficiarioDto beneficiario,
                                                              @RequestHeader(name = "Accept-Language", required = false) String acceptLanguage) {
        Locale locale = localeUtil.resolveLocale(acceptLanguage);
        return beneficiarioUsecase.updateBeneficiario(id, beneficiario, locale); // (adicione locale se for usar no usecase)
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiario(@PathVariable int id,
                                                   @RequestHeader(name = "Accept-Language", required = false) String acceptLanguage) {
        Locale locale = localeUtil.resolveLocale(acceptLanguage);
        return beneficiarioUsecase.deleteBeneficiario(id, locale); // (adicione locale se for usar no usecase)
    }
}
