package com.sistema.automotivo.model;

import jakarta.persistence.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private Integer quilometragem;
    private Double preco;
    private String status;

    public Veiculo() {}

    // GETTERS E SETTERS

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getAno() { return ano; }

    public void setAno(Integer ano) { this.ano = ano; }

    public String getCor() { return cor; }

    public void setCor(String cor) { this.cor = cor; }

    public Integer getQuilometragem() { return quilometragem; }

    public void setQuilometragem(Integer quilometragem) { this.quilometragem = quilometragem; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
