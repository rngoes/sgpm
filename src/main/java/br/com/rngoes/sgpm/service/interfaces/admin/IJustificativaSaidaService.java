package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.JustificativaSaida;

import java.util.List;

public interface IJustificativaSaidaService {
    JustificativaSaida criarJustificativaSaida(JustificativaSaida justificativaSaida);
    List<JustificativaSaida> listarJustificativasSaida();
    JustificativaSaida consultarJustificativaSaida(Long id);
    JustificativaSaida alterarJustificativaSaida(JustificativaSaida justificativaSaida);
    String deletarJustificativaSaida(Long id);
}
