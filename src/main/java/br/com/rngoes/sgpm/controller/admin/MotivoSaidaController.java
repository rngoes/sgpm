package br.com.rngoes.sgpm.controller.admin;


import br.com.rngoes.sgpm.model.admin.MotivoSaida;
import br.com.rngoes.sgpm.service.interfaces.admin.IMotivoSaidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotivoSaidaController {

    private final IMotivoSaidaService service;
    public MotivoSaidaController(IMotivoSaidaService service) {
        this.service = service;
    }

    @PostMapping("/motivosaida")
    public ResponseEntity<MotivoSaida> criarMotivoSaida(@RequestBody MotivoSaida motivoSaida) {
        return ResponseEntity.status(201).body(service.criarMotivoSaida(motivoSaida));
    }

    @GetMapping("/motivosaida")
    public ResponseEntity<List<MotivoSaida>> listarMotivosSaida() {
        return ResponseEntity.ok(service.listarMotivosSaida());
    }

    @GetMapping("/motivosaida/{id}")
    public ResponseEntity<MotivoSaida> consultarMotivoSaida(@PathVariable Integer id) {
        return ResponseEntity.ok(service.consultarMotivoSaida(id));
    }

    @PatchMapping("motivosaida")
    public ResponseEntity<MotivoSaida> alterarMotivoSaida(@RequestBody MotivoSaida motivoSaida) {
        return ResponseEntity.ok(service.alterarMotivoSaida(motivoSaida));
    }

    @DeleteMapping("/motivosaida/{id}")
    public ResponseEntity<String> deletarMotivoSaida(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deletarMotivoSaida(id));
    }

}
