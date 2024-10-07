package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.Servico;
import br.com.odontoprev.repositories.ServicoRepository;
import br.com.odontoprev.usecases.ServicoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServicoUsecaseImpl implements ServicoUsecase {

    private final ServicoRepository servicoRepository;

    @Override
    public ResponseEntity<List<Servico>> getAllServicos() {
        List<Servico> servicos = servicoRepository.findAll();
        return ResponseEntity.ok(servicos);
    }

    @Override
    public ResponseEntity<Servico> getServicoById(int id) {
        return servicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Servico> createServico(Servico servico) {
        Servico savedServico = servicoRepository.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServico);
    }

    @Override
    public ResponseEntity<Servico> updateServico(int id, Servico servico) {
        if (!servicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        servico.setId(id);
        Servico updatedServico = servicoRepository.save(servico);
        return ResponseEntity.ok(updatedServico);
    }

    @Override
    public ResponseEntity<Void> deleteServico(int id) {
        if (!servicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        servicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
