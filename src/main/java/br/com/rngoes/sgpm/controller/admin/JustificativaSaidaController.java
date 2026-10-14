package br.com.rngoes.sgpm.controller.admin;



import br.com.rngoes.sgpm.model.admin.JustificativaSaida;
import br.com.rngoes.sgpm.service.interfaces.admin.IJustificativaSaidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JustificativaSaidaController {

    private final IJustificativaSaidaService service;
    public JustificativaSaidaController(IJustificativaSaidaService service) {
        this.service = service;
    }

    @PostMapping("/justificativasaida")
    public ResponseEntity<JustificativaSaida> criarJustificativaSaida(@RequestBody JustificativaSaida justificativaSaida) {
        return ResponseEntity.status(201).body(service.criarJustificativaSaida(justificativaSaida));
    }

    @GetMapping("/justificativasaida")
    public ResponseEntity<List<JustificativaSaida>> listarJustificativasSaida() {
        return ResponseEntity.ok(service.listarJustificativasSaida());
    }

    @GetMapping("/justificativasaida/{id}")
    public ResponseEntity<JustificativaSaida> consultarJustificativaSaida(@PathVariable Integer id) {
        return ResponseEntity.ok(service.consultarJustificativaSaida(id));
    }

    @PatchMapping("justificativasaida")
    public ResponseEntity<JustificativaSaida> alterarJustificativaSaida(@RequestBody JustificativaSaida justificativaSaida) {
        return ResponseEntity.ok(service.alterarJustificativaSaida(justificativaSaida));
    }

    @DeleteMapping("/justificativasaida/{id}")
    public ResponseEntity<String> deletarJustificativaSaida(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deletarJustificativaSaida(id));
    }

}
