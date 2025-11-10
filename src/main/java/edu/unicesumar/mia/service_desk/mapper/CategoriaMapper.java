package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Categoria;
import edu.unicesumar.mia.service_desk.dto.request.CategoriaRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.CategoriaResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface CategoriaMapper {

    @Mapping(target = "id", ignore = true)
    Categoria toEntity(CategoriaRequestDTO dto);

    CategoriaResponseDTO toResponse(Categoria entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(CategoriaRequestDTO dto, @MappingTarget Categoria entity);
}
