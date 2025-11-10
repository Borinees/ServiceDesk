package edu.unicesumar.mia.service_desk.controller;

import edu.unicesumar.mia.service_desk.dto.request.MudancaStatusRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.MudancaStatusResponseDTO;
import edu.unicesumar.mia.service_desk.service.MudancaStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mudancas-status")
public class MudancaStatusController {

    private final MudancaStatusService mudancaStatusService;

    public MudancaStatusController(MudancaStatusService mudancaStatusService) {
        this.mudancaStatusService = mudancaStatusService;
    }

    @GetMapping
    public ResponseEntity<List<MudancaStatusResponseDTO>> listar() {
        return ResponseEntity.ok(mudancaStatusService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MudancaStatusResponseDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(mudancaStatusService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MudancaStatusResponseDTO> criar(@RequestBody MudancaStatusRequestDTO dto) {
        return ResponseEntity.ok(mudancaStatusService.criar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        mudancaStatusService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
