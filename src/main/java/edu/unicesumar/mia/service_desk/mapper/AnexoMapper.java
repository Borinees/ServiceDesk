package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Anexo;
import edu.unicesumar.mia.service_desk.dto.request.AnexoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.AnexoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface AnexoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataEnvio", expression = "java(java.time.LocalDateTim.now())")
    Anexo toEntity(AnexoRequestDTO dto);

    AnexoResponseDTO toResponse(Anexo entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataEnvio", ignore = true)
    void updateEntityFromRequest(AnexoRequestDTO dto, @MappingTarget Anexo entity);
}
