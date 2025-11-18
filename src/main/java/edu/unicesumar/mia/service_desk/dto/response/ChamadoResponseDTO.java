package edu.unicesumar.mia.service_desk.dto.response;

import edu.unicesumar.mia.service_desk.bean.MudancaStatus;
import edu.unicesumar.mia.service_desk.bean.enums.NivelPrioridade;
import edu.unicesumar.mia.service_desk.bean.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChamadoResponseDTO {

    private Integer id;
    private String titulo;
    private String descricao;

    private NivelPrioridade prioridade;
    private Status status;
    private MudancaStatus mudancaStatus;

    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    private ClienteResponseDTO cliente;
    private TecnicoResponseDTO tecnico;
    private CategoriaResponseDTO categoria;
    private ServicoResponseDTO servico;

    private List<InteracaoResponseDTO> interacoes;
}
