package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.SituacaoProjeto;
import br.com.rngoes.sgpm.repository.admin.SituacaoProjetoRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.ISituacaoProjetoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituacaoProjetoServiceImpl implements ISituacaoProjetoService {

    private final SituacaoProjetoRepo repo;
    public SituacaoProjetoServiceImpl(SituacaoProjetoRepo repo) {
        super();
        this.repo = repo;
    }

    private void validarRegistro(SituacaoProjeto situacaoProjeto, Boolean cadastro){
        if (cadastro) {
            if (situacaoProjeto.getId() != null) {
                throw new InvalidFieldException("Para cadastrar uma situacao do projeto o campo 'id' não deve ser informado.");
            }
            if (situacaoProjeto.getDescricao() == null) {
                throw new InvalidFieldException("Para cadastrar uma situacao do projeto o campo 'descricao' deve ser informado.");
            }
            if (situacaoProjeto.getAtivo() != null) {
                throw new InvalidFieldException("Para cadastrar uma situacao do projeto o campo 'ativo' não deve ser informado.");
            }
        } else {
            if (situacaoProjeto.getId() == null) {
                throw new InvalidFieldException("Para alterar uma situacao do projeto o campo 'id' deve ser informado.");
            }
            if (situacaoProjeto.getDescricao() == null) {
                throw new InvalidFieldException("Para alterar uma situacao do projeto o campo 'descricao' deve ser informado.");
            }
            if (situacaoProjeto.getAtivo() != null) {
                throw new InvalidFieldException("Para alterar uma situacao do projeto o campo 'ativo' não deve ser informado.");
            }
        }
    }

    @Override
    public SituacaoProjeto criarSituacaoProjeto(SituacaoProjeto situacaoProjeto) {
        validarRegistro(situacaoProjeto, true);
        situacaoProjeto.setAtivo(Boolean.TRUE);
        return repo.save(situacaoProjeto);
    }

    @Override
    public List<SituacaoProjeto> listarSituacoesProjeto() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public SituacaoProjeto consultarSituacaoProjeto(Long id) {
        SituacaoProjeto situacaoProjeto = repo.findById(id).orElseThrow(()-> new NotFoundException("Situacao do projeto " + id + " não encontrado."));
        if (!situacaoProjeto.getAtivo()) {
            throw new NotFoundException("Situacao do projeto " + id + " não encontrado.");
        }
        return situacaoProjeto;
    }

    @Override
    public SituacaoProjeto alterarSituacaoProjeto(SituacaoProjeto situacaoProjeto) {
        validarRegistro(situacaoProjeto, false);
        SituacaoProjeto recuperado = consultarSituacaoProjeto(situacaoProjeto.getId());
        recuperado.setDescricao(situacaoProjeto.getDescricao());
        return repo.save(recuperado);
    }

    @Override
    public String deletarSituacaoProjeto(Long id) {
        SituacaoProjeto situacaoProjeto = consultarSituacaoProjeto(id);
        situacaoProjeto.setAtivo(Boolean.FALSE);
        repo.save(situacaoProjeto);
        return "Situacao do projeto " + id + " excluido com sucesso.";
    }
}
