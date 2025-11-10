package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Servico;
import edu.unicesumar.mia.service_desk.dto.request.ServicoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.ServicoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, uses = CategoriaMapper.class)
public interface ServicoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criadoEm", expression = "java(java.time.LocalDateTime.now())")
    Servico toEntity(ServicoRequestDTO dto);

    ServicoResponseDTO toResponse(Servico entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criadoEm", ignore = true)
    void updateEntityFromRequest(ServicoRequestDTO dto, @MappingTarget Servico entity);
}
