package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.Localidade;

import java.util.List;

public interface ILocalidadeService {
    public Localidade criarLocalidade(Localidade localidade);
    public List<Localidade> listarLocalidade();
    public List<Localidade> listarBase();
    public Localidade consultarLocalidade(Integer id);
    public Localidade alterarLocalidade(Localidade localidade);
    public String deletarLocalidade(Integer id);
}
