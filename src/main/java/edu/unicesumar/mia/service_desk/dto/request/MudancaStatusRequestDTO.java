package edu.unicesumar.mia.service_desk.dto.request;

import edu.unicesumar.mia.service_desk.bean.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MudancaStatusRequestDTO {
    private Integer chamadoId;
    private Status statusNovo;
}
