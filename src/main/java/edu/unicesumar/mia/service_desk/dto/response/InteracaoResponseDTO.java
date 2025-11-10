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
public class InteracaoResponseDTO {
    private Integer id;
    private String mensagem;
    private LocalDateTime dataEnvio;

    // informaçoes minimas do autor da interacao
    private UsuarioResumoDTO autor;
}
