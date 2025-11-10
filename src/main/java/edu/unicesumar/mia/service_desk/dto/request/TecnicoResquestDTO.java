package edu.unicesumar.mia.service_desk.dto.request;

import edu.unicesumar.mia.service_desk.bean.enums.Especialidade;
import edu.unicesumar.mia.service_desk.bean.enums.Setor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TecnicoResquestDTO extends UsuarioRequestDTO {

    private Especialidade especialidade;
    private Setor setor;
    private Boolean disponivel;
}
