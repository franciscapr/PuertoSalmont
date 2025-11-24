package service;

import model.Direccion;
import model.Empleado;
import util.Validador;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorSalmontt {

    // Colección para almacenar objetos Empleado
    private ArrayList<Empleado> listaEmpleados;

    public GestorSalmontt() {
        this.listaEmpleados = new ArrayList<>();
    }

    public void cargarDatosDesdeArchivo(String rutaArchivo) {
        System.out.println("Cargando datos desde el archivo: " + rutaArchivo);
        int contadorCargados = 0;

        try {
            // Intenta abrir el archivo. Si no existe, salta al bloque catch.
            File archivo = new File(rutaArchivo);
            Scanner lector = new Scanner(archivo);

            // Recorrer cada línea del archivo
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();

                String[] datos = linea.split(";");

                if (datos.length == 7) {
                    String nombre = datos[0].trim();
                    String rut = datos[1].trim();
                    String codigoStr = datos[2].trim();
                    String cargo = datos[3].trim();
                    String calle = datos[4].trim();
                    String numeroStr = datos[5].trim();
                    String comuna = datos[6].trim();

                    if (Validador.esEnteroValido(codigoStr) && Validador.esEnteroValido(numeroStr)) {

                        Direccion dir = new Direccion(
                                calle,
                                Integer.parseInt(numeroStr),
                                comuna
                        );

                        Empleado emp = new Empleado(
                                nombre,
                                rut,
                                codigoStr,
                                cargo,
                                dir
                        );

                        listaEmpleados.add(emp);
                        contadorCargados++;
                    } else {
                        System.err.println("Error: Línea con datos numéricos inválidos (Código o Número): " + linea);
                    }
                } else {
                    System.err.println("Advertencia: Línea con formato incorrecto. Omitida: " + linea);
                }
            }
            lector.close();
            System.out.println("-> Carga de datos finalizada. " + contadorCargados + " registros de empleados cargados.");

        } catch (FileNotFoundException e) {
            System.err.println("\n--- ERROR FATAL DE CARGA ---");
            System.err.println("Archivo no encontrado: " + rutaArchivo);
            System.err.println("Asegúrese de que el archivo exista en la raíz del proyecto.");
        }
    }


    public void mostrarTodosLosEmpleados() {
        System.out.println("\n--- Lista Completa de Empleados Salmontt ---");
        if (listaEmpleados.isEmpty()) {
            System.out.println("La colección está vacía. Ejecute el método de carga primero.");
            return;
        }

        for (Empleado empleado : listaEmpleados) {
            System.out.println("------------------------------------------");
            System.out.println(empleado.toString());
        }
    }

    public void buscarPorCodigo(int codigo) {
        System.out.println("\n--- Buscando Empleado con Código: " + codigo + " ---");
        boolean encontrado = false;

        for (Empleado empleado : listaEmpleados) {
            if (empleado.getCodigo() == codigo) {
                System.out.println("¡Empleado encontrado!");
                System.out.println(empleado.toString());
                encontrado = true;
                break; // Detenemos la búsqueda
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún empleado con el código " + codigo + ".");
        }
    }
}