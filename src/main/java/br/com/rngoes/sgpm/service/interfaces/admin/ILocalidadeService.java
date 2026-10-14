package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.Localidade;

import java.util.List;

public interface ILocalidadeService {
    Localidade criarLocalidade(Localidade localidade);
    List<Localidade> listarLocalidade();
    List<Localidade> listarBase();
    Localidade consultarLocalidade(Integer id);
    Localidade alterarLocalidade(Localidade localidade);
    String deletarLocalidade(Integer id);
}
