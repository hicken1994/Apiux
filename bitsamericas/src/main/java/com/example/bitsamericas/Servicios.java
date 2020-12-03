package com.example.bitsamericas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicios {
    @Autowired
    private Repositorio repository;

    public Locations guardarActualizarTarea(Locations ubicacion){
        if(ubicacion.getIp()==(null) || ubicacion.getHostname()==("")){
            ubicacion.setReadme("ERROR INFORMACION NO VALIDA");
        }
        return repository.save(ubicacion);
    }


    public Iterable<Locations> encontrarTodos(){
        return repository.findAll();
    }


}