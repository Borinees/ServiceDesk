package edu.unicesumar.mia.service_desk.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicoRequestDTO {
    private String nome;
    private String descricao;
    private String categoriaId;
    private Integer slaHoras;
}
