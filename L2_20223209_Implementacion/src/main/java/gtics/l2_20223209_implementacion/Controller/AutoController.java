package gtics.l2_20223209_implementacion.Controller;
import gtics.l2_20223209_implementacion.Entity.Auto;
import gtics.l2_20223209_implementacion.Repository.AutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AutoController {

    final AutoRepository autoRepository;

    public AutoController(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    //Listar autos
    @GetMapping("/autos/listar")
    public String listarAutos(Model model) {

        List<Auto> listaAutos = autoRepository.findAll();
        model.addAttribute("listaAutos", listaAutos);

        return "ListarAutos";
    }

}
