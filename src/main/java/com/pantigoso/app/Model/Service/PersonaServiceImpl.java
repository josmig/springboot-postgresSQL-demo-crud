package com.pantigoso.app.Model.Service;

import com.pantigoso.app.Model.Dao.IPersonaDao;
import com.pantigoso.app.Model.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    public IPersonaDao personaDao;


    @Override
    @Transactional(readOnly = true)
    public List<Persona> listAll() {
        return (List<Persona>)personaDao.findAll();
    }

    @Override
    public void save(Persona persona) {

    }

    @Override
    public Persona find(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
