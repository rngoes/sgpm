package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.NivelCarreira;

import java.util.List;

public interface INivelCarreiraService {
    public NivelCarreira criarNivelCarreira(NivelCarreira nivelCarreira);
    public List<NivelCarreira> listarNivelCarreira();
    public NivelCarreira consultarNivelCarreira(Integer id);
    public NivelCarreira alterarNivelCarreira(NivelCarreira nivelCarreira);
    public String deletarNivelCarreira(Integer id);
}
