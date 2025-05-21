package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.beneficiario.BeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.CreateBeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.UpdateBeneficiarioDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.mappers.BeneficiarioMapper;
import br.com.odontoprev.repositories.BeneficiarioRepository;
import br.com.odontoprev.usecases.BeneficiarioUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeneficiarioUsecaseImpl implements BeneficiarioUsecase {

    private final BeneficiarioRepository beneficiarioRepository;
    private final MessageSource messageSource;

    @Override
    public ResponseEntity<List<BeneficiarioDto>> getAllBeneficiarios(Locale locale) {
        List<Beneficiario> beneficiarios = beneficiarioRepository.findAll();
        List<BeneficiarioDto> beneficiariosDto = beneficiarios.stream()
                .map(BeneficiarioMapper::toBeneficiarioDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(beneficiariosDto);
    }

    @Override
    public ResponseEntity<BeneficiarioDto> getBeneficiarioById(int id, Locale locale) {
        return beneficiarioRepository.findById(id)
                .map(beneficiario -> ResponseEntity.ok(BeneficiarioMapper.toBeneficiarioDto(beneficiario)))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        messageSource.getMessage("beneficiario.not-found", null, locale)
                ));
    }

    @Override
    public ResponseEntity<BeneficiarioDto> buscarBeneficiarioPorId(int id, Locale locale) {
        return getBeneficiarioById(id, locale);
    }

    @Override
    public ResponseEntity<BeneficiarioDto> createBeneficiario(CreateBeneficiarioDto createBeneficiarioDto, Locale locale) {
        Beneficiario beneficiario = BeneficiarioMapper.toBeneficiarioFromCreate(createBeneficiarioDto);
        Beneficiario saved = beneficiarioRepository.save(beneficiario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BeneficiarioMapper.toBeneficiarioDto(saved));
    }

    @Override
    public ResponseEntity<BeneficiarioDto> updateBeneficiario(int id, UpdateBeneficiarioDto dto, Locale locale) {
        if (!beneficiarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    messageSource.getMessage("beneficiario.nao.encontrado", null, locale));
        }

        Beneficiario beneficiario = BeneficiarioMapper.toBeneficiarioFromUpdate(dto);
        beneficiario.setId(id);
        beneficiarioRepository.save(beneficiario);

        return ResponseEntity.ok(BeneficiarioMapper.toBeneficiarioDto(beneficiario));
    }

    @Override
    public ResponseEntity<Void> deleteBeneficiario(int id, Locale locale) {
        if (!beneficiarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    messageSource.getMessage("beneficiario.nao.encontrado", null, locale));
        }

        beneficiarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
