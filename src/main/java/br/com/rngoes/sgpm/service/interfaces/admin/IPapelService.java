package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.Papel;

import java.util.List;

public interface IPapelService {
    Papel criarPapel(Papel papel);
    List<Papel> listarPapeis();
    List<Papel> listarPapeisByAdministrador(Boolean administrador);
    Papel consultarPapel(Integer id);
    Papel alterarPapel(Papel papel);
    String deletarPapel(Integer id);
}
