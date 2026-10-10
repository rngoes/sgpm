package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.Localidade;
import br.com.rngoes.sgpm.repository.admin.LocalidadeRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.ILocalidadeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadeServiceImpl implements ILocalidadeService {

    private LocalidadeRepo repo;
    public LocalidadeServiceImpl(LocalidadeRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public Localidade criarLocalidade(Localidade localidade) {
        if (localidade.getId() != null) {
            throw new InvalidFieldException("Para cadastrar uma localidade o campo 'id' não deve ser informado.");
        }
        if (localidade.getDescricao() == null) {
            throw new InvalidFieldException("Para cadastrar uma localidade o campo 'descricao' deve ser informado.");
        }
        if (localidade.getBase() == null) {
            throw new InvalidFieldException("Para cadastrar uma localidade o campo 'base' deve ser informado.");
        }
        if (localidade.getAtivo() != null) {
            throw new InvalidFieldException("Para cadastrar uma localidade o campo 'ativo' não deve ser informado.");
        }
        return repo.save(localidade);
    }

    @Override
    public List<Localidade> listarLocalidade() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public List<Localidade> listarBase() {
        return repo.findByBaseAndAtivo(Boolean.TRUE, Boolean.TRUE);
    }

    @Override
    public Localidade consultarLocalidade(Integer id) {
        Localidade localidade =  repo.findById(id).orElseThrow(()-> new NotFoundException("Localidade " + id + " não encontrada."));
        if (!localidade.getAtivo()) {
            throw new NotFoundException("Localidade " + id + " não encontrada.");
        }
        return localidade;
    }

    @Override
    public Localidade alterarLocalidade(Localidade localidade) {
        if (localidade.getId() == null) {
            throw new InvalidFieldException("Para alterar uma localidade o campo 'id' deve ser informado.");
        }
        if (localidade.getDescricao() == null) {
            throw new InvalidFieldException("Para alterar uma localidade o campo 'descricao' deve ser informado.");
        }
        if (localidade.getBase() == null) {
            throw new InvalidFieldException("Para alterar uma localidade o campo 'base' deve ser informado.");
        }
        if (localidade.getAtivo() != null) {
            throw new InvalidFieldException("Para alterar uma localidade o campo 'ativo' não deve ser informado.");
        }
        Localidade recuperado = consultarLocalidade(localidade.getId());
        recuperado.setDescricao(localidade.getDescricao());
        recuperado.setBase(localidade.getBase());
        return repo.save(recuperado);
    }

    @Override
    public String deletarLocalidade(Integer id) {
        Localidade localidade = consultarLocalidade(id);
        localidade.setAtivo(Boolean.FALSE);
        repo.save(localidade);
        return "Localidade " + id + " excluida com sucesso.";
    }
}
