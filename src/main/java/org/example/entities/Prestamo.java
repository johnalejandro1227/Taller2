package org.example.entities;

import javax.persistence.*;
import  java.util.Date;

@Entity
@Table(name = "prestamo")
public class Prestamo implements org.example.interfaces.Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @OneToOne
    @JoinColumn(name = "id_libro")
    private Libro idLibro;


    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_prestamo")
    private Date fechaPrestamo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_devolucion")
    private Date fechaDevolucion;

    private boolean activo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public Libro getIdLibro() {
        return idLibro;
    }

    @Override
    public void setIdLibro(Libro idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    @Override
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public boolean isActivo() {
        return activo;
    }

    @Override
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}


