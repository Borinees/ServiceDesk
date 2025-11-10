package edu.unicesumar.mia.service_desk.controller;

import edu.unicesumar.mia.service_desk.dto.request.AnexoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.AnexoResponseDTO;
import edu.unicesumar.mia.service_desk.service.AnexoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anexos")
public class AnexoController {

    private final AnexoService anexoService;

    public AnexoController(AnexoService anexoService) {
        this.anexoService = anexoService;
    }

    @GetMapping
    public ResponseEntity<List<AnexoResponseDTO>> listar() {
        return ResponseEntity.ok(anexoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnexoResponseDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(anexoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AnexoResponseDTO> criar(@RequestBody AnexoRequestDTO dto) {
        return ResponseEntity.ok(anexoService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnexoResponseDTO> atualizar(@PathVariable Integer id, @RequestBody AnexoRequestDTO dto) {
        return ResponseEntity.ok(anexoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        anexoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}