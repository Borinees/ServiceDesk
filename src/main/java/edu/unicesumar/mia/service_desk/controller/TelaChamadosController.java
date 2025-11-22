package edu.unicesumar.mia.service_desk.controller;

import edu.unicesumar.mia.service_desk.dto.response.ChamadoResponseDTO;
import edu.unicesumar.mia.service_desk.dto.response.TecnicoResponseDTO;
import edu.unicesumar.mia.service_desk.service.ChamadoService;
import edu.unicesumar.mia.service_desk.service.TecnicoService;
import edu.unicesumar.mia.service_desk.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TelaChamadosController {

    private final ChamadoService chamadoService;
    private final TecnicoService tecnicoService;

    @GetMapping("/chamados")
    public String listarChamados(
            @RequestParam(required = false) String busca,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String prioridade,
            @RequestParam(required = false) Integer tecnicoId,
            @RequestParam(required = false) String inicio,
            @RequestParam(required = false) String fim,
            Model model
    ) {
        List<ChamadoResponseDTO> chamados = chamadoService.filtrarChamados(
                busca,
                status,
                prioridade,
                tecnicoId,
                inicio != null ? LocalDate.parse(inicio) : null,
                fim != null ? LocalDate.parse(fim) : null
        );

        List<TecnicoResponseDTO> tecnicos = tecnicoService.listarTodos();

        model.addAttribute("chamados", chamados);
        model.addAttribute("tecnicos", tecnicos);

        return "chamados";
    }
}
