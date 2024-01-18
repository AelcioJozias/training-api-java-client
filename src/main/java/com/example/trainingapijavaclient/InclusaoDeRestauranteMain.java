package com.example.trainingapijavaclient;

import com.example.trainingapijavaclient.api.ClientApiException;
import com.example.trainingapijavaclient.api.RestauranteClient;
import com.example.trainingapijavaclient.model.RestauranteModel;
import com.example.trainingapijavaclient.model.input.CidadeInput;
import com.example.trainingapijavaclient.model.input.CozinhaInput;
import com.example.trainingapijavaclient.model.input.EnderecoInput;
import com.example.trainingapijavaclient.model.input.RestauranteInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class InclusaoDeRestauranteMain {

    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://localhost:8080");

            RestauranteInput restauranteInput = buildRestauranteInput();

            RestauranteModel restauranteModel = restauranteClient.gravar(restauranteInput);

            System.out.println(restauranteModel);
        } catch (ClientApiException e) {
            if(e.isNotNull()) {
                System.out.println(e.getProblem().getDetail());
                e.getProblem().getFields().forEach(System.out::println);
            } else {
                System.out.println("Erro desconhecido \n");
                log.error(e.getMessage());
            }
        }
    }


    // Isso aqui era 100% melhor eu ter feito em um construtor, mas não vou refazer como é só teste
    private static RestauranteInput buildRestauranteInput() {
        RestauranteInput restauranteInput = new RestauranteInput();
        restauranteInput.setTaxaFrete(00.00);
        restauranteInput.setCozinha(new CozinhaInput(1L));

        // Endereço
        restauranteInput.setEndereco(new EnderecoInput("89520-300",
                "Ruas das rosas",
                "4500",
                "casa",
                "Bela Vista",
                new CidadeInput(1L)));
        return restauranteInput;
    }
}
