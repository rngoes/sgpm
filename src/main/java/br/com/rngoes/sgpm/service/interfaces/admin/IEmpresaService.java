package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.Empresa;

import java.util.List;

public interface IEmpresaService {
    public Empresa addEmpresa(Empresa empresa);
    public List<Empresa> listarEmpresas();
    public Empresa consultarEmpresa(Integer id);
    public Empresa alterarEmpresa(Empresa empresa);
    public String deletarEmpresa(Integer id);
}
