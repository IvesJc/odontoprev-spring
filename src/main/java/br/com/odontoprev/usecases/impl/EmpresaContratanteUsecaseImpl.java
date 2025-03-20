package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.empresaContratante.CreateEmpresaContratanteDto;
import br.com.odontoprev.dto.empresaContratante.EmpresaContratanteDto;
import br.com.odontoprev.dto.empresaContratante.UpdateEmpresaContratanteDto;
import br.com.odontoprev.entities.EmpresaContratante;
import br.com.odontoprev.mappers.EmpresaContratanteMapper;
import br.com.odontoprev.repositories.EmpresaContratanteRepository;
import br.com.odontoprev.usecases.EmpresaContratanteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmpresaContratanteUsecaseImpl implements EmpresaContratanteUsecase {

    private final EmpresaContratanteRepository empresaContratanteRepository;

    @Override
    public ResponseEntity<List<EmpresaContratanteDto>> getAllEmpresas() {
        List<EmpresaContratante> empresas = empresaContratanteRepository.findAll();
        List<EmpresaContratanteDto> empresasDto = empresas.stream()
                .map(EmpresaContratanteMapper::toEmpresaContratanteDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(empresasDto);
    }

    @Override
    public ResponseEntity<EmpresaContratanteDto> getEmpresaById(int id) {
        return empresaContratanteRepository.findById(id)
                .map(empresa -> ResponseEntity.ok(EmpresaContratanteMapper.toEmpresaContratanteDto(empresa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<EmpresaContratanteDto> createEmpresa(CreateEmpresaContratanteDto createDto) {
        EmpresaContratante empresaContratante = EmpresaContratanteMapper.toEmpresaContratanteFromCreate(createDto);

        EmpresaContratante savedEmpresa = empresaContratanteRepository.save(empresaContratante);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EmpresaContratanteMapper.toEmpresaContratanteDto(savedEmpresa));
    }

    @Override
    public ResponseEntity<EmpresaContratanteDto> updateEmpresa(int id, UpdateEmpresaContratanteDto updateDto) {
        if (!empresaContratanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        EmpresaContratante empresaContratante = EmpresaContratanteMapper.toEmpresaContratanteFromUpdate(updateDto);
        empresaContratante.setId(id);

        EmpresaContratante updatedEmpresa = empresaContratanteRepository.save(empresaContratante);
        return ResponseEntity.ok(EmpresaContratanteMapper.toEmpresaContratanteDto(updatedEmpresa));
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
