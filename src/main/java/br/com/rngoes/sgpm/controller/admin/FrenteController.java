package br.com.rngoes.sgpm.controller.admin;

import br.com.rngoes.sgpm.model.admin.Frente;
import br.com.rngoes.sgpm.service.interfaces.admin.IFrenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FrenteController {

    private final IFrenteService service;
    public FrenteController(IFrenteService service) {
        this.service = service;
    }

    @PostMapping("/frente")
    public ResponseEntity<Frente> criarFrente(@RequestBody Frente frente) {
        return ResponseEntity.status(201).body(service.criarFrente(frente));
    }

    @GetMapping("/frente")
    public ResponseEntity<List<Frente>> listarFrentes() {
        return ResponseEntity.ok(service.listarFrentes());
    }

    @GetMapping("/frente/{id}")
    public ResponseEntity<Frente> consultarFrente(@PathVariable Integer id) {
        return ResponseEntity.ok(service.consultarFrente(id));
    }

    @PatchMapping("frente")
    public ResponseEntity<Frente> alterarFrente(@RequestBody Frente frente) {
        return ResponseEntity.ok(service.alterarFrente(frente));
    }

    @DeleteMapping("/frente/{id}")
    public ResponseEntity<String> deletarFrente(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deletarFrente(id));
    }
}
