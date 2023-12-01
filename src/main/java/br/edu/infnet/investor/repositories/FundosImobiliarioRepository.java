package br.edu.infnet.investor.repositories;

import br.edu.infnet.investor.model.domain.Acao;
import br.edu.infnet.investor.model.domain.FundosImobiliario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundosImobiliarioRepository extends CrudRepository<FundosImobiliario, Integer> {
}
