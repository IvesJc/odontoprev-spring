package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.EmpresaContratante;
import br.com.odontoprev.repositories.EmpresaContratanteRepository;
import br.com.odontoprev.usecases.EmpresaContratanteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmpresaContratanteUsecaseImpl implements EmpresaContratanteUsecase {

    private final EmpresaContratanteRepository empresaContratanteRepository;


    @Override
    public ResponseEntity<List<EmpresaContratante>> getAllEmpresas() {
        List<EmpresaContratante> empresas = empresaContratanteRepository.findAll();
        return ResponseEntity.ok(empresas);
    }

    @Override
    public ResponseEntity<EmpresaContratante> getEmpresaById(int id) {
        return empresaContratanteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<EmpresaContratante> createEmpresa(EmpresaContratante empresa) {
        EmpresaContratante savedEmpresa = empresaContratanteRepository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmpresa);
    }

    @Override
    public ResponseEntity<EmpresaContratante> updateEmpresa(int id, EmpresaContratante empresa) {
        if (!empresaContratanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        empresa.setId(id);
        EmpresaContratante updatedEmpresa = empresaContratanteRepository.save(empresa);
        return ResponseEntity.ok(updatedEmpresa);
    }

    @Override
    public ResponseEntity<Void> deleteEmpresa(int id) {
        if (!empresaContratanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        empresaContratanteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
