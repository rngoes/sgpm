package br.com.rngoes.sgpm.controller.admin;

import br.com.rngoes.sgpm.model.admin.Localidade;
import br.com.rngoes.sgpm.service.interfaces.admin.ILocalidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocalidadeController {

    private ILocalidadeService service;
    public LocalidadeController(ILocalidadeService service) {
        this.service = service;
    }

    @PostMapping("/localidade")
    public ResponseEntity<Localidade> addLocalidade(@RequestBody Localidade localidade) {
        localidade.setAtivo(true);
        return ResponseEntity.status(201).body(service.addLocalidade(localidade));
    }

    @GetMapping("/localidade")
    public ResponseEntity<List<Localidade>> listarLocalidade() {
        return ResponseEntity.ok(service.listarLocalidade());
    }

    @GetMapping("/localidade/base")
    public ResponseEntity<List<Localidade>> listarBase() {
        return ResponseEntity.ok(service.listarBase());
    }

    @GetMapping("/localidade/{id}")
    public ResponseEntity<Localidade> consultarLocalidade(@PathVariable Integer id) {
        return ResponseEntity.ok(service.consultarLocalidade(id));
    }

    @PatchMapping("localidade")
    public ResponseEntity<Localidade> alterarLocalidade(@RequestBody Localidade localidade) {
        return ResponseEntity.ok(service.alterarLocalidade(localidade));
    }

    @DeleteMapping("/localidade/{id}")
    public ResponseEntity<String> deletarLocalidade(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deletarLocalidade(id));
    }
}
