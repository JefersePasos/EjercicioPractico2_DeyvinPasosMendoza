package caso_estudio_2.controller;

import caso_estudio_2.config.SecurityUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/redirect")
    public String redirectByRole(Authentication auth) {

        SecurityUserDetails user = (SecurityUserDetails) auth.getPrincipal();
        String rol = user.getAuthorities().iterator().next().getAuthority();

        if (rol.equals("ROLE_ADMIN")) {
            return "redirect:/usuarios";
        }
        if (rol.equals("ROLE_PROFESOR")) {
            return "redirect:/reportes";
        }
        return "redirect:/perfil";
    }
}