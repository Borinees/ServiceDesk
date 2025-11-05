package edu.unicesumar.mia.service_desk.bean.dto;

import edu.unicesumar.mia.service_desk.bean.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private String nome;
    private String email;
    private int id;
    private Enum<TipoUsuario> tipoUsuario;
}
