package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.servico.CreateServicoDto;
import br.com.odontoprev.dto.servico.ServicoDto;
import br.com.odontoprev.dto.servico.UpdateServicoDto;
import br.com.odontoprev.entities.Servico;
import br.com.odontoprev.entities.Sinistro;
import br.com.odontoprev.entities.TipoServico;
import br.com.odontoprev.mappers.ServicoMapper;
import br.com.odontoprev.repositories.ServicoRepository;
import br.com.odontoprev.repositories.SinistroRepository;
import br.com.odontoprev.repositories.TipoServicoRepository;
import br.com.odontoprev.usecases.ServicoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ServicoUsecaseImpl implements ServicoUsecase {

    private final ServicoRepository servicoRepository;

    private final TipoServicoRepository tipoServicoRepository;

    private final SinistroRepository sinistroRepository;

    @Override
    public ResponseEntity<List<ServicoDto>> getAllServicos() {
        List<Servico> servicos = servicoRepository.findAll();
        List<ServicoDto> servicosDto = servicos.stream()
                .map(ServicoMapper::toServicoDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(servicosDto);
    }

    @Override
    public ResponseEntity<ServicoDto> getServicoById(int id) {
        return servicoRepository.findById(id)
                .map(servico -> ResponseEntity.ok(ServicoMapper.toServicoDto(servico)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<ServicoDto> createServico(CreateServicoDto createDto) {
        TipoServico tipoServico = tipoServicoRepository.findById(createDto.tipoServicoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de serviço não encontrado"));

        Sinistro sinistro = sinistroRepository.findById(createDto.sinistroId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sinistro não encontrado"));

        Servico servico = ServicoMapper.toServicoFromCreate(createDto, tipoServico, sinistro);
        Servico savedServico = servicoRepository.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ServicoMapper.toServicoDto(savedServico));
    }

    @Override
    public ResponseEntity<ServicoDto> updateServico(int id, UpdateServicoDto updateDto) {
        if (!servicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        TipoServico tipoServico = tipoServicoRepository.findById(updateDto.tipoServicoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de serviço não encontrado"));

        Sinistro sinistro = sinistroRepository.findById(updateDto.sinistroId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sinistro não encontrado"));

        Servico servico = ServicoMapper.toServicoFromUpdate(updateDto, id, tipoServico, sinistro);
        Servico updatedServico = servicoRepository.save(servico);
        return ResponseEntity.ok(ServicoMapper.toServicoDto(updatedServico));
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
