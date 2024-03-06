package es.magicwater.jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class Usuario {

    @Id
    private String nif;

    private byte activo;

    private String apellidos;

    private String categoria;

    private String email;

    private String nombre;

    private String password;

    private String permiso;

    private String tlf;

    //bi-directional many-to-one association to Tarea
    @OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
    private List<Tarea> tareas;

    public Usuario() {
    }

    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public byte getActivo() {
        return this.activo;
    }

    public void setActivo(byte activo) {
        this.activo = activo;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermiso() {
        return this.permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getTlf() {
        return this.tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public List<Tarea> getTareas() {
        return this.tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }


    public Tarea addTarea(Tarea tarea) {
        getTareas().add(tarea);
        tarea.setUsuario(this);

        return tarea;
    }

    public Tarea removeTarea(Tarea tarea) {
        getTareas().remove(tarea);
        tarea.setUsuario(null);

        return tarea;
    }

}
