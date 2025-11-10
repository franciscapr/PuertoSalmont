package app;

// Importamos los modelos (clases)
import model.Direccion;
import model.Empleado;
import model.Persona;

// Clase publica Main
public class Main {

    public static void main(String[] args) {

        // Creamos nuestras intancias (objetos)
        Direccion dir1 = new Direccion("Calle del Salmón", 1500, "Puerto Montt");
        Direccion dir2 = new Direccion("Avenida de los Lagos", 45, "Osorno");

        Empleado emp1 = new Empleado("Juan Carlos Bodoque", "18.123.456-K", 101, "Jefe de Producción", dir1);
        Empleado emp2 = new Empleado("Pata Patana", "19.876.543-2", 205, "Encargada de Logística", dir2);

        Persona per3 = new Persona("Tulio Triviño", "20.555.777-1");

        // Imprimimos en consola
        System.out.println("=========================================");
        System.out.println("  Personal de PuertoSalmontt   ");
        System.out.println("=========================================");

        System.out.println("\n--- Empleado del Mes ---");
        System.out.println(emp1.toString());    // herencia y composicion (emp1 extiende de persona y tambien contiene direccion)

        // Utilizamos poliformismo y herencia
        System.out.println("\n--- Empleado del año ---");
        System.out.println(emp2.toString());   // sobreescribe

        // Utilizamos herencia --> clase base Persona
        System.out.println("\n--- Jefe de Todos los Tiempo ---");
        System.out.println(per3.toString());

        // Utilizamos getters y setters (encapsulamiento)
        System.out.println("\n--- Cambios de Residencia ---");
        emp1.getDireccion().setComuna("Ancud");
        System.out.println(emp1.getNombre() + " se ha mudado. Su nueva comuna de residencia actual es: " + emp1.getDireccion().getComuna());
    }
}
