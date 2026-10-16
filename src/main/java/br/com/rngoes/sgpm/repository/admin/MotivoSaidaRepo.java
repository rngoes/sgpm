package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.MotivoSaida;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface MotivoSaidaRepo extends ListCrudRepository<MotivoSaida, Long> {
    List<MotivoSaida> findByAtivo(Boolean ativo);
}
