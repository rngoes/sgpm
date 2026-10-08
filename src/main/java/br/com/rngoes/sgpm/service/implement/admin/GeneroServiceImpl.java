package br.com.rngoes.sgpm.service.implement.admin;

import br.com.rngoes.sgpm.exception.NotFoundException;
import br.com.rngoes.sgpm.model.admin.Empresa;
import br.com.rngoes.sgpm.model.admin.Genero;
import br.com.rngoes.sgpm.repository.admin.GeneroRepo;
import br.com.rngoes.sgpm.service.interfaces.admin.IGeneroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements IGeneroService {

    private GeneroRepo repo;
    public GeneroServiceImpl(GeneroRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public Genero addGenero(Genero genero) {
        return repo.save(genero);
    }

    @Override
    public List<Genero> listarGeneros() {
        return repo.findByAtivo(Boolean.TRUE);
    }

    @Override
    public Genero consultarGenero(Integer id) {
        return repo.findById(id).orElseThrow(()-> new NotFoundException("Genero " + id + " não encontrado."));
    }

    @Override
    public Genero alterarGenero(Genero genero) {
        if (genero.getId() == null) {
            throw new NotFoundException("ID do genero é obrigatorio.");
        }
        Genero recuperado = consultarGenero(genero.getId());
        recuperado.setDescricao(genero.getDescricao());
        return repo.save(recuperado);
    }

    @Override
    public String deletarGenero(Integer id) {
        Genero genero = repo.findById(id).orElseThrow(()-> new NotFoundException("Genero " + id + " não encontrado."));
        if (!genero.getAtivo()) {
            throw new NotFoundException("Genero " + id + " não encontrado.");
        }
        genero.setAtivo(Boolean.FALSE);
        repo.save(genero);
        return "Genero " + id + " excluido com sucesso.";
    }


}
