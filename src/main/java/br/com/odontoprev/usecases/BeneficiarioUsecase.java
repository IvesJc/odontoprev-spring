package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.BeneficiarioRequestTelaPrincipalDto;
import br.com.odontoprev.entities.Beneficiario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeneficiarioUsecase {
    ResponseEntity<List<Beneficiario>> getAllBeneficiarios();
    ResponseEntity<Beneficiario> getBeneficiarioById(int id);
    ResponseEntity<BeneficiarioRequestTelaPrincipalDto> buscarBeneficiarioPorId(int id);
    ResponseEntity<Beneficiario> createBeneficiario(Beneficiario beneficiario);
    ResponseEntity<Beneficiario> updateBeneficiario(int id, Beneficiario beneficiario);
    ResponseEntity<Void> deleteBeneficiario(int id);
}
