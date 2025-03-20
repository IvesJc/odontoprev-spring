package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.missao.CreateMissaoDto;
import br.com.odontoprev.dto.missao.MissaoDto;
import br.com.odontoprev.dto.missao.UpdateMissaoDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.entities.Missao;
import br.com.odontoprev.entities.TipoMissao;
import br.com.odontoprev.mappers.MissaoMapper;
import br.com.odontoprev.repositories.BeneficiarioRepository;
import br.com.odontoprev.repositories.MissaoRepository;
import br.com.odontoprev.repositories.TipoMissaoRepository;
import br.com.odontoprev.usecases.MissaoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MissaoUsecaseImpl implements MissaoUsecase {

    private final MissaoRepository missaoRepository;
    private final TipoMissaoRepository tipoMissaoRepository;
    private final BeneficiarioRepository beneficiarioRepository;

    @Override
    public ResponseEntity<List<MissaoDto>> getAllMissaos() {
        List<Missao> Missaos = missaoRepository.findAll();
        List<MissaoDto> missaoDtoList = Missaos.stream()
                .map(MissaoMapper::toMissaoDto)
                .toList();
        return ResponseEntity.ok(missaoDtoList);
    }

    @Override
    public ResponseEntity<MissaoDto> getMissaoById(int id) {
        return missaoRepository.findById(id)
                .map(missao -> ResponseEntity.ok(MissaoMapper.toMissaoDto(missao)))  // Mapeia para MissaoDto
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<MissaoDto> createMissao(CreateMissaoDto createMissaoDto) {

        TipoMissao tipoMissao = tipoMissaoRepository.findById(createMissaoDto.tipoMissaoId())
                .orElseThrow(() -> new RuntimeException("TipoMissao não encontrado!"));

        Beneficiario beneficiario = beneficiarioRepository.findById(createMissaoDto.beneficiarioId())
                .orElseThrow(() -> new RuntimeException("Beneficiario não encontrado!"));
        Missao savedMissao = Missao.builder()
                .concluido(createMissaoDto.concluido())
                .recompensaRecebida(createMissaoDto.recompensaRecebida())
                .expiraEm(createMissaoDto.expiraEm())
                .tipoMissao(tipoMissao)
                .beneficiario(beneficiario)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(MissaoDto.fromEntity(savedMissao));
    }

    @Override
    public ResponseEntity<MissaoDto> updateMissao(int id, UpdateMissaoDto missaoDto) {
        if (!missaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Missao updatedMissao = MissaoMapper.toMissaoFromUpdate(missaoDto);
        updatedMissao.setId(id);

        missaoRepository.save(updatedMissao);

        return ResponseEntity.ok(MissaoMapper.toMissaoDto(updatedMissao));
    }

    @Override
    public ResponseEntity<Void> deleteMissao(int id) {
        if (!missaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        missaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
