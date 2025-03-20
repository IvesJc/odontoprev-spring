package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.beneficiario.BeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.CreateBeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.UpdateBeneficiarioDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.mappers.BeneficiarioMapper;
import br.com.odontoprev.repositories.BeneficiarioRepository;
import br.com.odontoprev.usecases.BeneficiarioUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeneficiarioUsecaseImpl implements BeneficiarioUsecase {

    private final BeneficiarioRepository beneficiarioRepository;


    public ResponseEntity<List<BeneficiarioDto>> getAllBeneficiarios() {
        List<Beneficiario> beneficiarios = beneficiarioRepository.findAll();
        List<BeneficiarioDto> beneficiariosDto = beneficiarios.stream()
                .map(BeneficiarioMapper::toBeneficiarioDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(beneficiariosDto);
    }

    public ResponseEntity<BeneficiarioDto> getBeneficiarioById(int id) {
        return beneficiarioRepository.findById(id)
                .map(beneficiario -> ResponseEntity.ok(BeneficiarioMapper.toBeneficiarioDto(beneficiario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<BeneficiarioDto> buscarBeneficiarioPorId(int id) {
        return beneficiarioRepository.findById(id).map(beneficiario -> ResponseEntity.ok(BeneficiarioMapper.toBeneficiarioDto(beneficiario))).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BeneficiarioDto> createBeneficiario(CreateBeneficiarioDto createBeneficiarioDto) {
        Beneficiario beneficiario = BeneficiarioMapper.toBeneficiarioFromCreate(createBeneficiarioDto);

        // Salva o beneficiário no repositório
        Beneficiario savedBeneficiario = beneficiarioRepository.save(beneficiario);

        // Retorna a resposta com o DTO do beneficiário criado
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BeneficiarioMapper.toBeneficiarioDto(savedBeneficiario));
    }


    @Override
    public ResponseEntity<BeneficiarioDto> updateBeneficiario(int id, UpdateBeneficiarioDto updateBeneficiarioDto) {
        if (!beneficiarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Beneficiario beneficiario = BeneficiarioMapper.toBeneficiarioFromUpdate(updateBeneficiarioDto);
        beneficiario.setId(id);

        beneficiarioRepository.save(beneficiario);

        return ResponseEntity.ok(BeneficiarioMapper.toBeneficiarioDto(beneficiario));
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
