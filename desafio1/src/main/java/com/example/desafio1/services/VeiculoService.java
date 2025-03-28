package com.example.desafio1.services;

import com.example.desafio1.model.Veiculo;
import com.example.desafio1.repositories.VeiculoRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;
    private ConsumirApiService consumirApiService = new ConsumirApiService();

    public Veiculo salvar(Veiculo veiculo) throws JSONException, IOException, InterruptedException {
        consumirApiService.consumindoApi(veiculo.getPlaca());
        veiculo.setMarca(consumirApiService.getMarca());
        veiculo.setModelo(consumirApiService.getModelo());
        veiculo.setChassi(consumirApiService.getChassi());
        veiculo.setLicenciado(consumirApiService.getLicenciado());

        System.out.println("Marca: " + veiculo.getMarca());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Chassi: " + veiculo.getChassi());
        System.out.println("Licenciado: " + veiculo.getLicenciado());

        return veiculoRepository.save(veiculo);
    }

}
