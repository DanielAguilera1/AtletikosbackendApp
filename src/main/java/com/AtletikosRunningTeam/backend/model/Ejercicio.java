package com.AtletikosRunningTeam.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ejercicios")
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "grupoMuscular", nullable = false)
    private String grupoMuscular;

    @Column(name = "urlVideo")
    private String urlVideo;

    @OneToMany(mappedBy = "ejercicio", fetch = FetchType.LAZY)
    private List<DetallePlanEjercicio> detallePlanEjercicios;

    public Ejercicio(){}
    public Ejercicio(String nombre, String descripcion, String grupoMuscular, String urlVideo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.grupoMuscular = grupoMuscular;
        this.urlVideo = urlVideo;
    }

    public Integer getId() {return id;}
    public void setId(Integer idEjercicio) {this.id = id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public String getGrupoMuscular() {return grupoMuscular;}
    public void setGrupoMuscular(String grupoMuscular) {this.grupoMuscular = grupoMuscular;}
    public String getUrlVideo() {return urlVideo;}
    public void setUrlVideo(String urlVideo) {this.urlVideo = urlVideo;}
    public void set(String metodoPago) {}
    public List<DetallePlanEjercicio> getDetallePlanEjercicios() {return detallePlanEjercicios;}
    public void setDetallePlanEjercicios(List<DetallePlanEjercicio> detallePlanEjercicios) {this.detallePlanEjercicios = detallePlanEjercicios;}
}
