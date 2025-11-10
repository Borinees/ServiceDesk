package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Chamado;
import edu.unicesumar.mia.service_desk.dto.request.ChamadoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.ChamadoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class, uses = {ClienteMapper.class, TecnicoMapper.class})
public interface ChamadoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataAbertura", expression = "java(java.time.LocalDateTime.now())")
    Chamado toEntity(ChamadoRequestDTO dto);

    ChamadoResponseDTO toResponse(Chamado entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataAbertura", ignore = true)
    void updateEntityFromRequest(ChamadoRequestDTO dto, @MappingTarget Chamado entity);
}
