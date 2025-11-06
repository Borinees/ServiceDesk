package edu.unicesumar.mia.service_desk.bean.dto;

import edu.unicesumar.mia.service_desk.bean.Interacao;
import edu.unicesumar.mia.service_desk.bean.enums.NivelPrioridade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChamadoDTO {
    private String titulo;
    private int id;
    private Interacao categoria;
    private Enum<NivelPrioridade> prioridade;
    private String nomeCliente;
    private String nomeTecnico;
}
