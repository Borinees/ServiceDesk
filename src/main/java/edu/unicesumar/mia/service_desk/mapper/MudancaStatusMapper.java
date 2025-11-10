package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.MudancaStatus;
import edu.unicesumar.mia.service_desk.dto.request.MudancaStatusRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.MudancaStatusResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, uses = ChamadoMapper.class)
public interface MudancaStatusMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataMudanca", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "chamado", ignore = true)
    MudancaStatus toEntity(MudancaStatusRequestDTO dto);

    MudancaStatusResponseDTO toResponse(MudancaStatus entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataMudanca", ignore = true)
    void updateEntityFromRequest(MudancaStatusRequestDTO dto, @MappingTarget MudancaStatus entity);
}
