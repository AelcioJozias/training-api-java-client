package com.example.trainingapijavaclient.model.input;

import lombok.Data;

@Data
public class CozinhaInput {

    private Long id;
    public CozinhaInput(Long id) {
        setId(id);
    }
}
