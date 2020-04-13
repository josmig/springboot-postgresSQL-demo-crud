package com.pantigoso.app.Controller;

import com.pantigoso.app.Model.Service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonaController {


    @Autowired
    private PersonaServiceImpl personaService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo","Personas Inscritas");
        model.addAttribute("person",personaService.listAll());

        return "persona/listar";
    }


}
