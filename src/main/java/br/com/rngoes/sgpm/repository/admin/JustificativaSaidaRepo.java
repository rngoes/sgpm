package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.JustificativaSaida;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface JustificativaSaidaRepo extends ListCrudRepository<JustificativaSaida, Integer> {
    List<JustificativaSaida> findByAtivo(Boolean ativo);
}
