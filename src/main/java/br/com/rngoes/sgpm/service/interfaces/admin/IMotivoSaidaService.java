package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.MotivoSaida;

import java.util.List;

public interface IMotivoSaidaService {
    MotivoSaida criarMotivoSaida(MotivoSaida motivoSaida);
    List<MotivoSaida> listarMotivosSaida();
    MotivoSaida consultarMotivoSaida(Long id);
    MotivoSaida alterarMotivoSaida(MotivoSaida motivoSaida);
    String deletarMotivoSaida(Long id);
}
