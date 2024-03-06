package es.magicwater.repositorios;

import es.magicwater.jpa.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Integer> {
    @Query("SELECT MAX(t.idtarea)+1 FROM Tarea t")
    public Integer newIdTarea();

    List<Tarea> findByEstado(String estado);
}