package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.Frente;
import br.com.rngoes.sgpm.repository.admin.FrenteRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.IFrenteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrenteServiceImpl implements IFrenteService {

    private final FrenteRepo repo;
    public FrenteServiceImpl(FrenteRepo repo) {
        super();
        this.repo = repo;
    }

    private void validarRegistro(Frente frente, Boolean cadastro) {
        if (cadastro) {
            if (frente.getId() != null) {
                throw new InvalidFieldException("Para cadastrar uma frente o campo 'id' não deve ser informado.");
            }
            if (frente.getDescricao() == null) {
                throw new InvalidFieldException("Para cadastrar uma frente o campo 'descricao' deve ser informado.");
            }
            if (frente.getAtivo() != null) {
                throw new InvalidFieldException("Para cadastrar uma frente o campo 'ativo' não deve ser informado.");
            }
        } else {
            if (frente.getId() == null) {
                throw new InvalidFieldException("Para alterar uma frente o campo 'id' deve ser informado.");
            }
            if (frente.getDescricao() == null) {
                throw new InvalidFieldException("Para alterar uma frente o campo 'descricao' deve ser informado.");
            }
            if (frente.getAtivo() != null) {
                throw new InvalidFieldException("Para alterar uma frente o campo 'ativo' não deve ser informado.");
            }
        }
    }

    @Override
    public Frente criarFrente(Frente frente) {
        validarRegistro(frente, true);
        frente.setAtivo(Boolean.TRUE);
        return repo.save(frente);
    }

    @Override
    public List<Frente> listarFrentes() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public Frente consultarFrente(Long id) {
        Frente frente = repo.findById(id).orElseThrow(()-> new NotFoundException("Frente " + id + " não encontrada."));
        if (!frente.getAtivo()) {
            throw new NotFoundException("Frente " + id + " não encontrada.");
        }
        return frente;
    }

    @Override
    public Frente alterarFrente(Frente frente) {
        validarRegistro(frente, false);
        Frente recuperada = consultarFrente(frente.getId());
        recuperada.setDescricao(frente.getDescricao());
        return repo.save(recuperada);
    }

    @Override
    public String deletarFrente(Long id) {
        Frente frente = consultarFrente(id);
        frente.setAtivo(Boolean.FALSE);
        repo.save(frente);
        return "Frente " + id + " excluida com sucesso.";
    }
}
