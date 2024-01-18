package com.example.trainingapijavaclient.api;



import com.example.trainingapijavaclient.model.RestauranteModel;
import com.example.trainingapijavaclient.model.RestauranteResumoModel;
import com.example.trainingapijavaclient.model.input.RestauranteInput;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {

	private static final String RESOURCE_PATH = "/restaurantes";
	
	private RestTemplate restTemplate;
	private String url;
	
	public List<RestauranteResumoModel> listar() {
		try {
			URI resourceUri = URI.create(url + RESOURCE_PATH);
			// primeiro parametro a url, segundo parametro o objeto que já sera serializado na resposta
			RestauranteResumoModel[] restaurantes = restTemplate
					.getForObject(resourceUri, RestauranteResumoModel[].class);

			return  restaurantes != null ? Arrays.asList(restaurantes) : new ArrayList<RestauranteResumoModel>();
		} catch (RestClientResponseException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}

	public RestauranteModel gravar(RestauranteInput restauranteInput) {
		try {
			URI resourceUri = URI.create(url + RESOURCE_PATH);
			return restTemplate.postForEntity(resourceUri, restauranteInput, RestauranteModel.class).getBody();
		} catch (RestClientResponseException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}
}