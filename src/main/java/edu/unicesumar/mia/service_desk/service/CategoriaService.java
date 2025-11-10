package edu.unicesumar.mia.service_desk.service;

import edu.unicesumar.mia.service_desk.bean.Categoria;
import edu.unicesumar.mia.service_desk.dto.request.CategoriaRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.CategoriaResponseDTO;
import edu.unicesumar.mia.service_desk.mapper.CategoriaMapper;
import edu.unicesumar.mia.service_desk.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public List<CategoriaResponseDTO> listarTodos() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CategoriaResponseDTO buscarPorId(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return categoriaMapper.toResponse(categoria);
    }

    public CategoriaResponseDTO criar(CategoriaRequestDTO dto) {
        Categoria categoria = categoriaMapper.toEntity(dto);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toResponse(categoria);
    }

    public CategoriaResponseDTO atualizar(Integer id, CategoriaRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoriaMapper.updateEntityFromRequest(dto, categoria);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toResponse(categoria);
    }

    public void deletar(Integer id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada");
        }
        categoriaRepository.deleteById(id);
    }
}
