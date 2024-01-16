package com.example.trainingapijavaclient.api;



import com.example.trainingapijavaclient.model.RestauranteResumoModel;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {

	private static final String RESOURCE_PATH = "/restaurantes";
	
	private RestTemplate restTemplate;
	private String url;
	
	public List<RestauranteResumoModel> listar() {
		URI resourceUri = URI.create(url + RESOURCE_PATH);
		// primeiro parametro a url, segundo parametro o objeto que já sera serializado na resposta
		RestauranteResumoModel[] restaurantes = restTemplate
				.getForObject(resourceUri, RestauranteResumoModel[].class);
		
		return Arrays.asList(restaurantes);
	}
	
}