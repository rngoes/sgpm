package br.com.rngoes.sgpm.controller.admin;

import br.com.rngoes.sgpm.model.admin.SituacaoProjeto;
import br.com.rngoes.sgpm.service.interfaces.admin.ISituacaoProjetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SituacaoProjetoController {

    private final ISituacaoProjetoService service;
    public SituacaoProjetoController(ISituacaoProjetoService service){
        this.service = service;
    }

    @PostMapping("/situacaoprojeto")
    public ResponseEntity<SituacaoProjeto> criarSituacaoProjeto(@RequestBody SituacaoProjeto situacaoProjeto) {
        return ResponseEntity.status(201).body(service.criarSituacaoProjeto(situacaoProjeto));
    }

    @GetMapping("/situacaoprojeto")
    public ResponseEntity<List<SituacaoProjeto>> listarSituacaoProjeto() {
        return ResponseEntity.ok(service.listarSituacoesProjeto());
    }

    @GetMapping("/situacaoprojeto/{id}")
    public ResponseEntity<SituacaoProjeto> consultarSituacaoProjeto(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultarSituacaoProjeto(id));
    }

    @PatchMapping("situacaoprojeto")
    public ResponseEntity<SituacaoProjeto> alterarSituacaoProjeto(@RequestBody SituacaoProjeto situacaoProjeto) {
        return ResponseEntity.ok(service.alterarSituacaoProjeto(situacaoProjeto));
    }

    @DeleteMapping("/situacaoprojeto/{id}")
    public ResponseEntity<String> deletarSituacaoProjeto(@PathVariable Long id) {
        return ResponseEntity.ok(service.deletarSituacaoProjeto(id));
    }

}
