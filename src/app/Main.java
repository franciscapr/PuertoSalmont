package app;

import service.GestorSalmontt; // Importamos la nueva clase de servicio

// Clase publica Main
public class Main {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("  Sistema de Gestión Salmontt - INICIADO ");
        System.out.println("=========================================");

        GestorSalmontt sistema = new GestorSalmontt();

        // Llamamos al método que carga los datos
        sistema.cargarDatosDesdeArchivo("empleado.txt"); // Ruta de ejemplo

        sistema.mostrarTodosLosEmpleados();

        System.out.println("\n--- Búsqueda de Empleado 101 ---");
        sistema.buscarPorCodigo(101);

        System.out.println("=========================================");
        System.out.println("  Sistema de Gestión Salmontt - FINALIZADO ");
        System.out.println("=========================================");
    }
}