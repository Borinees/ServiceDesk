package edu.unicesumar.mia.service_desk.service;

import edu.unicesumar.mia.service_desk.bean.Interacao;
import edu.unicesumar.mia.service_desk.dto.request.InteracaoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.InteracaoResponseDTO;
import edu.unicesumar.mia.service_desk.mapper.InteracaoMapper;
import edu.unicesumar.mia.service_desk.repository.InteracaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InteracaoService {

    private final InteracaoRepository interacaoRepository;
    private final InteracaoMapper interacaoMapper;

    public InteracaoService(InteracaoRepository interacaoRepository, InteracaoMapper interacaoMapper) {
        this.interacaoRepository = interacaoRepository;
        this.interacaoMapper = interacaoMapper;
    }

    public List<InteracaoResponseDTO> listarTodos() {
        return interacaoRepository.findAll()
                .stream()
                .map(interacaoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public InteracaoResponseDTO buscarPorId(Integer id) {
        Interacao interacao = interacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interação não encontrada"));
        return interacaoMapper.toResponse(interacao);
    }

    public InteracaoResponseDTO criar(InteracaoRequestDTO dto) {
        Interacao interacao = interacaoMapper.toEntity(dto);
        interacao = interacaoRepository.save(interacao);
        return interacaoMapper.toResponse(interacao);
    }

    public InteracaoResponseDTO atualizar(Integer id, InteracaoRequestDTO dto) {
        Interacao interacao = interacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interação não encontrada"));
        interacaoMapper.updateEntityFromRequest(dto, interacao);
        interacao = interacaoRepository.save(interacao);
        return interacaoMapper.toResponse(interacao);
    }

    public void deletar(Integer id) {
        if (!interacaoRepository.existsById(id)) {
            throw new RuntimeException("Interação não encontrada");
        }
        interacaoRepository.deleteById(id);
    }
}