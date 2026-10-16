package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.Papel;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PapelRepo extends ListCrudRepository<Papel, Long> {
    List<Papel> findByAtivo(Boolean ativo);
    List<Papel> findByAdministradorAndAtivo(Boolean administrador, Boolean ativo);
}
