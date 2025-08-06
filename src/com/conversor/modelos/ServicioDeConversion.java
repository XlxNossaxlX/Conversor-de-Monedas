package com.conversor.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioDeConversion {

    public ExchangeRateResponse obtenerTasas(String apiKey) {
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
        ExchangeRateResponse exchangeRateResponse = null;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            exchangeRateResponse = gson.fromJson(json, ExchangeRateResponse.class);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al conectar con la API");
            e.printStackTrace();
        }

        return exchangeRateResponse;
    }
}