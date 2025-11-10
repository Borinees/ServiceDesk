package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Interacao;
import edu.unicesumar.mia.service_desk.dto.request.InteracaoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.InteracaoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface InteracaoMapper {

    @Mapping(target = "id", ignore = true)
    Interacao toEntity(InteracaoRequestDTO dto);

    InteracaoResponseDTO toResponse(Interacao entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(InteracaoRequestDTO dto, @MappingTarget Interacao entity);
}
