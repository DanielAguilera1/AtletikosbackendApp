package com.AtletikosRunningTeam.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 45, nullable = false)
    private String apellido;

    @Column(name = "email", length = 45, unique = true, nullable = false)
    private String email;

    @Column(name = "contrasena", length = 45, nullable = false)
    private String contrasena;

    @Column(name = "telefono", length = 45)
    private String telefono;

    @Column(name = "rol", length = 45, nullable = false)
    private String rol;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "usuario")
    private List<Pago> pagos;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<PlanEntrenamiento> ListaCliente;

    @OneToMany(mappedBy = "entrenador", fetch = FetchType.LAZY)
    private List<PlanEntrenamiento> ListaEntrenador;

    public Usuario() {}
    public Usuario(String nombre, String apellido, String email, String contrasena, String telefono, String rol, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.rol = rol;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public List<Pago> getPagos() {return pagos;}
    public void setPagos(List<Pago> pagos) {this.pagos = pagos;}
    public List<PlanEntrenamiento> getListaCliente() {return ListaCliente;}
    public void setListaCliente(List<PlanEntrenamiento> listaCliente) {ListaCliente = listaCliente;}
    public List<PlanEntrenamiento> getListaEntrenador() {return ListaEntrenador;}
    public void setListaEntrenador(List<PlanEntrenamiento> listaEntrenador) {ListaEntrenador = listaEntrenador;}
}
