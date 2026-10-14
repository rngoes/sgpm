package br.com.rngoes.sgpm.controller.admin;

import br.com.rngoes.sgpm.model.admin.Wbs;
import br.com.rngoes.sgpm.service.interfaces.admin.IWbsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WbsController {

    private final IWbsService service;
    public WbsController(IWbsService service) {
        this.service = service;
    }

    @PostMapping("/wbs")
    public ResponseEntity<Wbs> criarWbs(@RequestBody Wbs wbs) {
        return ResponseEntity.status(201).body(service.criarWbs(wbs));
    }

    @GetMapping("/wbs")
    public ResponseEntity<List<Wbs>> listarWbs() {
        return ResponseEntity.ok(service.listarWbs());
    }

    @GetMapping("/wbs/{id}")
    public ResponseEntity<Wbs> consultarWbs(@PathVariable Integer id) {
        return ResponseEntity.ok(service.consultarWbs(id));
    }

    @PatchMapping("wbs")
    public ResponseEntity<Wbs> alterarWbs(@RequestBody Wbs wbs) {
        return ResponseEntity.ok(service.alterarWbs(wbs));
    }

    @DeleteMapping("/wbs/{id}")
    public ResponseEntity<String> deletarWbs(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deletarWbs(id));
    }

}
