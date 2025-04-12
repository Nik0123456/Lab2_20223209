package gtics.l2_20223209_implementacion.Controller;
import gtics.l2_20223209_implementacion.Entity.Auto;
import gtics.l2_20223209_implementacion.Repository.AutoRepository;
import gtics.l2_20223209_implementacion.Repository.SedeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AutoController {

    final AutoRepository autoRepository;
    final SedeRepository sedeRepository;

    public AutoController(AutoRepository autoRepository, SedeRepository sedeRepository) {
        this.autoRepository = autoRepository;
        this.sedeRepository = sedeRepository;
    }

    //Listar autos
    @GetMapping("/autos/listar")
    public String listarAutos(Model model) {

        List<Auto> listaAutos = autoRepository.findAll();
        model.addAttribute("listaAutos", listaAutos);

        return "ListarAutos";
    }

    //Formulario de crear auto
    @GetMapping("/autos/crear")
    public String crearAuto(Model model) {

        model.addAttribute("auto", new Auto());
        model.addAttribute("listaSedes", sedeRepository.findAll());

        return "CrearAutos";
    }

}
