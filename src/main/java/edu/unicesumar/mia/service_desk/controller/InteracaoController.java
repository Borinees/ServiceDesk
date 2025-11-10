package edu.unicesumar.mia.service_desk.controller;

import edu.unicesumar.mia.service_desk.dto.request.InteracaoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.InteracaoResponseDTO;
import edu.unicesumar.mia.service_desk.service.InteracaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interacoes")
public class InteracaoController {

    private final InteracaoService interacaoService;

    public InteracaoController(InteracaoService interacaoService) {
        this.interacaoService = interacaoService;
    }

    @GetMapping
    public ResponseEntity<List<InteracaoResponseDTO>> listar() {
        return ResponseEntity.ok(interacaoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteracaoResponseDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(interacaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<InteracaoResponseDTO> criar(@RequestBody InteracaoRequestDTO dto) {
        return ResponseEntity.ok(interacaoService.criar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        interacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
