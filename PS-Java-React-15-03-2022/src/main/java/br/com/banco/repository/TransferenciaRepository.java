package br.com.banco.repository;

import br.com.banco.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia,Integer> {
    Optional<Transferencia> findByNome_operador(String nome_operador_transacao);
}
