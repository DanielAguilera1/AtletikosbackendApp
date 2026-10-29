package com.AtletikosRunningTeam.backend.dto.request;

import com.AtletikosRunningTeam.backend.model.Usuario;

import java.time.LocalDate;

public class UsuarioRequest {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private LocalDate fechaNacimiento;
    private String rol;

    public UsuarioRequest(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario convertirUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioRequest.getNombre());
        usuario.setApellido(usuarioRequest.getApellido());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setContrasena(usuarioRequest.getContrasena());
        usuario.setFechaNacimiento(usuarioRequest.getFechaNacimiento());
        usuario.setFechaRegistro(LocalDate.now());
        usuario.setRol("Usuario");
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRol() {return rol;}

    public void setRol(String rol) {this.rol = rol;}
}
