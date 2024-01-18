package com.example.trainingapijavaclient;

import com.example.trainingapijavaclient.api.ClientApiException;
import com.example.trainingapijavaclient.api.RestauranteClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
public class ListagemDeRestaurantesMain {
    public static void main(String[] args) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            RestauranteClient restauranteClient = new RestauranteClient(
                    restTemplate, "http://localhost:8080");

            restauranteClient.listar()
                    .forEach(System.out::println);

        } catch (ClientApiException e) {
            if(e.isNotNull()) {
                System.out.println(e.getProblem().getDetail());
            } else {
                System.out.println("Erro desconhecido \n");
                log.error(e.getMessage());
            }
        } catch (RestClientException e) {
            log.error(e.getMessage());
            throw new ClientApiException("Ocorreu um erro na requisicao");
        }
    }
}
