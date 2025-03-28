package com.example.desafio1.services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConsumirApiService {
    private String marca;
    private String modelo;
    private String chassi;
    private Boolean licenciado;

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

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Boolean getLicenciado() {
        return licenciado;
    }

    public void setLicenciado(Boolean licenciado) {
        this.licenciado = licenciado;
    }

    public void consumindoApi(String placa) throws IOException, InterruptedException, JSONException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://my.api.mockaroo.com/veiculos?key=55ad1cd0&placa=" + placa))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject jsonObject = new JSONObject(response.body());
                this.marca = jsonObject.getString("marca");
                this.modelo = jsonObject.getString("modelo");
                this.chassi = jsonObject.getString("chassi");
                this.licenciado = jsonObject.getBoolean("licenciado");
            } else {
                System.out.println("Erro ao consultar api!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
