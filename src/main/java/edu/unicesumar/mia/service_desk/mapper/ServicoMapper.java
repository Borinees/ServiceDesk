package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Servico;
import edu.unicesumar.mia.service_desk.dto.request.ServicoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.ServicoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface ServicoMapper {

    @Mapping(target = "id", ignore = true)
    Servico toEntity(ServicoRequestDTO dto);

    ServicoResponseDTO toResponse(Servico entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(ServicoRequestDTO dto, @MappingTarget Servico entity);
}
