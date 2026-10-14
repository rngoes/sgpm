package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.InvalidFieldException;
import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.MotivoSaida;
import br.com.rngoes.sgpm.repository.admin.MotivoSaidaRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.IMotivoSaidaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotivoSaidaServiceImpl implements IMotivoSaidaService {

    private final MotivoSaidaRepo repo;
    public MotivoSaidaServiceImpl(MotivoSaidaRepo repo) {
        super();
        this.repo = repo;
    }
    private void validarRegistro(MotivoSaida motivoSaida, Boolean cadastro) {
        if (cadastro) {
            if (motivoSaida.getId() != null) {
                throw new InvalidFieldException("Para cadastrar um motivo de saída o campo 'id' não deve ser informado.");
            }
            if (motivoSaida.getDescricao() == null) {
                throw new InvalidFieldException("Para cadastrar um motivo de saída o campo 'descricao' deve ser informado.");
            }
            if (motivoSaida.getAtivo() != null) {
                throw new InvalidFieldException("Para cadastrar um motivo de saída o campo 'ativo' não deve ser informado.");
            }
        } else {
            if (motivoSaida.getId() == null) {
                throw new InvalidFieldException("Para alterar um motivo de saída o campo 'id' deve ser informado.");
            }
            if (motivoSaida.getDescricao() == null) {
                throw new InvalidFieldException("Para alterar um motivo de saída o campo 'descricao' deve ser informado.");
            }
            if (motivoSaida.getAtivo() != null) {
                throw new InvalidFieldException("Para alterar um motivo de saída o campo 'ativo' não deve ser informado.");
            }
        }
    }

    @Override
    public MotivoSaida criarMotivoSaida(MotivoSaida motivoSaida) {
        validarRegistro(motivoSaida, true);
        motivoSaida.setAtivo(Boolean.TRUE);
        return repo.save(motivoSaida);
    }

    @Override
    public List<MotivoSaida> listarMotivosSaida() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public MotivoSaida consultarMotivoSaida(Integer id) {
        MotivoSaida motivoSaida = repo.findById(id).orElseThrow(()-> new NotFoundException("Motivo de saída " + id + " não encontrado."));
        if (!motivoSaida.getAtivo()) {
            throw new NotFoundException("Motivo de saída " + id + " não encontrado.");
        }
        return motivoSaida;
    }

    @Override
    public MotivoSaida alterarMotivoSaida(MotivoSaida motivoSaida) {
        validarRegistro(motivoSaida, false);
        MotivoSaida recuperada = consultarMotivoSaida(motivoSaida.getId());
        recuperada.setDescricao(motivoSaida.getDescricao());
        return repo.save(recuperada);
    }

    @Override
    public String deletarMotivoSaida(Integer id) {
        MotivoSaida motivoSaida = consultarMotivoSaida(id);
        motivoSaida.setAtivo(Boolean.FALSE);
        repo.save(motivoSaida);
        return "Motivo de saída " + id + " excluido com sucesso.";
    }
}
