package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.Wbs;

import java.util.List;

public interface IWbsService {
    Wbs criarWbs(Wbs wbs);
    List<Wbs> listarWbs();
    Wbs consultarWbs(Integer id);
    Wbs alterarWbs(Wbs wbs);
    String deletarWbs(Integer id);
}
