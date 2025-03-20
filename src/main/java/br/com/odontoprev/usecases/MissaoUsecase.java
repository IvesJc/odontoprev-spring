package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.missao.CreateMissaoDto;
import br.com.odontoprev.dto.missao.MissaoDto;
import br.com.odontoprev.dto.missao.UpdateMissaoDto;
import br.com.odontoprev.entities.Missao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MissaoUsecase {
    ResponseEntity<List<MissaoDto>> getAllMissaos();
    ResponseEntity<MissaoDto> getMissaoById(int id);
    ResponseEntity<MissaoDto> createMissao(CreateMissaoDto missao);
    ResponseEntity<MissaoDto> updateMissao(int id, UpdateMissaoDto missao);
    ResponseEntity<Void> deleteMissao(int id);
}
