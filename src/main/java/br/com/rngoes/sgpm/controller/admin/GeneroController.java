package br.com.rngoes.sgpm.controller.admin;

import br.com.rngoes.sgpm.model.admin.Genero;
import br.com.rngoes.sgpm.service.interfaces.admin.IGeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeneroController {

    private final IGeneroService service;
    public GeneroController(IGeneroService service){
        this.service = service;
    }

    @PostMapping("/genero")
    public ResponseEntity<Genero> criarGenero(@RequestBody Genero genero) {
        return ResponseEntity.status(201).body(service.criarGenero(genero));
    }

    @GetMapping("/genero")
    public ResponseEntity<List<Genero>> listarGenero() {
        return ResponseEntity.ok(service.listarGeneros());
    }

    @GetMapping("/genero/{id}")
    public ResponseEntity<Genero> consultarGenero(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultarGenero(id));
    }

    @PatchMapping("genero")
    public ResponseEntity<Genero> alterarGenero(@RequestBody Genero genero) {
        return ResponseEntity.ok(service.alterarGenero(genero));
    }

    @DeleteMapping("/genero/{id}")
    public ResponseEntity<String> deletarGenero(@PathVariable Long id) {
        return ResponseEntity.ok(service.deletarGenero(id));
    }
}
