package edu.unicesumar.mia.service_desk.service;

import edu.unicesumar.mia.service_desk.bean.Cliente;
import edu.unicesumar.mia.service_desk.dto.request.ClienteRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.ClienteResponseDTO;
import edu.unicesumar.mia.service_desk.mapper.ClienteMapper;
import edu.unicesumar.mia.service_desk.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO buscarPorId(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return clienteMapper.toResponse(cliente);
    }

    public ClienteResponseDTO criar(ClienteRequestDTO dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toResponse(cliente);
    }

    public ClienteResponseDTO atualizar(Integer id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteMapper.updateEntityFromRequest(dto, cliente);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toResponse(cliente);
    }

    public void deletar(Integer id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
