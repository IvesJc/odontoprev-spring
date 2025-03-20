package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.empresaContratante.CreateEmpresaContratanteDto;
import br.com.odontoprev.dto.empresaContratante.EmpresaContratanteDto;
import br.com.odontoprev.dto.empresaContratante.UpdateEmpresaContratanteDto;
import br.com.odontoprev.entities.EmpresaContratante;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpresaContratanteUsecase {
    ResponseEntity<List<EmpresaContratanteDto>> getAllEmpresas();
    ResponseEntity<EmpresaContratanteDto> getEmpresaById(int id);
    ResponseEntity<EmpresaContratanteDto> createEmpresa(CreateEmpresaContratanteDto empresa);
    ResponseEntity<EmpresaContratanteDto> updateEmpresa(int id, UpdateEmpresaContratanteDto empresa);
    ResponseEntity<Void> deleteEmpresa(int id);
}
