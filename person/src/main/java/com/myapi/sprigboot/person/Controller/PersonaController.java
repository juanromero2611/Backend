package com.myapi.sprigboot.person.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapi.sprigboot.person.Model.Persona;
import com.myapi.sprigboot.person.Service.PersonaService;
import com.myapi.sprigboot.person.Service.personaDTO;




@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/persona")
    @ResponseBody
    public List<Persona> listarPersona() {
        return personaService.listarPersonas();
    }

    @PostMapping("/persona")
    @ResponseBody
    public Persona crearPersona(@RequestBody Persona persona) {        
        return personaService.crearPersona(persona);
    }

    @DeleteMapping("/persona/{id}")
    public void borrarPersona(@PathVariable Long id){
        personaService.borrarPersona(id);
    }

    @GetMapping("/persona/{id}")
    @ResponseBody
    public Persona buscarPersonaPorId(@PathVariable Long id) {
        return personaService.buscarPersonaPorId(id);
    }

    @PutMapping("/persona")
    public void modificarPersona(@RequestBody Persona persona) {
        personaService.modificarPersona(persona);;
    }
    
    @PostMapping("/login")
    public personaDTO login(@RequestBody Persona persona) {        
        return personaService.login(persona.getUser(), persona.getPassword());
    }
    
    



}
