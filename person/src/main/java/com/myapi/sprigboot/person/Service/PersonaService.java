package com.myapi.sprigboot.person.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapi.sprigboot.person.Model.Persona;
import com.myapi.sprigboot.person.Repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepo;

    public Persona crearPersona(Persona persona){
        return personaRepo.save(persona);
    }

    public void borrarPersona(Long id){
        personaRepo.deleteById(id);
    }

    public List<Persona> listarPersonas(){
        return personaRepo.findAll();
    }

    public Persona buscarPersonaPorId(Long id){
        return personaRepo.findById(id).orElse(null);
    }

    public void modificarPersona(Persona persona){
        personaRepo.save(persona);
    }

    public personaDTO login(String user, String password) {        
       Persona persona = personaRepo.findByUserAndPassword(user, password);
    
       personaDTO personaDTO = new personaDTO(persona.getId(), persona.getUbication(), persona.getPosition(), persona.getFullName() ,persona.getImage());
    return personaDTO;
    }

}

/*this.id = id;
        this.ubication = ubication;
        this.position = position;
        this.fullName = fullName;
        this.image = image; */