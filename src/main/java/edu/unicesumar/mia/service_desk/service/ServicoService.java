package edu.unicesumar.mia.service_desk.service;

import edu.unicesumar.mia.service_desk.bean.Servico;
import edu.unicesumar.mia.service_desk.dto.request.ServicoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.ServicoResponseDTO;
import edu.unicesumar.mia.service_desk.mapper.ServicoMapper;
import edu.unicesumar.mia.service_desk.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {
    private final ServicoRepository servicoRepository;
    private final ServicoMapper servicoMapper;

    public ServicoService(ServicoRepository servicoRepository, ServicoMapper servicoMapper) {
        this.servicoRepository = servicoRepository;
        this.servicoMapper = servicoMapper;
    }

    public List<ServicoResponseDTO> listarTodos() {
        return servicoRepository.findAll()
                .stream()
                .map(servicoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ServicoResponseDTO buscarPorId(Integer id) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        return servicoMapper.toResponse(servico);
    }

    public ServicoResponseDTO criar(ServicoRequestDTO dto) {
        Servico servico = servicoMapper.toEntity(dto);
        servico = servicoRepository.save(servico);
        return servicoMapper.toResponse(servico);
    }

    public ServicoResponseDTO atualizar(Integer id, ServicoRequestDTO dto) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        servicoMapper.updateEntityFromRequest(dto, servico);
        servico = servicoRepository.save(servico);
        return servicoMapper.toResponse(servico);
    }

    public void deletar(Integer id) {
        if (!servicoRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado");
        }
        servicoRepository.deleteById(id);
    }
}
