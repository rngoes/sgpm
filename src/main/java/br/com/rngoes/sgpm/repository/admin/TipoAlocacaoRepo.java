package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.TipoAlocacao;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TipoAlocacaoRepo extends ListCrudRepository<TipoAlocacao, Integer> {
    List<TipoAlocacao> findByAtivo(Boolean ativo);
}
