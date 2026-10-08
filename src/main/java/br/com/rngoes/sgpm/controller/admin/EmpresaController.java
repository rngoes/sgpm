package br.com.rngoes.sgpm.controller.admin;

import br.com.rngoes.sgpm.model.admin.Empresa;
import br.com.rngoes.sgpm.service.interfaces.admin.IEmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {

    private IEmpresaService service;
    public EmpresaController(IEmpresaService service) {
        this.service = service;
    }

    @PostMapping("/empresa")
    public ResponseEntity<Empresa> addEmpresa(@RequestBody Empresa empresa) {
        empresa.setAtivo(true);
        return ResponseEntity.status(201).body(service.addEmpresa(empresa));
    }

    @GetMapping("/empresa")
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        return ResponseEntity.ok(service.listarEmpresas());
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<Empresa> consultarEmpresa(@PathVariable Integer id) {
        return ResponseEntity.ok(service.consultarEmpresa(id));
    }

    @PatchMapping("empresa")
    public ResponseEntity<Empresa> alterarEmpresa(@RequestBody Empresa empresa) {
        return ResponseEntity.ok(service.alterarEmpresa(empresa));
    }

    @DeleteMapping("/empresa/{id}")
    public ResponseEntity<String> deletarEmpresa(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deletarEmpresa(id));
    }
}
