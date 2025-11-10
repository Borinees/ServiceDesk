package edu.unicesumar.mia.service_desk.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private String tipoUsuario;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
