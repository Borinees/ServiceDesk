package edu.unicesumar.mia.service_desk.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Usuario{
    private String empresa;
    private String telefone;
}
