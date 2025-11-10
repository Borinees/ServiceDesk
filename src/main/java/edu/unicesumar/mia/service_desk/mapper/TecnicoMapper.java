package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Tecnico;
import edu.unicesumar.mia.service_desk.dto.request.TecnicoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.TecnicoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface TecnicoMapper {

    @Mapping(target = "id", ignore = true)
    Tecnico toEntity(TecnicoRequestDTO dto);

    TecnicoResponseDTO toResponse(Tecnico entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(TecnicoRequestDTO dto, @MappingTarget Tecnico entity);
}
