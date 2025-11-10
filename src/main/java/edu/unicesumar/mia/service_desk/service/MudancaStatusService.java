package edu.unicesumar.mia.service_desk.service;

import edu.unicesumar.mia.service_desk.bean.MudancaStatus;
import edu.unicesumar.mia.service_desk.dto.request.MudancaStatusRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.MudancaStatusResponseDTO;
import edu.unicesumar.mia.service_desk.mapper.MudancaStatusMapper;
import edu.unicesumar.mia.service_desk.repository.MudancaStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MudancaStatusService {

    private final MudancaStatusRepository mudancaStatusRepository;
    private final MudancaStatusMapper mudancaStatusMapper;

    public MudancaStatusService(MudancaStatusRepository mudancaStatusRepository, MudancaStatusMapper mudancaStatusMapper) {
        this.mudancaStatusRepository = mudancaStatusRepository;
        this.mudancaStatusMapper = mudancaStatusMapper;
    }

    public List<MudancaStatusResponseDTO> listarTodos() {
        return mudancaStatusRepository.findAll()
                .stream()
                .map(mudancaStatusMapper::toResponse)
                .collect(Collectors.toList());
    }

    public MudancaStatusResponseDTO buscarPorId(Integer id) {
        MudancaStatus mudanca = mudancaStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mudança de status não encontrada"));
        return mudancaStatusMapper.toResponse(mudanca);
    }

    public MudancaStatusResponseDTO criar(MudancaStatusRequestDTO dto) {
        MudancaStatus mudanca = mudancaStatusMapper.toEntity(dto);
        mudanca = mudancaStatusRepository.save(mudanca);
        return mudancaStatusMapper.toResponse(mudanca);
    }

    public void deletar(Integer id) {
        if (!mudancaStatusRepository.existsById(id)) {
            throw new RuntimeException("Mudança de status não encontrada");
        }
        mudancaStatusRepository.deleteById(id);
    }
}