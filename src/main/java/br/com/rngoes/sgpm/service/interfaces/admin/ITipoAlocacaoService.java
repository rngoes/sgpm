package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.TipoAlocacao;

import java.util.List;

public interface ITipoAlocacaoService {
    TipoAlocacao criarTipoAlocacao(TipoAlocacao tipoAlocacao);
    List<TipoAlocacao> listarTiposAlocacao();
    TipoAlocacao consultarTipoAlocacao(Integer id);
    TipoAlocacao alterarTipoAlocacao(TipoAlocacao tipoAlocacao);
    String deletarTipoAlocacao(Integer id);
}
