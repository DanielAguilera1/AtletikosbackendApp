package com.AtletikosRunningTeam.backend.dto.request;

public class PagoDTO {
    private Long usuario;
    private Double monto;
    private String metodoPago;
    private String estadoPago;

    public PagoDTO(long usuario, double monto, String metodoPago, String estadoPago) {
        this.usuario = usuario;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
    }

    public long getUsuario() {
        return usuario;
    }

    public void setUsuario(long usuario) {
        this.usuario = usuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
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
