package com.example.desafio1.controllers;

import com.example.desafio1.model.Veiculo;
import com.example.desafio1.services.VeiculoService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/veiculos")
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) throws JSONException, IOException, InterruptedException {
        System.out.println("Recebido: " + veiculo.getPropietario());
        return veiculoService.salvar(veiculo);
    }
}
