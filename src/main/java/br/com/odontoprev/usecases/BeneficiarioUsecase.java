package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.beneficiario.BeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.CreateBeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.UpdateBeneficiarioDto;
import br.com.odontoprev.dto.missao.CreateMissaoDto;
import br.com.odontoprev.entities.Beneficiario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeneficiarioUsecase {
    ResponseEntity<List<BeneficiarioDto>> getAllBeneficiarios();
    ResponseEntity<BeneficiarioDto> getBeneficiarioById(int id);
    ResponseEntity<BeneficiarioDto> buscarBeneficiarioPorId(int id);
    ResponseEntity<BeneficiarioDto> createBeneficiario(CreateBeneficiarioDto beneficiario);
    ResponseEntity<BeneficiarioDto> updateBeneficiario(int id, UpdateBeneficiarioDto beneficiario);
    ResponseEntity<Void> deleteBeneficiario(int id);
}
