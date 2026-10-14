package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.NivelCarreira;
import br.com.rngoes.sgpm.repository.admin.NivelCarreiraRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.INivelCarreiraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelCarreiraServiceImpl implements INivelCarreiraService {

    private final NivelCarreiraRepo repo;
    public NivelCarreiraServiceImpl(NivelCarreiraRepo repo) {
        super();
        this.repo = repo;
    }

    private void validarRegistro(NivelCarreira nivelCarreira, Boolean cadastro) {
        if (cadastro) {
            if (nivelCarreira.getId() != null) {
                throw new InvalidFieldException("Para cadastrar um nível carreira o campo 'id' não deve ser informado.");
            }
            if (nivelCarreira.getDescricao() == null) {
                throw new InvalidFieldException("Para cadastrar um nível carreira o campo 'descricao' deve ser informado.");
            }
            if (nivelCarreira.getAtivo() != null) {
                throw new InvalidFieldException("Para cadastrar um nível carreira o campo 'ativo' não deve ser informado.");
            }
        } else {
            if (nivelCarreira.getId() == null) {
                throw new InvalidFieldException("Para alterar um nível carreira o campo 'id' deve ser informado.");
            }
            if (nivelCarreira.getDescricao() == null) {
                throw new InvalidFieldException("Para alterar um nível carreira o campo 'descricao' deve ser informado.");
            }
            if (nivelCarreira.getAtivo() != null) {
                throw new InvalidFieldException("Para alterar um nível carreira o campo 'ativo' não deve ser informado.");
            }
        }
    }

    @Override
    public NivelCarreira criarNivelCarreira(NivelCarreira nivelCarreira) {
        validarRegistro(nivelCarreira, true);
        nivelCarreira.setAtivo(Boolean.TRUE);
        return repo.save(nivelCarreira);
    }

    @Override
    public List<NivelCarreira> listarNivelCarreira() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public NivelCarreira consultarNivelCarreira(Integer id) {
        NivelCarreira nivelCarreira =  repo.findById(id).orElseThrow(()-> new NotFoundException("Nivel de Carreira " + id + " não encontrado."));
        if (!nivelCarreira.getAtivo()) {
            throw new NotFoundException("Nivel de Carreira " + id + " não encontrado.");
        }
        return nivelCarreira;
    }

    @Override
    public NivelCarreira alterarNivelCarreira(NivelCarreira nivelCarreira) {
        validarRegistro(nivelCarreira, false);
        NivelCarreira recuperado = consultarNivelCarreira(nivelCarreira.getId());
        recuperado.setDescricao(nivelCarreira.getDescricao());
        return repo.save(recuperado);
    }

    @Override
    public String deletarNivelCarreira(Integer id) {
        NivelCarreira nivelCarreira = consultarNivelCarreira(id);
        nivelCarreira.setAtivo(Boolean.FALSE);
        repo.save(nivelCarreira);
        return "Nivel de carreira " + id + " excluido com sucesso.";
    }
}
