package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Interacao;
import edu.unicesumar.mia.service_desk.dto.request.InteracaoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.InteracaoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, uses = {UsuarioMapper.class, ChamadoMapper.class})
public interface InteracaoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataEnvio", expression = "java(java.time.LocalDateTime.now())")
    // mapear ids aninhados vindos do DTO para as referencias da entidade
    @Mapping(target = "usuario.id", source = "usuarioId")
    @Mapping(target = "chamado.id", source = "chamadoId")
    Interacao toEntity(InteracaoRequestDTO dto);

    // mapear usuario -> autor (precisa existir um método em UsuarioMapper que converta Usuario para UsuarioResumoDTO)
    @Mapping(target = "autor", source = "usuario")
    InteracaoResponseDTO toResponse(Interacao entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataEnvio", ignore = true)
    // ao atualizar, normalmente não alteramos as referências usuario/chamado aqui
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "chamado", ignore = true)
    void updateEntityFromRequest(InteracaoRequestDTO dto, @MappingTarget Interacao entity);
}