package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.TipoMissao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoMissaoUsecase {
    ResponseEntity<List<TipoMissao>> getAllTipoMissaos();
    ResponseEntity<TipoMissao> getTipoMissaoById(int id);
    ResponseEntity<TipoMissao> createTipoMissao(TipoMissao tipoMissao);
    ResponseEntity<TipoMissao> updateTipoMissao(int id, TipoMissao tipoMissao);
    ResponseEntity<Void> deleteTipoMissao(int id);
}
