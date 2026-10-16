package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.Genero;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface GeneroRepo extends ListCrudRepository<Genero, Long> {
    List<Genero> findByAtivo(Boolean ativo);
}
