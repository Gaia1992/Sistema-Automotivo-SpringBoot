package com.sistema.automotivo.controller;

import com.sistema.automotivo.model.Veiculo;
import com.sistema.automotivo.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Veiculo> listar() {
        return service.listarTodos(); // aqui estava o erro, agora está correto
    }

    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo v) {
        return service.salvar(v);
    }

    @GetMapping("/{id}")
    public Veiculo buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
