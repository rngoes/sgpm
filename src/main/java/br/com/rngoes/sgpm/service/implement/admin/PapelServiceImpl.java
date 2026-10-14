package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.Papel;
import br.com.rngoes.sgpm.repository.admin.PapelRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.IPapelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PapelServiceImpl implements IPapelService {

    private final PapelRepo repo;
    public PapelServiceImpl(PapelRepo repo) {
        super();
        this.repo = repo;
    }

    private void validarRegistro(Papel papel, Boolean cadastro) {
        if (cadastro) {
            if (papel.getId() != null) {
                throw new InvalidFieldException("Para cadastrar um papel o campo 'id' não deve ser informado.");
            }
            if (papel.getDescricao() == null) {
                throw new InvalidFieldException("Para cadastrar um papel o campo 'descricao' deve ser informado.");
            }
            if (papel.getAdministrador() == null) {
                throw new InvalidFieldException("Para cadastrar um papel o campo 'administrador' deve ser informado.");
            }
            if (papel.getAtivo() != null) {
                throw new InvalidFieldException("Para cadastrar v o campo 'ativo' não deve ser informado.");
            }
        } else {
            if (papel.getId() == null) {
                throw new InvalidFieldException("Para alterar um papel o campo 'id' deve ser informado.");
            }
            if (papel.getDescricao() == null) {
                throw new InvalidFieldException("Para alterar um papel o campo 'descricao' deve ser informado.");
            }
            if (papel.getAdministrador() == null) {
                throw new InvalidFieldException("Para cadastrar um papel o campo 'administrador' deve ser informado.");
            }
            if (papel.getAtivo() != null) {
                throw new InvalidFieldException("Para alterar um papel o campo 'ativo' não deve ser informado.");
            }
        }
    }

    @Override
    public Papel criarPapel(Papel papel) {
        validarRegistro(papel, true);
        papel.setAtivo(Boolean.TRUE);
        return repo.save(papel);
    }

    @Override
    public List<Papel> listarPapeis() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public List<Papel> listarPapeisByAdministrador(Boolean administrador) {
        return repo.findByAdministradorAndAtivo(administrador, Boolean.TRUE);
    }

    @Override
    public Papel consultarPapel(Integer id) {
        Papel papel = repo.findById(id).orElseThrow(()-> new NotFoundException("Papel " + id + " não encontrado."));
        if (!papel.getAtivo()) {
            throw new NotFoundException("Papel " + id + " não encontrado.");
        }
        return papel;
    }

    @Override
    public Papel alterarPapel(Papel papel) {
        validarRegistro(papel, false);
        Papel recuperada = consultarPapel(papel.getId());
        recuperada.setDescricao(papel.getDescricao());
        recuperada.setAdministrador(papel.getAdministrador());
        return repo.save(recuperada);
    }

    @Override
    public String deletarPapel(Integer id) {
        Papel papel = consultarPapel(id);
        papel.setAtivo(Boolean.FALSE);
        repo.save(papel);
        return "Papel " + id + " excluido com sucesso.";
    }
}
