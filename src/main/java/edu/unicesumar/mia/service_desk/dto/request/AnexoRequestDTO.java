package edu.unicesumar.mia.service_desk.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnexoRequestDTO {
    private Integer chamadoId;
    private MultipartFile arquivo;
}
