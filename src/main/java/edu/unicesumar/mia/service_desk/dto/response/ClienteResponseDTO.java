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
public class ClienteResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private String empresa;
    private String telefone;
    private String tipousuario;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
