package com.AtletikosRunningTeam.backend.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name="monto", nullable = false)
    private double monto;

    @Column(name="fecha_pago", nullable = false)
    private Date fechaPago;

    @Column(name="metodo_pago", nullable = false)
    private String metodoPago;

    @Column(name="estado_pago", nullable = false)
    private String estadoPago;

    public Pago(){}
    public Pago(double monto, Date fechaPago, String metodoPago, String estadoPago) {
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public Usuario getUser() {return usuario;}
    public void setUser(Usuario usuario) {this.usuario = usuario;}
    public double getMonto() {return monto;}
    public void setMonto(double monto) {this.monto = monto;}
    public Date getFechaPago() {return fechaPago;}
    public void setFechaPago(Date fechaPago) {this.fechaPago = fechaPago;}
    public String getMetodoPago() {return metodoPago;}
    public void setMetodoPago(String metodoPago) {this.metodoPago = metodoPago;}
    public String getEstadoPago() {return estadoPago;}
    public void setEstadoPago(String estadoPago) {this.estadoPago = estadoPago;}

}
