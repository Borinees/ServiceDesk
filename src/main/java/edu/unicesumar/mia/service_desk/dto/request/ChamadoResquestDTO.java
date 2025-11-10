package edu.unicesumar.mia.service_desk.dto.request;

import edu.unicesumar.mia.service_desk.bean.enums.NivelPrioridade;
import edu.unicesumar.mia.service_desk.bean.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChamadoResquestDTO {

    private String titulo;
    private String descricao;

    private Integer clienteId;
    private Integer tecnicoId;
    private Integer categoriaId;
    private Integer servicoId;

    private NivelPrioridade prioridade;
    private Status status;

    @Builder.Default
    private LocalDateTime dataAbertura = LocalDateTime.now();

    private LocalDateTime dataFechamento;

}
