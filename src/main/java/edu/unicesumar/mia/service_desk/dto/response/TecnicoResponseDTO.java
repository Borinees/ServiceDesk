package edu.unicesumar.mia.service_desk.dto.response;

import edu.unicesumar.mia.service_desk.bean.enums.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TecnicoResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private Especialidade especialidade;
    private boolean disponivel;
    private String tipoUsuario;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
