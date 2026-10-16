package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.TipoAlocacao;
import br.com.rngoes.sgpm.repository.admin.TipoAlocacaoRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.ITipoAlocacaoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAlocacaoServiceImpl implements ITipoAlocacaoService {

    private final TipoAlocacaoRepo repo;
    public TipoAlocacaoServiceImpl(TipoAlocacaoRepo repo) {
        super();
        this.repo = repo;
    }

    private void validarRegistro(TipoAlocacao tipoAlocacao, Boolean cadastro) {
        if (cadastro) {
            if (tipoAlocacao.getId() != null) {
                throw new InvalidFieldException("Para cadastrar um tipo de alocacão o campo 'id' não deve ser informado.");
            }
            if (tipoAlocacao.getDescricao() == null) {
                throw new InvalidFieldException("Para cadastrar um tipo de alocacão o campo 'descricao' deve ser informado.");
            }
            if (tipoAlocacao.getAtivo() != null) {
                throw new InvalidFieldException("Para cadastrar um tipo de alocacão o campo 'ativo' não deve ser informado.");
            }
        } else {
            if (tipoAlocacao.getId() == null) {
                throw new InvalidFieldException("Para alterar um tipo de alocacão o campo 'id' deve ser informado.");
            }
            if (tipoAlocacao.getDescricao() == null) {
                throw new InvalidFieldException("Para alterar um tipo de alocacão o campo 'descricao' deve ser informado.");
            }
            if (tipoAlocacao.getAtivo() != null) {
                throw new InvalidFieldException("Para alterar um tipo de alocacão o campo 'ativo' não deve ser informado.");
            }
        }
    }

    @Override
    public TipoAlocacao criarTipoAlocacao(TipoAlocacao tipoAlocacao) {
        validarRegistro(tipoAlocacao, true);
        tipoAlocacao.setAtivo(Boolean.TRUE);
        return repo.save(tipoAlocacao);
    }

    @Override
    public List<TipoAlocacao> listarTiposAlocacao() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public TipoAlocacao consultarTipoAlocacao(Long id) {
        TipoAlocacao tipoAlocacao = repo.findById(id).orElseThrow(()-> new NotFoundException("Tipo de alocacão " + id + " não encontrada."));
        if (!tipoAlocacao.getAtivo()) {
            throw new NotFoundException("Tipo de alocacão " + id + " não encontrado.");
        }
        return tipoAlocacao;
    }

    @Override
    public TipoAlocacao alterarTipoAlocacao(TipoAlocacao tipoAlocacao) {
        validarRegistro(tipoAlocacao, false);
        TipoAlocacao recuperada = consultarTipoAlocacao(tipoAlocacao.getId());
        recuperada.setDescricao(tipoAlocacao.getDescricao());
        return repo.save(recuperada);
    }

    @Override
    public String deletarTipoAlocacao(Long id) {
        TipoAlocacao tipoAlocacao = consultarTipoAlocacao(id);
        tipoAlocacao.setAtivo(Boolean.FALSE);
        repo.save(tipoAlocacao);
        return "Tipo de alocacão " + id + " excluido com sucesso.";
    }
}
