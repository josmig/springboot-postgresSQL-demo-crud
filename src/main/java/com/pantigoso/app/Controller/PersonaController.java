package com.pantigoso.app.Controller;

import com.pantigoso.app.Model.Entity.Persona;
import com.pantigoso.app.Model.Service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        //model.addAttribute("per",persona);
        model.addAttribute("persona",persona);
        model.addAttribute("title",titulo);
        return "persona/form";
    }


    @PostMapping("/form")
    //@ModelAttribute("per")
    public String guardar(@Valid Persona persona, BindingResult bindingResult, Model model){
        //Si hay errores retorna al formulario
        if(bindingResult.hasErrors()){
            String titulo = "Formulario";
            model.addAttribute("title",titulo);
            return "persona/form";
        }
        personaService.save(persona);
        return "redirect:/person/listar";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable(value= "id")Long id, Model model){

        Persona persona = null;
        if(id > 0){
            persona = personaService.find(id);
        }
        model.addAttribute("per",persona);
        return "persona/form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id")Long id){
        if(id > 0){
            personaService.delete(id);
        }
        return "redirect:/person/listar";
    }


}
