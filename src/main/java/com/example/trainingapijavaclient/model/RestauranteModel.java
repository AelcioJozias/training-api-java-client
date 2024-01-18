package com.example.trainingapijavaclient.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RestauranteModel {
    private Long id;
    private String nome;
    private Double taxaFrete;
    private CozinhaModel cozinhaModel;
    private boolean ativo;
    private boolean aberto;
    private EnderecoModel endereco;
}
