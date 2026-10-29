package com.AtletikosRunningTeam.backend.dto.response;

import java.time.LocalDate;

public class ListarPagos {
    private Long id;
    private Long usuario;
    private Double monto;
    private String metodoPago;
    private String estadoPago;
    private LocalDate fechaPago;

    public ListarPagos(Long id, Long usuario, Double monto, String metodoPago, String estadoPago, LocalDate fechaPago) {
        this.id = id;
        this.usuario = usuario;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.fechaPago = fechaPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
}
