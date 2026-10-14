package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.NivelCarreira;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface NivelCarreiraRepo extends ListCrudRepository<NivelCarreira, Integer> {
    List<NivelCarreira> findByAtivo(Boolean ativo);
}
