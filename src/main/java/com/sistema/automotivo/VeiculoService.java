package com.sistema.automotivo.service;

import com.sistema.automotivo.model.Veiculo;
import com.sistema.automotivo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public List<Veiculo> listar() {
        return repository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public Veiculo atualizar(Long id, Veiculo dados) {
        return repository.findById(id).map(v -> {
            v.setMarca(dados.getMarca());
            v.setModelo(dados.getModelo());
            v.setAno(dados.getAno());
            v.setCor(dados.getCor());
            v.setQuilometragem(dados.getQuilometragem());
            v.setPreco(dados.getPreco());
            v.setStatus(dados.getStatus());
            return repository.save(v);
        }).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
