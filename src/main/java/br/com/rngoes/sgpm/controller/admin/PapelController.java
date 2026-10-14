package br.com.rngoes.sgpm.controller.admin;

import br.com.rngoes.sgpm.model.admin.Papel;
import br.com.rngoes.sgpm.service.interfaces.admin.IPapelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PapelController {

    private final IPapelService service;
    public PapelController(IPapelService service) {
        this.service = service;
    }

    @PostMapping("/papel")
    public ResponseEntity<Papel> criarPapel(@RequestBody Papel papel) {
        return ResponseEntity.status(201).body(service.criarPapel(papel));
    }

    @GetMapping("/papel")
    public ResponseEntity<List<Papel>> listarPapeis() {
        return ResponseEntity.ok(service.listarPapeis());
    }

    @GetMapping("/papel/admin")
    public ResponseEntity<List<Papel>> listarPapeisAdministrador() {
        return ResponseEntity.ok(service.listarPapeisByAdministrador(true));
    }

    @GetMapping("/papel/user")
    public ResponseEntity<List<Papel>> listarPapeisUser() {
        return ResponseEntity.ok(service.listarPapeisByAdministrador(false));
    }

    @GetMapping("/papel/{id}")
    public ResponseEntity<Papel> consultarPapel(@PathVariable Integer id) {
        return ResponseEntity.ok(service.consultarPapel(id));
    }

    @PatchMapping("papel")
    public ResponseEntity<Papel> alterarPapel(@RequestBody Papel papel) {
        return ResponseEntity.ok(service.alterarPapel(papel));
    }

    @DeleteMapping("/papel/{id}")
    public ResponseEntity<String> deletarPapel(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deletarPapel(id));
    }
}
