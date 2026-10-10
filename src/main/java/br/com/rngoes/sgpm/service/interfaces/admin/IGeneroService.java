package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.Genero;

import java.util.List;

public interface IGeneroService {
    public Genero criarGenero(Genero genero);
    public List<Genero> listarGeneros();
    public Genero consultarGenero(Integer id);
    public Genero alterarGenero(Genero genero);
    public String deletarGenero(Integer id);
}
