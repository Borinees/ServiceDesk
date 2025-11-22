package edu.unicesumar.mia.service_desk.service;

import edu.unicesumar.mia.service_desk.bean.Chamado;
import edu.unicesumar.mia.service_desk.dto.request.ChamadoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.ChamadoResponseDTO;
import edu.unicesumar.mia.service_desk.mapper.ChamadoMapper;
import edu.unicesumar.mia.service_desk.repository.ChamadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;
    private final ChamadoMapper chamadoMapper;

    public ChamadoService(ChamadoRepository chamadoRepository, ChamadoMapper chamadoMapper) {
        this.chamadoRepository = chamadoRepository;
        this.chamadoMapper = chamadoMapper;
    }

    public List<ChamadoResponseDTO> listarTodos() {
        return chamadoRepository.findAll()
                .stream()
                .map(chamadoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ChamadoResponseDTO buscarPorId(Integer id) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
        return chamadoMapper.toResponse(chamado);
    }

    public ChamadoResponseDTO criar(ChamadoRequestDTO dto, List<MultipartFile> anexos) {
        Chamado chamado = chamadoMapper.toEntity(dto);
        chamado = chamadoRepository.save(chamado);
        return chamadoMapper.toResponse(chamado);
    }

    public ChamadoResponseDTO atualizar(Integer id, ChamadoRequestDTO dto) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
        chamadoMapper.updateEntityFromRequest(dto, chamado);
        chamado = chamadoRepository.save(chamado);
        return chamadoMapper.toResponse(chamado);
    }

    public void deletar(Integer id) {
        if (!chamadoRepository.existsById(id)) {
            throw new RuntimeException("Chamado não encontrado");
        }
        chamadoRepository.deleteById(id);
    }

    public List<ChamadoResponseDTO> filtrarChamados(
            String busca,
            String status,
            String prioridade,
            Integer tecnicoId,
            LocalDate inicio,
            LocalDate fim
    ) {
        return chamadoRepository.findAll().stream()
                .filter(c -> busca == null || c.getTitulo().toLowerCase().contains(busca.toLowerCase()) ||
                        c.getDescricao().toLowerCase().contains(busca.toLowerCase()))
                .filter(c -> status == null || c.getStatus().name().equalsIgnoreCase(status))
                .filter(c -> prioridade == null || c.getPrioridade().name().equalsIgnoreCase(prioridade))
                .filter(c -> tecnicoId == null || (c.getTecnico() != null && c.getTecnico().getId().equals(tecnicoId)))
                .filter(c -> inicio == null || !c.getDataAbertura().toLocalDate().isBefore(inicio))
                .filter(c -> fim == null || !c.getDataAbertura().toLocalDate().isAfter(fim))
                .map(chamadoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
