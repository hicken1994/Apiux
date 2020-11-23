package com.example.apiux.web;

import com.example.apiux.dominio.TareasProyecto;
import com.example.apiux.servicio.ServicioTareasProy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ControladorProyectoTarea {
    @Autowired
    private ServicioTareasProy proyectoTareasServ;
    @PostMapping("")
    public ResponseEntity<?> añadirPostMapaTablero (@RequestBody TareasProyecto tareasProyecto, BindingResult resultado){
        if(resultado.hasErrors()){
            Map<String,String> errores = new HashMap<>();
            for(FieldError error: resultado.getFieldErrors()){
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errores,HttpStatus.BAD_REQUEST);
        }
        TareasProyecto nuevaTarea = proyectoTareasServ.guardarActualizarTarea(tareasProyecto);
        return new ResponseEntity<TareasProyecto>(nuevaTarea, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public Iterable<TareasProyecto> obtenerTareasProyecto(){
     return proyectoTareasServ.encontrarTodos();
    }
    @GetMapping("/{proy_id}")
    public ResponseEntity<?> obtenerTareasProyectoporId(@PathVariable Long proy_id){
        TareasProyecto tareasProyecto = proyectoTareasServ.encontrarporId(proy_id);
        return new ResponseEntity<TareasProyecto>(tareasProyecto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{proy_id}")
    public ResponseEntity<?> borrarTareas(@PathVariable Long proy_id){

        proyectoTareasServ.borrar(proy_id);

        return new ResponseEntity<String>("Se borra la tarea, gracias ",HttpStatus.OK);
    }

}
