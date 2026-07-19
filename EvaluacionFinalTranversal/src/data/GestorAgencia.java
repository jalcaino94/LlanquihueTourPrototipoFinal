package data;

import model.Cliente;
import model.Proveedor;
import model.Direccion;
import model.Registrable;
import utils.LectorArchivo;
import utils.ValidacionException;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class GestorAgencia {
    // Colección polimórfica homogénea requerida por la pauta
    private ArrayList<Registrable> listaEntidades = new ArrayList<>();

    public void agregarEntidad(Registrable entidad) {
        listaEntidades.add(entidad);
    }

    /**
     */
    public void cargarDatosDesdeArchivo(String rutaArchivo) {
        List<String> lineas = LectorArchivo.leerArchivo(rutaArchivo);

        for (String linea : lineas) {
            // Suponemos formato
            String[] partes = linea.split(";");

            if (partes.length < 6) {
                System.out.println("⚠️ Línea con formato incorrecto u omitida: " + linea);
                continue;
            }

            String tipo = partes[0].trim();
            String rut = partes[1].trim();
            String nombre = partes[2].trim();
            String calle = partes[3].trim();
            String comuna = partes[4].trim();
            String datoExtra = partes[5].trim();

            try {
                //dirección
                Direccion dir = new Direccion(calle, comuna);

                // Polimorfismo
                if (tipo.equalsIgnoreCase("CLIENTE")) {
                    Cliente nuevoCliente = new Cliente(rut, nombre, dir, datoExtra);
                    agregarEntidad(nuevoCliente);
                } else if (tipo.equalsIgnoreCase("PROVEEDOR")) {
                    Proveedor nuevoProveedor = new Proveedor(rut, nombre, dir, datoExtra);
                    agregarEntidad(nuevoProveedor);
                }

            } catch (ValidacionException e) {
                // Captura de RUTs inválidos
                System.out.println("Error de validación al cargar registro [" + nombre + "]: " + e.getMessage());
            }
        }
    }

    /**
     */
    public void listarTodo() {
        if (listaEntidades.isEmpty()) {
            System.out.println("No hay registros cargados en el sistema.");
            return;
        }

        for (Registrable r : listaEntidades) {

            r.mostrarDatos();
        }
    }

    public ArrayList<Registrable> getListaEntidades() {
        return listaEntidades;
    }
}