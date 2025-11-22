package edu.unicesumar.mia.service_desk.controller;

import edu.unicesumar.mia.service_desk.dto.response.UsuarioResponseDTO;
import edu.unicesumar.mia.service_desk.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TelaUsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<UsuarioResponseDTO> usuarios = usuarioService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }
}
