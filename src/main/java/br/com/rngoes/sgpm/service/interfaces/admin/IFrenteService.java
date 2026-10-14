package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.Frente;

import java.util.List;

public interface IFrenteService {
    Frente  criarFrente(Frente frente);
    List<Frente> listarFrentes();
    Frente consultarFrente(Integer id);
    Frente alterarFrente(Frente frente);
    String deletarFrente(Integer id);
}
