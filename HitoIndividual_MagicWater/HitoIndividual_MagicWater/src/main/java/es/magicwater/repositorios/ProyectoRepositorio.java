package es.magicwater.repositorios;

import es.magicwater.jpa.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepositorio extends JpaRepository<Proyecto, Integer> {
    @Query("SELECT p FROM Proyecto p INNER JOIN Tarea t ON p.idproyecto = t.proyecto.idproyecto WHERE t.usuario.nif = ?1")
    List<Proyecto> proyectosUsuario(String nif);
    @Query("SELECT MAX(p.idproyecto)+1 FROM Proyecto p")
    public Integer newIdProyecto();
}