package caso_estudio_2.controller;

import caso_estudio_2.config.SecurityUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    @GetMapping("/perfil")
    public String perfil(Authentication auth, Model model) {

        SecurityUserDetails user = (SecurityUserDetails) auth.getPrincipal();

        model.addAttribute("usuario", user.getUsuario());

        return "perfil/index";
    }
}