package com.example.desafio1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Integer id;

    @JsonProperty
    private String propietario;

    @Column(unique = true)
    private String cpf;
    @Column(unique = true)

    private String placa;
    private String chassi;
    private String marca;
    private String modelo;
    private Boolean licenciado;

    public Veiculo(String propietario, String cpf, String placa) {
        this.propietario = propietario;
        this.cpf = cpf;
        this.placa = placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getLicenciado() {
        return licenciado;
    }

    public void setLicenciado(Boolean licenciado) {
        this.licenciado = licenciado;
    }
}
