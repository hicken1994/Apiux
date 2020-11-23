package com.example.apiux.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class TareasProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message= "El resumen no puede venir vacio, por favor revisar.")
    private String resumen;
    private String criteriosaceptados;
    private String status;

    public TareasProyecto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getCriteriosaceptados() {
        return criteriosaceptados;
    }

    public void setCriteriosaceptados(String criteriosaceptados) {
        this.criteriosaceptados = criteriosaceptados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
