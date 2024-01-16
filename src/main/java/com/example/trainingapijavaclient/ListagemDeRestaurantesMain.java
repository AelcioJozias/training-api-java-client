package com.example.trainingapijavaclient;

import com.example.trainingapijavaclient.api.RestauranteClient;
import org.springframework.web.client.RestTemplate;

public class ListagemDeRestaurantesMain {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        RestauranteClient restauranteClient = new RestauranteClient(
                restTemplate, "http://localhost:8080");

        restauranteClient.listar()
                .forEach(System.out::println);
    }
}
