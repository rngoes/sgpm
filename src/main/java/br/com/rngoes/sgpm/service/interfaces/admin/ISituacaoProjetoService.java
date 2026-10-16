package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.SituacaoProjeto;

import java.util.List;

public interface ISituacaoProjetoService {
    SituacaoProjeto criarSituacaoProjeto(SituacaoProjeto situacaoProjeto);
    List<SituacaoProjeto> listarSituacoesProjeto();
    SituacaoProjeto consultarSituacaoProjeto(Long id);
    SituacaoProjeto alterarSituacaoProjeto(SituacaoProjeto situacaoProjeto);
    String deletarSituacaoProjeto(Long id);
}
