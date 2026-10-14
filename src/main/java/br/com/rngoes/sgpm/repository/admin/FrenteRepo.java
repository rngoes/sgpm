package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.Frente;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface FrenteRepo extends ListCrudRepository<Frente, Integer> {
    List<Frente> findByAtivo(Boolean ativo);
}
