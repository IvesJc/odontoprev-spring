package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.tipoMissao.CreateTipoMissaoDto;
import br.com.odontoprev.dto.tipoMissao.TipoMissaoDto;
import br.com.odontoprev.dto.tipoMissao.UpdateTipoMissaoDto;
import br.com.odontoprev.entities.TipoMissao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoMissaoUsecase {
    ResponseEntity<List<TipoMissaoDto>> getAllTipoMissoes();
    ResponseEntity<TipoMissaoDto> getTipoMissaoById(int id);
    ResponseEntity<TipoMissaoDto> createTipoMissao(CreateTipoMissaoDto tipoMissao);
    ResponseEntity<TipoMissaoDto> updateTipoMissao(int id, UpdateTipoMissaoDto tipoMissao);
    ResponseEntity<Void> deleteTipoMissao(int id);
}
