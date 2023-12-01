package br.edu.infnet.investor.repositories;

import br.edu.infnet.investor.model.domain.RendaFixa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendaFixaRepository extends CrudRepository<RendaFixa, Integer> {
}
