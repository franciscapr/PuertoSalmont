package model;

// Definimos la clase publica empleado --> relación de herencia con la clase Persona
public class Empleado extends Persona {

    //Definimos atributos "privado" de la clase propia (encapsulamiento)
    private int codigo;
    private String cargo;
    private Direccion direccion;

    // Inicializamos el constructor para la creación de los objetos
    public Empleado(String nombre, String rut, int codigo, String cargo, Direccion direccion) {
        super(nombre, rut);    // super se utiliza en el constructor por herencia de la clase padre (Persona)
        this.codigo = codigo;
        this.cargo = cargo;
        this.direccion = direccion;
    }

    // Métodos accesores
    // Los getters nos permiten leer
    // Los setters nos permiten modificar
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    // utilizamos el toString() para representar nuestro objeto de forma legible
    @Override   // Override es para sobreescribir (en este caso sobreescribe el método de la clase Persona
    public String toString() {
        return super.toString() +
                "\nCódigo Empleado: " + codigo +
                ", Cargo: " + cargo +
                "\n" + direccion.toString();
    }
}