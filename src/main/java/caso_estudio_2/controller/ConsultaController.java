package caso_estudio_2.controller;

import caso_estudio_2.service.UsuarioService;
import caso_estudio_2.service.RolService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final UsuarioService usuarioService;
    private final RolService rolService;

    public ConsultaController(UsuarioService usuarioService, RolService rolService) {
        this.usuarioService = usuarioService;
        this.rolService = rolService;
    }

    @GetMapping
    public String mostrarPagina(Model model) {
        model.addAttribute("roles", rolService.listar());
        return "consultas/index";
    }

    @GetMapping("/por-rol")
    public String buscarPorRol(@RequestParam Long rolId, Model model) {
        model.addAttribute("usuarios", usuarioService.buscarPorRol(rolId));
        model.addAttribute("titulo", "Usuarios por Rol");
        return "consultas/resultado";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam String texto, Model model) {
        model.addAttribute("usuarios", usuarioService.buscarPorNombreOEmail(texto));
        model.addAttribute("titulo", "Búsqueda por nombre/email");
        return "consultas/resultado";
    }

    @GetMapping("/fechas")
    public String buscarPorFechas(@RequestParam String inicio,
                                  @RequestParam String fin,
                                  Model model) {

        LocalDateTime d1 = LocalDateTime.parse(inicio + "T00:00:00");
        LocalDateTime d2 = LocalDateTime.parse(fin + "T23:59:59");

        model.addAttribute("usuarios", usuarioService.buscarPorRangoFechas(d1, d2));
        model.addAttribute("titulo", "Usuarios por rango de fechas");
        return "consultas/resultado";
    }

    @GetMapping("/estadisticas")
    public String estadisticas(Model model) {
        model.addAttribute("activos", usuarioService.contarActivos());
        model.addAttribute("inactivos", usuarioService.contarInactivos());
        return "consultas/estadisticas";
    }

    @GetMapping("/ordenados")
    public String ordenados(Model model) {
        model.addAttribute("usuarios", usuarioService.ordenarPorFechaCreacion());
        model.addAttribute("titulo", "Usuarios ordenados por fecha");
        return "consultas/resultado";
    }
}