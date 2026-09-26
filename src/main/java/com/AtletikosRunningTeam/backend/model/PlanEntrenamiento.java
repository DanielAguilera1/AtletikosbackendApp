package com.AtletikosRunningTeam.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "planes_entrenamiento")
public class PlanEntrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_plan", length = 45, nullable = false)
    private String nombrePlan;

    @Column(name = "descripcion", length = 45, nullable = false)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    // --- FORANEA: idEntrenador ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenador_id", nullable = false)
    private Usuario entrenador;

    // --- FORANEA: idCliente ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    @Column(name = "estado", nullable = false)
    private Estado estado;

    @OneToMany(mappedBy = "planEntrenamiento", fetch = FetchType.LAZY)
    private List<DetallePlanEjercicio> detallePlanEjercicios;

    public PlanEntrenamiento(){}
    public PlanEntrenamiento(String nombrePlan, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Usuario entrenador, Usuario cliente, Estado estado) {
        this.nombrePlan = nombrePlan;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.entrenador = entrenador;
        this.cliente = cliente;
        this.estado = estado;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNombrePlan() {return nombrePlan;}
    public void setNombrePlan(String nombrePlan) {this.nombrePlan = nombrePlan;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public LocalDate getFechaInicio() {return fechaInicio;}
    public void setFechaInicio(LocalDate fechaInicio) {this.fechaInicio = fechaInicio;}
    public LocalDate getFechaFin() {return fechaFin;}
    public void setFechaFin(LocalDate fechaFin) {this.fechaFin = fechaFin;}
    public Usuario getEntrenador() {return entrenador;}
    public void setIdEntrenador(Usuario entrenador) {this.entrenador = entrenador;}
    public Usuario getCliente() {return cliente;}
    public void setIdCliente(Usuario cliente) {this.cliente = cliente;}
    public Estado getEstado() {return estado;}
    public void setEstado(Estado estado) {this.estado = estado;}
    public void setEntrenador(Usuario entrenador) {this.entrenador = entrenador;}
    public void setCliente(Usuario cliente) {this.cliente = cliente;}
}