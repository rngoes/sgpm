package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.SituacaoProjeto;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SituacaoProjetoRepo extends ListCrudRepository<SituacaoProjeto, Long> {
    List<SituacaoProjeto> findByAtivo(Boolean ativo);
}
