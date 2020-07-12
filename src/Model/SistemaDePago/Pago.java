package Model.SistemaDePago;

import Model.SistemaDeAutenticacion.Usuario;

public class Pago {
    private float cuenta;
    private Usuario usuario;
    private boolean pago_verificado;

    private static int cuenta_pagos; // lleva la cuenta de los pagos que se han generado
    private int id;

    public Pago(Usuario usuario, float cuenta) {
        this.cuenta = cuenta;
        this.usuario = usuario;
        pago_verificado= false;
        cuenta_pagos++;
        id = cuenta_pagos;
    }

    public float getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public void setCuenta(float cuenta) {
        this.cuenta = cuenta;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean generarPago() {
        // Verifica que el pago haya sido realizado
        this.pago_verificado = true;
        return pago_verificado;
    }

    public boolean getPago() {
        return pago_verificado;
    }
}
