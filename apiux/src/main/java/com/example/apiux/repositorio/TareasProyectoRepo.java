package com.example.apiux.repositorio;

import com.example.apiux.dominio.TareasProyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasProyectoRepo extends CrudRepository<TareasProyecto,Long> {

    TareasProyecto getById(Long Id);
}
