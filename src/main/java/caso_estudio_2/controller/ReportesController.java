package caso_estudio_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportesController {

    @GetMapping("/reportes")
    public String reportes(Model model) {

        // Materias y notas simuladas EN EL MISMO ORDEN
        String[] materias = {"Programación I", "Base de Datos", "Desarrollo Web", "Redes", "Matemática Discreta"};
        int[] notas = {95, 82, 91, 76, 88};

        // Encontrar la nota más alta
        int mejorNota = 0;
        String mejorMateria = "";

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > mejorNota) {
                mejorNota = notas[i];
                mejorMateria = materias[i];
            }
        }

        model.addAttribute("materias", materias);
        model.addAttribute("notas", notas);

        model.addAttribute("mejorNota", mejorNota);
        model.addAttribute("mejorMateria", mejorMateria);

        return "reportes/index";
    }
}