package edu.unicesumar.mia.service_desk.controller;

import edu.unicesumar.mia.service_desk.dto.request.ChamadoRequestDTO;
import edu.unicesumar.mia.service_desk.dto.response.CategoriaResponseDTO;
import edu.unicesumar.mia.service_desk.dto.response.ServicoResponseDTO;
import edu.unicesumar.mia.service_desk.dto.response.UsuarioResponseDTO;
import edu.unicesumar.mia.service_desk.service.CategoriaService;
import edu.unicesumar.mia.service_desk.service.ChamadoService;
import edu.unicesumar.mia.service_desk.service.ServicoService;
import edu.unicesumar.mia.service_desk.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chamados")
public class ChamadoFormController {

    private final ChamadoService chamadoService;
    private final CategoriaService categoriaService;
    private final ServicoService servicoService;
    private final UsuarioService usuarioService;

    @GetMapping("/novo")
    public String abrirFormulario(Model model) {

        List<CategoriaResponseDTO> categorias = categoriaService.listarTodos();
        List<ServicoResponseDTO> servicos = servicoService.listarTodos();

        model.addAttribute("categorias", categorias);
        model.addAttribute("servicos", servicos);
        model.addAttribute("chamado", new ChamadoRequestDTO());

        return "chamado_form";
    }

    @GetMapping("/novo")
    public String salvarChamado(
            @ModelAttribute ChamadoRequestDTO chamado,
            @RequestParam("anexos") List<MultipartFile> anexos,
            Principal principal
    ) {
        String email = principal.getName();
        UsuarioResponseDTO usuario= usuarioService.buscarPorEmail(email);

        chamado.setClienteId(usuario.getId());

        chamadoService.criar(chamado, anexos);

        return "redirect:/chamados";
    }
}
