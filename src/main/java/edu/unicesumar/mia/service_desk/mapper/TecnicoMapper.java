package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Tecnico;
import edu.unicesumar.mia.service_desk.dto.request.TecnicoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.TecnicoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, uses = UsuarioMapper.class)
public interface TecnicoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criadoEm", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "chamadosAtivos", ignore = true)
    Tecnico toEntity(TecnicoRequestDTO dto);

    TecnicoResponseDTO toResponse(Tecnico entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criadoEm", ignore = true)
    @Mapping(target = "chamadosAtivos", ignore = true)
    void updateEntityFromRequest(TecnicoRequestDTO dto, @MappingTarget Tecnico entity);
}
