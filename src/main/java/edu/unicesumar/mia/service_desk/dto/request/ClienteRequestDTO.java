package edu.unicesumar.mia.service_desk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClienteRequestDTO extends UsuarioRequestDTO{

    @Size(max = 100)
    private String empresa;

    @NotBlank
    @Size(max = 20)
    private String telefone;
}
