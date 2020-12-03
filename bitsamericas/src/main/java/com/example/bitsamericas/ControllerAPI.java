package com.example.bitsamericas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
@RestController
@CrossOrigin
public class ControllerAPI {
    @Autowired
    private Servicios Servicio;
    @GetMapping(value = "https://ipinfo.io.8.8.8.8",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> añadirPostMapaTablero (@RequestBody Locations tareasProyecto, BindingResult resultado){
        if(resultado.hasErrors()){
            Map<String,String> errores = new HashMap<>();
            for(FieldError error: resultado.getFieldErrors()){
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errores,HttpStatus.BAD_REQUEST);
        }
        Locations nuevaTarea = Servicio.guardarActualizarTarea(tareasProyecto);
        return new ResponseEntity<Locations>(nuevaTarea, HttpStatus.CREATED);
    }
}


