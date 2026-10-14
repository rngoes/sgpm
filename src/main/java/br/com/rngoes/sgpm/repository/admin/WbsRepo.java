package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.Wbs;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WbsRepo extends ListCrudRepository<Wbs, Integer> {
    List<Wbs> findByAtivo(Boolean ativo);
}
