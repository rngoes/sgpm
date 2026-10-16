package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.Wbs;
import br.com.rngoes.sgpm.repository.admin.WbsRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.IWbsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WbsServiceImpl implements IWbsService {

    private final WbsRepo repo;
    public WbsServiceImpl(WbsRepo repo) {
        super();
        this.repo = repo;
    }

    private void validarRegistro(Wbs wbs, Boolean cadastro) {
        if (cadastro) {
            if (wbs.getId() != null) {
                throw new InvalidFieldException("Para cadastrar uma wbs o campo 'id' não deve ser informado.");
            }
            if (wbs.getDescricao() == null) {
                throw new InvalidFieldException("Para cadastrar uma wbs o campo 'descricao' deve ser informado.");
            }
            if (wbs.getCodigo() == null) {
                throw new InvalidFieldException("Para cadastrar uma wbs o campo 'codigo' deve ser informado.");
            }
            if (wbs.getAtivo() != null) {
                throw new InvalidFieldException("Para cadastrar uma wbs o campo 'ativo' não deve ser informado.");
            }
        } else {
            if (wbs.getId() == null) {
                throw new InvalidFieldException("Para alterar uma wbs o campo 'id' deve ser informado.");
            }
            if (wbs.getDescricao() == null) {
                throw new InvalidFieldException("Para alterar uma wbs o campo 'descricao' deve ser informado.");
            }
            if (wbs.getCodigo() == null) {
                throw new InvalidFieldException("Para alterar uma wbs o campo 'codigo' deve ser informado.");
            }
            if (wbs.getAtivo() != null) {
                throw new InvalidFieldException("Para alterar uma wbs o campo 'ativo' não deve ser informado.");
            }
        }
    }

    @Override
    public Wbs criarWbs(Wbs wbs) {
        validarRegistro(wbs, true);
        wbs.setAtivo(Boolean.TRUE);
        return repo.save(wbs);
    }

    @Override
    public List<Wbs> listarWbs() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public Wbs consultarWbs(Long id) {
        Wbs wbs = repo.findById(id).orElseThrow(()-> new NotFoundException("Wbs " + id + " não encontrada."));
        if (!wbs.getAtivo()) {
            throw new NotFoundException("Wbs " + id + " não encontrada.");
        }
        return wbs;
    }

    @Override
    public Wbs alterarWbs(Wbs wbs) {
        validarRegistro(wbs, false);
        Wbs recuperada = consultarWbs(wbs.getId());
        recuperada.setDescricao(wbs.getDescricao());
        recuperada.setCodigo(wbs.getCodigo());
        return repo.save(recuperada);
    }

    @Override
    public String deletarWbs(Long id) {
        Wbs wbs = consultarWbs(id);
        wbs.setAtivo(Boolean.FALSE);
        repo.save(wbs);
        return "Wbs " + id + " excluida com sucesso.";
    }
}
