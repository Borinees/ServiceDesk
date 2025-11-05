package edu.unicesumar.mia.service_desk.bean;

import edu.unicesumar.mia.service_desk.bean.enums.NivelPrioridade;
import edu.unicesumar.mia.service_desk.bean.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Chamado {
    private String titulo;
    private String descricao;
    private Categoria categoria;
    private Enum<NivelPrioridade> prioridade;
    private Enum<Status> status;
    private Cliente cliente;
    private Tecnico tecnico;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
}
