package edu.unicesumar.mia.service_desk.controller;

import edu.unicesumar.mia.service_desk.dto.request.TecnicoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.TecnicoResponseDTO;
import edu.unicesumar.mia.service_desk.service.TecnicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @GetMapping
    public ResponseEntity<List<TecnicoResponseDTO>> listar() {
        return ResponseEntity.ok(tecnicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoResponseDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(tecnicoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TecnicoResponseDTO> criar(@RequestBody TecnicoRequestDTO dto) {
        return ResponseEntity.ok(tecnicoService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoResponseDTO> atualizar(@PathVariable Integer id, @RequestBody TecnicoRequestDTO dto) {
        return ResponseEntity.ok(tecnicoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        tecnicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
