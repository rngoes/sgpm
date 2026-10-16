package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.JustificativaSaida;
import br.com.rngoes.sgpm.repository.admin.JustificativaSaidaRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.IJustificativaSaidaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JustificativaSaidaServiceImpl implements IJustificativaSaidaService {

    private final JustificativaSaidaRepo repo;
    public JustificativaSaidaServiceImpl(JustificativaSaidaRepo repo) {
        super();
        this.repo = repo;
    }

    private void validarRegistro(JustificativaSaida justificativaSaida, Boolean cadastro) {
        if (cadastro) {
            if (justificativaSaida.getId() != null) {
                throw new InvalidFieldException("Para cadastrar uma justificativa de saída o campo 'id' não deve ser informado.");
            }
            if (justificativaSaida.getDescricao() == null) {
                throw new InvalidFieldException("Para cadastrar uma justificativa de saída o campo 'descricao' deve ser informado.");
            }
            if (justificativaSaida.getAtivo() != null) {
                throw new InvalidFieldException("Para cadastrar uma justificativa de saída o campo 'ativo' não deve ser informado.");
            }
        } else {
            if (justificativaSaida.getId() == null) {
                throw new InvalidFieldException("Para alterar uma justificativa de saída o campo 'id' deve ser informado.");
            }
            if (justificativaSaida.getDescricao() == null) {
                throw new InvalidFieldException("Para alterar uma justificativa de saída o campo 'descricao' deve ser informado.");
            }
            if (justificativaSaida.getAtivo() != null) {
                throw new InvalidFieldException("Para alterar uma justificativa de saída o campo 'ativo' não deve ser informado.");
            }
        }
    }

    @Override
    public JustificativaSaida criarJustificativaSaida(JustificativaSaida justificativaSaida) {
        validarRegistro(justificativaSaida, true);
        justificativaSaida.setAtivo(Boolean.TRUE);
        return repo.save(justificativaSaida);
    }

    @Override
    public List<JustificativaSaida> listarJustificativasSaida() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public JustificativaSaida consultarJustificativaSaida(Long id) {
        JustificativaSaida justificativaSaida = repo.findById(id).orElseThrow(()-> new NotFoundException("Justificativa de saída " + id + " não encontrada."));
        if (!justificativaSaida.getAtivo()) {
            throw new NotFoundException("Justificativa de saída " + id + " não encontrada.");
        }
        return justificativaSaida;
    }

    @Override
    public JustificativaSaida alterarJustificativaSaida(JustificativaSaida justificativaSaida) {
        validarRegistro(justificativaSaida, false);
        JustificativaSaida recuperada = consultarJustificativaSaida(justificativaSaida.getId());
        recuperada.setDescricao(justificativaSaida.getDescricao());
        return repo.save(recuperada);
    }

    @Override
    public String deletarJustificativaSaida(Long id) {
        JustificativaSaida justificativaSaida = consultarJustificativaSaida(id);
        justificativaSaida.setAtivo(Boolean.FALSE);
        repo.save(justificativaSaida);
        return "Justificativa de saída " + id + " excluida com sucesso.";
    }
}
