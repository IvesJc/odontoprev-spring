package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.beneficiario.BeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.CreateBeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.UpdateBeneficiarioDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public interface BeneficiarioUsecase {
    ResponseEntity<List<BeneficiarioDto>> getAllBeneficiarios(Locale locale);
    ResponseEntity<BeneficiarioDto> getBeneficiarioById(int id, Locale locale);
    ResponseEntity<BeneficiarioDto> buscarBeneficiarioPorId(int id, Locale locale);
    ResponseEntity<BeneficiarioDto> createBeneficiario(CreateBeneficiarioDto beneficiario, Locale locale);
    ResponseEntity<BeneficiarioDto> updateBeneficiario(int id, UpdateBeneficiarioDto beneficiario, Locale locale);
    ResponseEntity<Void> deleteBeneficiario(int id, Locale locale);
}
