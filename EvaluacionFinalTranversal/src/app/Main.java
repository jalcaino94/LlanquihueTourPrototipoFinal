package app;

import data.GestorAgencia;
import model.Cliente;
import model.Proveedor;
import model.Direccion;
import utils.ValidacionException;
import javax.swing.JOptionPane;

/**
 */
public class Main {

    public static void main(String[] args) {
        GestorAgencia gestor = new GestorAgencia();
        int opcion = 0;

        // Nombre del archivo
        String rutaArchivo = "datos.txt";

        while (opcion != 4) {
            String menu = "=== LLANQUIHUE TOUR - EXAMEN FINAL ===\n"
                    + "1. Cargar Datos desde Archivo Externo (.txt)\n"
                    + "2. Registrar Nueva Persona (Manual)\n"
                    + "3. Listar Toda la Colección (Polimorfismo)\n"
                    + "4. Salir del Sistema\n\n"
                    + "Seleccione una opción (1-4):";

            String entrada = JOptionPane.showInputDialog(null, menu, "EFT - Gestión Operativa", JOptionPane.QUESTION_MESSAGE);

            if (entrada == null) {
                break; // Si el usuario cierra la ventana
            }

            try {
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- INICIANDO LECTURA DE ARCHIVO EXTERNO ---");
                        gestor.cargarDatosDesdeArchivo(rutaArchivo);
                        JOptionPane.showMessageDialog(null, "Proceso de carga finalizado. Revisa la consola para ver alertas o errores de validación.", "Carga Completa", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 2:
                        // FORMULARIO MANUAL
                        String[] opcionesTipo = {"CLIENTE", "PROVEEDOR"};
                        int seleccionTipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de entidad a registrar:", "Tipo de Registro",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesTipo, opcionesTipo[0]);

                        if (seleccionTipo == -1) break;

                        String rut = JOptionPane.showInputDialog("Ingrese RUT:");
                        String nombre = JOptionPane.showInputDialog("Ingrese Nombre:");
                        String calle = JOptionPane.showInputDialog("Ingrese Calle y Número:");
                        String comuna = JOptionPane.showInputDialog("Ingrese Comuna:");

                        if (rut != null && nombre != null && calle != null && comuna != null) {
                            Direccion dir = new Direccion(calle, comuna);

                            try {
                                if (seleccionTipo == 0) {
                                    String tipoCli = JOptionPane.showInputDialog("Ingrese Tipo de Cliente (ej: Premium, Habitual):");
                                    if (tipoCli != null) {
                                        gestor.agregarEntidad(new Cliente(rut, nombre, dir, tipoCli));
                                        JOptionPane.showMessageDialog(null, "¡Cliente registrado con éxito!");
                                    }
                                } else {
                                    String tipoSer = JOptionPane.showInputDialog("Ingrese Tipo de Servicio (ej: Transporte, Alojamiento):");
                                    if (tipoSer != null) {
                                        gestor.agregarEntidad(new Proveedor(rut, nombre, dir, tipoSer));
                                        JOptionPane.showMessageDialog(null, "¡Proveedor registrado con éxito!");
                                    }
                                }
                            } catch (ValidacionException e) {
                                // Captura la excepción si el RUT manual tiene menos de 8 caracteres
                                JOptionPane.showMessageDialog(null, "Error de validación: " + e.getMessage(), "Error de Datos", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n=== DESPLIEGUE POLIMÓRFICO DE LA COLECCIÓN ===");
                        gestor.listarTodo();
                        JOptionPane.showMessageDialog(null, "El listado de entidades ha sido impreso en la consola de IntelliJ.", "Salida Exitosa", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "Cerrando el prototipo de Llanquihue Tour. ¡Mucho éxito!");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, introduzca un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}