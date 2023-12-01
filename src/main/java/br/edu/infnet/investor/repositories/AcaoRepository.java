package br.edu.infnet.investor.repositories;

import br.edu.infnet.investor.model.domain.Acao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoRepository extends CrudRepository<Acao, Integer> {
}
