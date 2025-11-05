package edu.unicesumar.mia.service_desk.bean;

import edu.unicesumar.mia.service_desk.bean.enums.TipoUsuario;

public class Usuario extends EntidadeBase{
    private String nome;
    private String email;
    private String senha;
    private Enum<TipoUsuario> tipoUsuario;
}
