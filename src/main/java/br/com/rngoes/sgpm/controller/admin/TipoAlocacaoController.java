package br.com.rngoes.sgpm.controller.admin;

import br.com.rngoes.sgpm.model.admin.TipoAlocacao;
import br.com.rngoes.sgpm.service.interfaces.admin.ITipoAlocacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TipoAlocacaoController {

    private final ITipoAlocacaoService service;
    public TipoAlocacaoController(ITipoAlocacaoService service) {
        this.service = service;
    }

    @PostMapping("/tipoalocacao")
    public ResponseEntity<TipoAlocacao> criarTipoAlocacao(@RequestBody TipoAlocacao tipoAlocacao) {
        return ResponseEntity.status(201).body(service.criarTipoAlocacao(tipoAlocacao));
    }

    @GetMapping("/tipoalocacao")
    public ResponseEntity<List<TipoAlocacao>> listarTiposAlocacao() {
        return ResponseEntity.ok(service.listarTiposAlocacao());
    }

    @GetMapping("/tipoalocacao/{id}")
    public ResponseEntity<TipoAlocacao> consultarTipoAlocacao(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultarTipoAlocacao(id));
    }

    @PatchMapping("tipoalocacao")
    public ResponseEntity<TipoAlocacao> alterarTipoAlocacao(@RequestBody TipoAlocacao tipoAlocacao) {
        return ResponseEntity.ok(service.alterarTipoAlocacao(tipoAlocacao));
    }

    @DeleteMapping("/tipoalocacao/{id}")
    public ResponseEntity<String> deletarTipoAlocacao(@PathVariable Long id) {
        return ResponseEntity.ok(service.deletarTipoAlocacao(id));
    }

}
