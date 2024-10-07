package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.repositories.BeneficiarioRepository;
import br.com.odontoprev.usecases.BeneficiarioUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BeneficiarioUsecaseImpl implements BeneficiarioUsecase {

    private final BeneficiarioRepository beneficiarioRepository;


    @Override
    public ResponseEntity<List<Beneficiario>> getAllBeneficiarios() {
        List<Beneficiario> beneficiarios = beneficiarioRepository.findAll();
        return ResponseEntity.ok(beneficiarios);
    }

    @Override
    public ResponseEntity<Beneficiario> getBeneficiarioById(int id) {
        return beneficiarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Beneficiario> createBeneficiario(Beneficiario beneficiario) {
        Beneficiario savedBeneficiario = beneficiarioRepository.save(beneficiario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBeneficiario);
    }

    @Override
    public ResponseEntity<Beneficiario> updateBeneficiario(int id, Beneficiario beneficiario) {
        if (!beneficiarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        beneficiario.setId(id);
        Beneficiario updatedBeneficiario = beneficiarioRepository.save(beneficiario);
        return ResponseEntity.ok(updatedBeneficiario);
    }

    @Override
    public ResponseEntity<Void> deleteBeneficiario(int id) {
        if (!beneficiarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        beneficiarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
