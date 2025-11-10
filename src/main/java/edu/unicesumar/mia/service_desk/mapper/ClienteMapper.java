package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Cliente;
import edu.unicesumar.mia.service_desk.dto.request.ClienteRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.ClienteResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, uses = UsuarioMapper.class)
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criadoEm", expression = "java(java.time.LocalDateTime.now())")
    Cliente toEntity(ClienteRequestDTO dto);

    ClienteResponseDTO toResponse(Cliente entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criadoEm", ignore = true)
    void updateEntityFromRequest(ClienteRequestDTO dto, @MappingTarget Cliente entity);
}
