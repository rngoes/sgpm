package br.com.rngoes.sgpm.controller.admin;

import br.com.rngoes.sgpm.model.admin.Genero;
import br.com.rngoes.sgpm.model.admin.NivelCarreira;
import br.com.rngoes.sgpm.service.interfaces.admin.INivelCarreiraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NivelCarreiraController {

    private INivelCarreiraService service;
    public NivelCarreiraController(INivelCarreiraService service) {
        this.service = service;
    }

    @PostMapping("/nivelcarreira")
    public ResponseEntity<NivelCarreira> addNivelCarreira(@RequestBody NivelCarreira nivelCarreira) {
        nivelCarreira.setAtivo(true);
        return ResponseEntity.status(201).body(service.addNivelCarreira(nivelCarreira));
    }

    @GetMapping("/nivelcarreira")
    public ResponseEntity<List<NivelCarreira>> listarNivelCarreira() {
        return ResponseEntity.ok(service.listarNivelCarreira());
    }

    @GetMapping("/nivelcarreira/{id}")
    public ResponseEntity<NivelCarreira> consultarNivelCarreira(@PathVariable Integer id) {
        return ResponseEntity.ok(service.consultarNivelCarreira(id));
    }

    @PatchMapping("nivelcarreira")
    public ResponseEntity<NivelCarreira> alterarNivelCarreira(@RequestBody NivelCarreira nivelCarreira) {
        return ResponseEntity.ok(service.alterarNivelCarreira(nivelCarreira));
    }

    @DeleteMapping("/nivelcarreira/{id}")
    public ResponseEntity<String> deletarNivelCarreira(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deletarNivelCarreira(id));
    }
}
