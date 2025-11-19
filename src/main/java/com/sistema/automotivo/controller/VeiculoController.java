package com.sistema.automotivo.controller;

import com.sistema.automotivo.model.Veiculo;
import com.sistema.automotivo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping
    public List<Veiculo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        Veiculo v = service.buscarPorId(id);
        if (v != null) {
            return ResponseEntity.ok(v);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Veiculo salvar(@RequestBody Veiculo veiculo) {
        return service.salvar(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Veiculo v = service.atualizar(id, veiculo);
        if (v != null) {
            return ResponseEntity.ok(v);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
