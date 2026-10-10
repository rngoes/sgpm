package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.Empresa;
import br.com.rngoes.sgpm.repository.admin.EmpresaRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.IEmpresaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    private EmpresaRepo repo;
    public EmpresaServiceImpl(EmpresaRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public Empresa criarEmpresa(Empresa empresa) {
        if (empresa.getId() != null) {
            throw new InvalidFieldException("Para cadastrar uma empresa o campo 'id' não deve ser informado.");
        }
        if (empresa.getNome() == null) {
            throw new InvalidFieldException("Para cadastrar uma empresa o campo 'nome' deve ser informado.");
        }
        if (empresa.getAtivo() != null) {
            throw new InvalidFieldException("Para cadastrar uma empresa o campo 'ativo' não deve ser informado.");
        }
        return repo.save(empresa);
    }

    @Override
    public List<Empresa> listarEmpresas() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public Empresa consultarEmpresa(Integer id) {
        Empresa empresa = repo.findById(id).orElseThrow(()-> new NotFoundException("Empresa " + id + " não encontrada."));
        if (!empresa.getAtivo()) {
            throw new NotFoundException("Empresa " + id + " não encontrada.");
        }
        return empresa;
    }

    @Override
    public Empresa alterarEmpresa(Empresa empresa) {
        if (empresa.getId() == null) {
            throw new InvalidFieldException("Para alterar uma empresa o campo 'id' deve ser informado.");
        }
        if (empresa.getNome() == null) {
            throw new InvalidFieldException("Para alterar uma empresa o campo 'nome' deve ser informado.");
        }
        if (empresa.getAtivo() != null) {
            throw new InvalidFieldException("Para alterar uma empresa o campo 'ativo' não deve ser informado.");
        }
        Empresa recuperada = consultarEmpresa(empresa.getId());
        recuperada.setNome(empresa.getNome());
        return repo.save(recuperada);
    }

    @Override
    public String deletarEmpresa(Integer id) {
        Empresa empresa = consultarEmpresa(id);
        empresa.setAtivo(Boolean.FALSE);
        repo.save(empresa);
        return "Empresa " + id + " excluida com sucesso.";
    }
}
