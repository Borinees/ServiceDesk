package edu.unicesumar.mia.service_desk.controller;

import edu.unicesumar.mia.service_desk.dto.request.ServicoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.ServicoResponseDTO;
import edu.unicesumar.mia.service_desk.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> listar() {
        return ResponseEntity.ok(servicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> criar(@RequestBody ServicoRequestDTO dto) {
        return ResponseEntity.ok(servicoService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> atualizar(@PathVariable Integer id, @RequestBody ServicoRequestDTO dto) {
        return ResponseEntity.ok(servicoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        servicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
