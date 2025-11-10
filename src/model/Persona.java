package model;

// Creamos la clase Persona
public class Persona {
    private String nombre;
    private String rut;

    // Inicializamos el constructor
    public Persona(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    // Sobreescritura
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", RUT: " + rut;
    }
}