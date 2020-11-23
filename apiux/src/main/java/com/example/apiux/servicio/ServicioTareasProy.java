package com.example.apiux.servicio;

import com.example.apiux.dominio.TareasProyecto;
import com.example.apiux.repositorio.TareasProyectoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioTareasProy {
    @Autowired
    private TareasProyectoRepo projectTareasRepo;

    public TareasProyecto guardarActualizarTarea(TareasProyecto tareaproyecto){
        if(tareaproyecto.getStatus()==(null) || tareaproyecto.getStatus()==("")){
             tareaproyecto.setStatus("PARA_HACER");
    }
    return projectTareasRepo.save(tareaproyecto);
 }
 public Iterable<TareasProyecto> encontrarTodos(){
        return projectTareasRepo.findAll();
 }

 public TareasProyecto encontrarporId(Long id){
        return projectTareasRepo.getById(id);
 }

    public void borrar(Long id){
        TareasProyecto tareasProyecto = encontrarporId(id);
        projectTareasRepo.delete(tareasProyecto);
    }

 }
