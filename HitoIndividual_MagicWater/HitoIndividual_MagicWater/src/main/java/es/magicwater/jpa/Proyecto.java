package es.magicwater.jpa;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Proyecto {

    @Id
    private int idproyecto;

    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String nombre;

    private String zona;

    //bi-directional many-to-one association to Tarea
    @OneToMany(mappedBy="proyecto")
    private List<Tarea> tareas;

    public Proyecto() {
    }

    public int getIdproyecto() {
        return this.idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getZona() {
        return this.zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public List<Tarea> getTareas() {
        return this.tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Tarea addTarea(Tarea tarea) {
        getTareas().add(tarea);
        tarea.setProyecto(this);

        return tarea;
    }

    public Tarea removeTarea(Tarea tarea) {
        getTareas().remove(tarea);
        tarea.setProyecto(null);

        return tarea;
    }

}

