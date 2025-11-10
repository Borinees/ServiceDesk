package edu.unicesumar.mia.service_desk.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResumoDTO {
    private Integer id;
    private String nome;
    private String email;
    private String tipoUsuario;
}
