package com.example.trainingapijavaclient.model;

import com.example.trainingapijavaclient.model.input.CidadeInput;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EnderecoModel {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeModel cidade;
}
