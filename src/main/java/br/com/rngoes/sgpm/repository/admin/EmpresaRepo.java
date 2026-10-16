package br.com.rngoes.sgpm.repository.admin;

import br.com.rngoes.sgpm.model.admin.Empresa;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface EmpresaRepo extends ListCrudRepository<Empresa, Long> {
    List<Empresa> findByAtivo(Boolean ativo);
}
