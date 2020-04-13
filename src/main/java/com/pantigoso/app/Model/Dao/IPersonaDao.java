package com.pantigoso.app.Model.Dao;

import com.pantigoso.app.Model.Entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona,Long> {
    //Con crudrepository viene todo implemetado por detras
}
