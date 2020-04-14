package com.pantigoso.app.Controller;

import com.pantigoso.app.Model.Entity.Persona;
import com.pantigoso.app.Model.Service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonaController {


    @Autowired
    private PersonaServiceImpl personaService;

    //listar
    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("title","Registro");
        model.addAttribute("titulo","Registro de Usuarios");
        model.addAttribute("person",personaService.listAll());

        return "persona/listar";
    }
    //guardar
    @GetMapping("/form")
    public String crear(Model model){
        String titulo= "Formulario de Inscripción";
        //instancia del objeto a crear
        Persona persona = new Persona();
        model.addAttribute("per",persona);
        model.addAttribute("title",titulo);
        return "persona/form";
    }

    @PostMapping("/form")
    public String guardar(@ModelAttribute("per")Persona persona, Model model){
        personaService.save(persona);
        return "redirect:/person/listar";
    }

}
