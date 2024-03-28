package com.myapi.sprigboot.person.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapi.sprigboot.person.Model.Persona;


@Repository
public interface PersonaRepository extends JpaRepository<Persona , Long>{
    //Aquí entran los Query Methods

    public Persona findByUserAndPassword(String user, String password);








}
