package edu.unicesumar.mia.service_desk.controller;

import edu.unicesumar.mia.service_desk.dto.response.ChamadoResponseDTO;
import edu.unicesumar.mia.service_desk.dto.response.UsuarioResponseDTO;
import edu.unicesumar.mia.service_desk.service.ChamadoService;
import edu.unicesumar.mia.service_desk.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class TelaChamadoController {

    private final ChamadoService chamadoService;
    private final UsuarioService usuarioService;

    @GetMapping("/chamados/{id}")
    public String telaChamado(
            @PathVariable Integer id,
            Model model,
            Principal principal
    ) {
        ChamadoResponseDTO chamado = chamadoService.buscarPorId(id);

        String emailUsuario = principal.getName();

        UsuarioResponseDTO usuarioLogado = usuarioService.buscarPorEmail(emailUsuario);

        model.addAttribute("chamado", chamado);
        model.addAttribute("usuarioLogado", usuarioLogado);

        return "chamado";
    }
}
