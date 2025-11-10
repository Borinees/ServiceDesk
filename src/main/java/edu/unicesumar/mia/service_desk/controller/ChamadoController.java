package edu.unicesumar.mia.service_desk.controller;

import edu.unicesumar.mia.service_desk.dto.request.ChamadoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.ChamadoResponseDTO;
import edu.unicesumar.mia.service_desk.service.ChamadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @GetMapping
    public ResponseEntity<List<ChamadoResponseDTO>> listar() {
        return ResponseEntity.ok(chamadoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(chamadoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ChamadoResponseDTO> criar(@RequestBody ChamadoRequestDTO dto) {
        return ResponseEntity.ok(chamadoService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> atualizar(@PathVariable Integer id, @RequestBody ChamadoRequestDTO dto) {
        return ResponseEntity.ok(chamadoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        chamadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
