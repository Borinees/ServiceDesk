package edu.unicesumar.mia.service_desk.service;

import edu.unicesumar.mia.service_desk.bean.Anexo;
import edu.unicesumar.mia.service_desk.dto.request.AnexoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.AnexoResponseDTO;
import edu.unicesumar.mia.service_desk.mapper.AnexoMapper;
import edu.unicesumar.mia.service_desk.repository.AnexoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnexoService {

    private final AnexoRepository anexoRepository;
    private final AnexoMapper anexoMapper;

    public AnexoService(AnexoRepository anexoRepository, AnexoMapper anexoMapper) {
        this.anexoRepository = anexoRepository;
        this.anexoMapper = anexoMapper;
    }

    public List<AnexoResponseDTO> listarTodos() {
        return anexoRepository.findAll()
                .stream()
                .map(anexoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public AnexoResponseDTO buscarPorId(Integer id) {
        Anexo anexo = anexoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anexo não encontrado"));
        return anexoMapper.toResponse(anexo);
    }

    public AnexoResponseDTO criar(AnexoRequestDTO dto) {
        Anexo anexo = anexoMapper.toEntity(dto);
        anexo = anexoRepository.save(anexo);
        return anexoMapper.toResponse(anexo);
    }

    public AnexoResponseDTO atualizar(Integer id, AnexoRequestDTO dto) {
        Anexo anexo = anexoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anexo não encontrado"));
        anexoMapper.updateEntityFromRequest(dto, anexo);
        anexo = anexoRepository.save(anexo);
        return anexoMapper.toResponse(anexo);
    }

    public void deletar(Integer id) {
        if (!anexoRepository.existsById(id)) {
            throw new RuntimeException("Anexo não encontrado");
        }
        anexoRepository.deleteById(id);
    }
}