package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.tipoMissao.CreateTipoMissaoDto;
import br.com.odontoprev.dto.tipoMissao.TipoMissaoDto;
import br.com.odontoprev.dto.tipoMissao.UpdateTipoMissaoDto;
import br.com.odontoprev.entities.TipoMissao;
import br.com.odontoprev.mappers.TipoMissaoMapper;
import br.com.odontoprev.repositories.TipoMissaoRepository;
import br.com.odontoprev.usecases.TipoMissaoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TipoMissaoUsecaseImpl implements TipoMissaoUsecase {

    private final TipoMissaoRepository tipoMissaoRepository;

    @Override
    public ResponseEntity<List<TipoMissaoDto>> getAllTipoMissoes() {
        List<TipoMissao> tipoMissoes = tipoMissaoRepository.findAll();
        List<TipoMissaoDto> tipoMissaoDtos = tipoMissoes.stream()
                .map(TipoMissaoMapper::toTipoMissaoDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(tipoMissaoDtos);
    }

    @Override
    public ResponseEntity<TipoMissaoDto> getTipoMissaoById(int id) {
        return tipoMissaoRepository.findById(id)
                .map(tipoMissao -> ResponseEntity.ok(TipoMissaoMapper.toTipoMissaoDto(tipoMissao)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TipoMissaoDto> createTipoMissao(CreateTipoMissaoDto createTipoMissaoDto) {
        TipoMissao tipoMissao = TipoMissaoMapper.toTipoMissaoFromCreate(createTipoMissaoDto);

        // Salva o TipoMissao no repositório
        TipoMissao savedTipoMissao = tipoMissaoRepository.save(tipoMissao);

        // Retorna a resposta com o DTO do TipoMissao criado
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TipoMissaoMapper.toTipoMissaoDto(savedTipoMissao));
    }

    @Override
    public ResponseEntity<TipoMissaoDto> updateTipoMissao(int id, UpdateTipoMissaoDto updateTipoMissaoDto) {
        if (!tipoMissaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        TipoMissao tipoMissao = TipoMissaoMapper.toTipoMissaoFromUpdate(updateTipoMissaoDto);
        tipoMissao.setId(id);

        tipoMissaoRepository.save(tipoMissao);

        return ResponseEntity.ok(TipoMissaoMapper.toTipoMissaoDto(tipoMissao));
    }

    @Override
    public ResponseEntity<Void> deleteTipoMissao(int id) {
        if (!tipoMissaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoMissaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
