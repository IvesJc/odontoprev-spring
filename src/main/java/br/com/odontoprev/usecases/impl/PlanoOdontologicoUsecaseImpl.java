package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.plano.CreatePlanoDto;
import br.com.odontoprev.dto.plano.PlanoDto;
import br.com.odontoprev.dto.plano.UpdatePlanoDto;
import br.com.odontoprev.entities.EmpresaContratante;
import br.com.odontoprev.entities.PlanoOdontologico;
import br.com.odontoprev.entities.TipoPlanoOdontologico;
import br.com.odontoprev.mappers.PlanoOdontologicoMapper;
import br.com.odontoprev.repositories.EmpresaContratanteRepository;
import br.com.odontoprev.repositories.PlanoOdontologicoRepository;
import br.com.odontoprev.repositories.TipoPlanoOdontologicoRepository;
import br.com.odontoprev.usecases.PlanoOdontologicoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlanoOdontologicoUsecaseImpl implements PlanoOdontologicoUsecase {

    private final PlanoOdontologicoRepository planoRepository;

    private final TipoPlanoOdontologicoRepository tipoPlanoRepository;

    private final EmpresaContratanteRepository empresaContratanteRepository;

    public ResponseEntity<List<PlanoDto>> getAllPlanoOdontologicos() {
        List<PlanoOdontologico> planos = planoRepository.findAll();
        List<PlanoDto> planosDto = planos.stream()
                .map(PlanoOdontologicoMapper::toPlanoDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(planosDto);
    }

    public ResponseEntity<PlanoDto> getPlanoOdontologicoById(int id) {
        return planoRepository.findById(id)
                .map(plano -> ResponseEntity.ok(PlanoOdontologicoMapper.toPlanoDto(plano)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PlanoDto> createPlanoOdontologico(CreatePlanoDto createDto) {
        PlanoOdontologico plano = PlanoOdontologicoMapper.toPlanoFromCreate(createDto);

        TipoPlanoOdontologico tipoPlano =
                tipoPlanoRepository.findById(createDto.tipoPlanoId()).orElseThrow(() -> new NoSuchElementException("TipoPlano " +
                        "não encontrado"));
        EmpresaContratante empresaContratante = empresaContratanteRepository.findById(createDto.empresaContratanteId()).orElseThrow(() -> new NoSuchElementException("EmpresaContratante não encontrada"));

        plano.setTipoPlano(tipoPlano);
        plano.setEmpresaContratante(empresaContratante);

        PlanoOdontologico savedPlano = planoRepository.save(plano);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PlanoOdontologicoMapper.toPlanoDto(savedPlano));
    }

    public ResponseEntity<PlanoDto> updatePlanoOdontologico(int id, UpdatePlanoDto updateDto) {
        if (!planoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        PlanoOdontologico plano = PlanoOdontologicoMapper.toPlanoFromUpdate(updateDto);
        plano.setId(id);

        // Novamente, buscar as entidades relacionadas
        TipoPlanoOdontologico tipoPlano = tipoPlanoRepository.findById(updateDto.tipoPlanoId()).orElseThrow(() -> new NoSuchElementException("TipoPlano não encontrado"));
        EmpresaContratante empresaContratante = empresaContratanteRepository.findById(updateDto.empresaContratanteId()).orElseThrow(() -> new NoSuchElementException("EmpresaContratante não encontrada"));

        plano.setTipoPlano(tipoPlano);
        plano.setEmpresaContratante(empresaContratante);

        PlanoOdontologico updatedPlano = planoRepository.save(plano);
        return ResponseEntity.ok(PlanoOdontologicoMapper.toPlanoDto(updatedPlano));
    }

    @Override
    public ResponseEntity<Void> deletePlanoOdontologico(int id) {
        if (!planoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        planoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
