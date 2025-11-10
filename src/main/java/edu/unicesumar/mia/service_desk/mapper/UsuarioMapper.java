package edu.unicesumar.mia.service_desk.mapper;

import edu.unicesumar.mia.service_desk.bean.Usuario;
import edu.unicesumar.mia.service_desk.dto.request.UsuarioRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.UsuarioResponseDTO;
import edu.unicesumar.mia.service_desk.dto.response.UsuarioResumoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criadoEm", expression = "java(java.time.LocalDateTime.now())")
    Usuario toEntity(UsuarioRequestDTO dto);

    // Mapeia TipoUsuario (enum) para String no DTO de resposta
    @Mapping(target = "tipoUsuario", expression = "java(entity.getTipoUsuario() != null ? entity.getTipoUsuario().name() : null)")
    UsuarioResponseDTO toResponse(Usuario entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criadoEm", ignore = true)
    void updateEntityFromRequest(UsuarioRequestDTO dto, @MappingTarget Usuario entity);

    // Metodo usado para gerar o resumo usado em InteracaoResponseDTO.autor
    @Mapping(target = "tipoUsuario", expression = "java(usuario.getTipoUsuario() != null ? usuario.getTipoUsuario().name() : null)")
    UsuarioResumoDTO toResumo(Usuario usuario);
}