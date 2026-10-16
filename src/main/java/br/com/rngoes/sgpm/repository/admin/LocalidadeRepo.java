package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.Localidade;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface LocalidadeRepo extends ListCrudRepository<Localidade, Long> {
    List<Localidade> findByAtivo(Boolean ativo);
    List<Localidade> findByBaseAndAtivo(Boolean base, Boolean ativo);
}
