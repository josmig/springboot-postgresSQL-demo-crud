package com.pantigoso.app.Model.Service;

import com.pantigoso.app.Model.Entity.Persona;

import java.util.List;

public interface IPersonaService {

    List<Persona> listAll();
    public void save(Persona persona);
    public Persona find(Long id);
    public  void delete(Long id);
}
