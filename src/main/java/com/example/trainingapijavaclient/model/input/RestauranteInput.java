package com.example.trainingapijavaclient.model.input;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteInput {

    private String nome;
    private Double taxaFrete;
    private CozinhaInput cozinha;
    private EnderecoInput endereco;

}
