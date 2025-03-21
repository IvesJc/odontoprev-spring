package br.com.odontoprev.usecases.mvc;

import br.com.odontoprev.dto.empresaContratante.EmpresaContratanteDto;
import br.com.odontoprev.entities.EmpresaContratante;
import br.com.odontoprev.repositories.EmpresaContratanteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaContratanteMvcService {

    private final EmpresaContratanteRepository repository;

    public List<EmpresaContratanteDto> getAllEmpresas() {
        return repository.findAll().stream()
                .map(empresa -> new EmpresaContratanteDto(
                        empresa.getId(),
                        empresa.getNome(),
                        empresa.getCnpj(),
                        empresa.getNumeroContrato()
                ))
                .toList();
    }

    public Optional<EmpresaContratanteDto> getEmpresaById(int id) {
        return repository.findById(id)
                .map(empresa -> new EmpresaContratanteDto(
                        empresa.getId(),
                        empresa.getNome(),
                        empresa.getCnpj(),
                        empresa.getNumeroContrato()
                ));
    }

    public void saveEmpresa(EmpresaContratanteDto dto) {
        EmpresaContratante empresa = new EmpresaContratante();
        empresa.setNome(dto.nome());
        empresa.setCnpj(dto.cnpj());
        empresa.setNumeroContrato(dto.numeroContrato());
        empresa = repository.save(empresa);

        new EmpresaContratanteDto(empresa.getId(), empresa.getNome(), empresa.getCnpj(), empresa.getNumeroContrato());
    }

    public void updateEmpresa(EmpresaContratanteDto empresa) {
        EmpresaContratante entidade = repository.findById(empresa.id())
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));

        entidade.setNome(empresa.nome());
        entidade.setCnpj(empresa.cnpj());
        entidade.setNumeroContrato(empresa.numeroContrato());

        repository.save(entidade);
    }


    public void deleteEmpresa(int id) {
        repository.deleteById(id);
    }
}
