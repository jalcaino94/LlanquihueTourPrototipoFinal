package model;

import utils.ValidacionException;

/**
 */
public abstract class Persona implements Registrable {
    private String rut;
    private String nombre;
    private Direccion direccion; // Composición: Persona TIENE UNA Dirección

    public Persona() {
    }

    public Persona(String rut, String nombre, Direccion direccion) throws ValidacionException {
        setRut(rut); // Usamos el setter para que pase por la validación
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Encapsulamiento y validación
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws ValidacionException {
        if (rut == null || rut.trim().length() < 8) {
            throw new ValidacionException("El RUT ingresado ('" + rut + "') no es válido o está incompleto.");
        }
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public void mostrarDatos() {
        // Llama de forma automática al toString() específico que herede Cliente o Proveedor
        System.out.println(this.toString());
    }
}