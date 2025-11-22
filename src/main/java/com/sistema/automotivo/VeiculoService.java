package com.sistema.automotivo.service;

import com.sistema.automotivo.model.Veiculo;
import com.sistema.automotivo.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }
    public List<Veiculo> listar() {
    return listarTodos();
    }

    public Veiculo salvar(Veiculo v) {
        return repository.save(v);
    }

    public Veiculo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Veiculo atualizar(Long id, Veiculo dados) {
        Veiculo existente = buscarPorId(id);

        if (existente == null) return null;

        existente.setMarca(dados.getMarca());
        existente.setModelo(dados.getModelo());
        existente.setAno(dados.getAno());
        existente.setPreco(dados.getPreco());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
