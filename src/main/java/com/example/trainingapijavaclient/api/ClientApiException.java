package com.example.trainingapijavaclient.api;

import com.example.trainingapijavaclient.model.Problem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

/**
 * Exception para quando ocorrer um erro http, ex: 404;
 * Irá pegar o erro enviado para o servidor e deserializar a resposta para a aplicação
 */
@Slf4j
public class ClientApiException extends RuntimeException {

    @Getter
    private Problem problem;

    public ClientApiException(String message) {
        super(message);
    }

    public ClientApiException(String message, RestClientResponseException cause) {
        super(message, cause);
        deserializeProblem(cause);
    }

    private void deserializeProblem(RestClientResponseException cause) {
        ObjectMapper mapper = new ObjectMapper();

        /* início
            essa duas linha abaixos estão adicionando um modulo no jackson para que ele consiga
            deserializar o tipo OffSetDateTime, contido na classe problema.

            dica: a seguir uma prompt no chat gpt para encontrar alguns possíveis môdulos que podem ser registrados
            no ObjectMapper(lista de módulos que podem ser registreado no objectMapper).
         */
        mapper.registerModule(new JavaTimeModule());
        mapper.findAndRegisterModules();
        // fim

        // ativa a configuração para ignorar propriedades que existam no json, mas não existam no objeto.
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            this.problem = mapper.readValue(cause.getResponseBodyAsString(), Problem.class);
        } catch (JsonProcessingException e) {
            log.info("Não foi possível deserializar a resposta em um Problema.class");
        }
    }

    public boolean isNotNull() {
        return this.problem != null;
    }
}
