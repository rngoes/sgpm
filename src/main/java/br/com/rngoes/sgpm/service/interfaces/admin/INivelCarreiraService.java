package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.NivelCarreira;

import java.util.List;

public interface INivelCarreiraService {
    NivelCarreira criarNivelCarreira(NivelCarreira nivelCarreira);
    List<NivelCarreira> listarNivelCarreira();
    NivelCarreira consultarNivelCarreira(Integer id);
    NivelCarreira alterarNivelCarreira(NivelCarreira nivelCarreira);
    String deletarNivelCarreira(Integer id);
}
