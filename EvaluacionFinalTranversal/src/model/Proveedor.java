package model;

import utils.ValidacionException;

/**
 */
public class Proveedor extends Persona {
    private String tipoServicio; // Ejemplo: "Alojamiento", "Gastronomía", "Transporte"

    public Proveedor() {
    }

    public Proveedor(String rut, String nombre, Direccion direccion, String tipoServicio) throws ValidacionException {
        super(rut, nombre, direccion); // Constructor de Persona
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }

    @Override
    public String toString() {
        return "[PROVEEDOR] RUT: " + getRut() + " | Nombre: " + getNombre() + " | Dirección: " + getDireccion() + " | Servicio: " + tipoServicio;
    }
}