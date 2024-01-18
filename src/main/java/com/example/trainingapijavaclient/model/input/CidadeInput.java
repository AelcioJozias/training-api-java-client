package com.example.trainingapijavaclient.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CidadeInput {
    private Long id;

    public CidadeInput(Long id) {
        setId(id);
    }
}
