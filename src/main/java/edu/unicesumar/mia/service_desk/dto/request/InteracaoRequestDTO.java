package edu.unicesumar.mia.service_desk.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InteracaoRequestDTO {
    private Integer chamadoId;
    private Integer usuarioId;
    private String mensagem;
}
