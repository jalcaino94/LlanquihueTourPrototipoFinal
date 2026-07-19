package model;

import utils.ValidacionException;

/**
 */
public class Cliente extends Persona {
    private String tipoCliente; // Ejemplo: "Premium", "Turista Habitual"

    public Cliente() {
    }

    public Cliente(String rut, String nombre, Direccion direccion, String tipoCliente) throws ValidacionException {
        super(rut, nombre, direccion); // Constructor
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }

    @Override
    public String toString() {
        return "[CLIENTE] RUT: " + getRut() + " | Nombre: " + getNombre() + " | Dirección: " + getDireccion() + " | Tipo: " + tipoCliente;
    }
}