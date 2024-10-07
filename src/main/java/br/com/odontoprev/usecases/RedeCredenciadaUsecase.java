package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.RedeCredenciada;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RedeCredenciadaUsecase {
    ResponseEntity<List<RedeCredenciada>> getAllRedeCredenciada();
    ResponseEntity<RedeCredenciada> getRedeCredenciadaById(int id);
    ResponseEntity<RedeCredenciada> createRedeCredenciada(RedeCredenciada redeCredenciada);
    ResponseEntity<RedeCredenciada> updateRedeCredenciada(int id, RedeCredenciada redeCredenciada);
    ResponseEntity<Void> deleteRedeCredenciada(int id);
}
