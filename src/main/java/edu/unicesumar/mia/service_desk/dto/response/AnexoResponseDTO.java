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
public class AnexoResponseDTO {
    private Integer id;
    private String nomeArquivo;
    private String caminhoArquivo;
    private LocalDateTime dataEnvio;
}
