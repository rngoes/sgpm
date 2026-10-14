package br.com.rngoes.sgpm.service.interfaces.admin;

import br.com.rngoes.sgpm.model.admin.Genero;

import java.util.List;

public interface IGeneroService {
    Genero criarGenero(Genero genero);
    List<Genero> listarGeneros();
    Genero consultarGenero(Integer id);
    Genero alterarGenero(Genero genero);
    String deletarGenero(Integer id);
}
