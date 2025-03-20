package br.com.odontoprev.usecases.mvc;

import br.com.odontoprev.dto.empresaContratante.EmpresaContratanteDto;
import br.com.odontoprev.entities.EmpresaContratante;
import br.com.odontoprev.repositories.EmpresaContratanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaContratanteMvcService {

    private final EmpresaContratanteRepository repository;


    // Listar todos os registros
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

    // Buscar por ID
    public Optional<EmpresaContratanteDto> getEmpresaById(int id) {
        return repository.findById(id)
                .map(empresa -> new EmpresaContratanteDto(
                        empresa.getId(),
                        empresa.getNome(),
                        empresa.getCnpj(),
                        empresa.getNumeroContrato()
                ));
    }

    // Salvar uma nova empresa
    public void saveEmpresa(EmpresaContratanteDto dto) {
        EmpresaContratante empresa = new EmpresaContratante();
        empresa.setNome(dto.nome());
        empresa.setCnpj(dto.cnpj());
        empresa.setNumeroContrato(dto.numeroContrato());
        empresa = repository.save(empresa);

        new EmpresaContratanteDto(empresa.getId(), empresa.getNome(), empresa.getCnpj(), empresa.getNumeroContrato());
    }

    // Atualizar uma empresa
    public void updateEmpresa(EmpresaContratanteDto dto) {
        EmpresaContratante empresa = repository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        empresa.setNome(dto.nome());
        empresa.setCnpj(dto.cnpj());
        empresa.setNumeroContrato(dto.numeroContrato());
        empresa = repository.save(empresa);

        new EmpresaContratanteDto(empresa.getId(), empresa.getNome(), empresa.getCnpj(), empresa.getNumeroContrato());
    }

    // Deletar uma empresa
    public void deleteEmpresa(int id) {
        repository.deleteById(id);
    }
}
