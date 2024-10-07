package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.EmpresaContratante;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpresaContratanteUsecase {
    ResponseEntity<List<EmpresaContratante>> getAllEmpresas();
    ResponseEntity<EmpresaContratante> getEmpresaById(int id);
    ResponseEntity<EmpresaContratante> createEmpresa(EmpresaContratante empresa);
    ResponseEntity<EmpresaContratante> updateEmpresa(int id, EmpresaContratante empresa);
    ResponseEntity<Void> deleteEmpresa(int id);
}
