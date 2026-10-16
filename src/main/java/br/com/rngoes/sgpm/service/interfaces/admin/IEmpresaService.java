package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.Empresa;

import java.util.List;

public interface IEmpresaService {
    Empresa criarEmpresa(Empresa empresa);
    List<Empresa> listarEmpresas();
    Empresa consultarEmpresa(Long id);
    Empresa alterarEmpresa(Empresa empresa);
    String deletarEmpresa(Long id);
}
