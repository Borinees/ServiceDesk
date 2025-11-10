package edu.unicesumar.mia.service_desk.service;

import edu.unicesumar.mia.service_desk.bean.Tecnico;
import edu.unicesumar.mia.service_desk.dto.request.TecnicoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.TecnicoResponseDTO;
import edu.unicesumar.mia.service_desk.mapper.TecnicoMapper;
import edu.unicesumar.mia.service_desk.repository.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TecnicoService {

    private final TecnicoRepository tecnicoRepository;
    private final TecnicoMapper tecnicoMapper;

    public TecnicoService(TecnicoRepository tecnicoRepository, TecnicoMapper tecnicoMapper) {
        this.tecnicoRepository = tecnicoRepository;
        this.tecnicoMapper = tecnicoMapper;
    }

    public List<TecnicoResponseDTO> listarTodos() {
        return tecnicoRepository.findAll()
                .stream()
                .map(tecnicoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public TecnicoResponseDTO buscarPorId(Integer id) {
        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Técnico não encontrado"));
        return tecnicoMapper.toResponse(tecnico);
    }

    public TecnicoResponseDTO criar(TecnicoRequestDTO dto) {
        Tecnico tecnico = tecnicoMapper.toEntity(dto);
        tecnico = tecnicoRepository.save(tecnico);
        return tecnicoMapper.toResponse(tecnico);
    }

    public TecnicoResponseDTO atualizar(Integer id, TecnicoRequestDTO dto) {
        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Técnico não encontrado"));
        tecnicoMapper.updateEntityFromRequest(dto, tecnico);
        tecnico = tecnicoRepository.save(tecnico);
        return tecnicoMapper.toResponse(tecnico);
    }

    public void deletar(Integer id) {
        if (!tecnicoRepository.existsById(id)) {
            throw new RuntimeException("Técnico não encontrado");
        }
        tecnicoRepository.deleteById(id);
    }
}