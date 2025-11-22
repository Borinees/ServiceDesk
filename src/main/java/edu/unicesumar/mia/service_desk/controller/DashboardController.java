package edu.unicesumar.mia.service_desk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(
            Model model,
            @AuthenticationPrincipal UserDetails usuarioLogado
    ) {

        String nomeUsuario = (usuarioLogado != null)
                ? usuarioLogado.getUsername()
                : "Usuário";

        model.addAttribute("usuarioNome", nomeUsuario);

        // Dados fake por enquanto — depois substituímos pelo serviço
        model.addAttribute("chamadosAbertos", 12);
        model.addAttribute("chamadosAndamento", 8);
        model.addAttribute("concluidosSemana", 25);
        model.addAttribute("tempoRespostaMedio", "2h 30min");

        // Lista simples para testar
        List<Map<String, Object>> ultimosChamados = List.of(
                Map.of("id", 123, "titulo", "Problema com impressora"),
                Map.of("id", 122, "titulo", "Acesso ao sistema"),
                Map.of("id", 121, "titulo", "Lentidão na rede")
        );

        model.addAttribute("ultimosChamados", ultimosChamados);

        return "dashboard";
    }
}
