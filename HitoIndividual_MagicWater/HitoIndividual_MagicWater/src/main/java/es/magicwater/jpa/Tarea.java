package es.magicwater.jpa;

import jakarta.persistence.*;
import java.util.Date;


@Entity
public class Tarea {

    @Id
    private int idtarea;

    private String descripcion;

    private String estado;

    @Temporal(TemporalType.DATE)
    private Date finprevisto;

    @Temporal(TemporalType.DATE)
    private Date finreal;

    @Temporal(TemporalType.DATE)
    private Date inicioprevisto;

    @Temporal(TemporalType.DATE)
    private Date inicioreal;

    private String titulo;

    //bi-directional many-to-one association to Usuario
    @ManyToOne
    @JoinColumn(name="nif")
    private Usuario usuario;

    //bi-directional many-to-one association to Proyecto
    @ManyToOne
    @JoinColumn(name="idproyecto")
    private Proyecto proyecto;

    public Tarea() {
    }

    public int getIdtarea() {
        return this.idtarea;
    }

    public void setIdtarea(int idtarea) {
        this.idtarea = idtarea;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFinprevisto() {
        return this.finprevisto;
    }

    public void setFinprevisto(Date finprevisto) {
        this.finprevisto = finprevisto;
    }

    public Date getFinreal() {
        return this.finreal;
    }

    public void setFinreal(Date finreal) {
        this.finreal = finreal;
    }

    public Date getInicioprevisto() {
        return this.inicioprevisto;
    }

    public void setInicioprevisto(Date inicioprevisto) {
        this.inicioprevisto = inicioprevisto;
    }

    public Date getInicioreal() {
        return this.inicioreal;
    }

    public void setInicioreal(Date inicioreal) {
        this.inicioreal = inicioreal;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Proyecto getProyecto() {
        return this.proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

}
