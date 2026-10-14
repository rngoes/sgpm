package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.Empresa;

import java.util.List;

public interface IEmpresaService {
    Empresa criarEmpresa(Empresa empresa);
    List<Empresa> listarEmpresas();
    Empresa consultarEmpresa(Integer id);
    Empresa alterarEmpresa(Empresa empresa);
    String deletarEmpresa(Integer id);
}
