package com.AtletikosRunningTeam.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_planes_ejercicios")
public class DetallePlanEjercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private PlanEntrenamiento planEntrenamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ejercicio_id", nullable = false)
    private Ejercicio ejercicio;

    @Column(name = "dia_semana", length = 30, nullable = false)
    private String diaSemana;

    @Column(name = "series", length = 45, nullable = false)
    private String series;

    @Column(name = "repeticiones", length = 45, nullable = false)
    private String repeticiones;

    @Column(name = "peso_sugerido", length = 45, nullable = false)
    private String pesoSugerido;

    public DetallePlanEjercicio(){}

    public DetallePlanEjercicio(String diaSemana, String series, String repeticiones, String pesoSugerido) {
        this.diaSemana = diaSemana;
        this.series = series;
        this.repeticiones = repeticiones;
        this.pesoSugerido = pesoSugerido;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getDiaSemana() {return diaSemana;}
    public void setDiaSemana(String diaSemana) {this.diaSemana = diaSemana;}
    public String getSeries() {return series;}
    public void setSeries(String series) {this.series = series;}
    public String getRepeticiones() {return repeticiones;}
    public void setRepeticiones(String repeticiones) {this.repeticiones = repeticiones;}
    public String getPesoSugerido() {return pesoSugerido;}
    public void setPesoSugerido(String pesoSugerido) {this.pesoSugerido = pesoSugerido;}
    public PlanEntrenamiento getPlanEntrenamiento() {return planEntrenamiento;}
    public void setPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) {this.planEntrenamiento = planEntrenamiento;}
    public Ejercicio getEjercicio() {return ejercicio;}
    public void setEjercicio(Ejercicio ejercicio) {this.ejercicio = ejercicio;}
}
