package com.example.trainingapijavaclient.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestauranteResumoModel {

	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private CozinhaModel cozinha;
	
//	public String toString() {
//		return nome + " - " + taxaFrete;
//	}
	
}