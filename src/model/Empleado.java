package model;

import util.Validador; // Se mantiene la importación

// Definimos la clase publica empleado --> relación de herencia con la clase Persona
public class Empleado extends Persona {

    //Definimos atributos "privado" de la clase propia (encapsulamiento)
    private int codigo;
    private String cargo;
    private Direccion direccion;

    // Inicializamos el constructor: Recibe 'codigoTexto' como String para validarlo.
    public Empleado(String nombre, String rut, String codigoTexto, String cargo, Direccion direccion) {
        super(nombre, rut);    // Llama al constructor de Persona
        // Usamos el nuevo método para asignar y validar el código:
        this.setCodigo(codigoTexto);
        this.cargo = cargo;
        this.direccion = direccion;
    }

    // Métodos accesores

    // Getter queda igual: retorna un int
    public int getCodigo() { return codigo; }

    // Setter Modificado: Recibe un String y valida antes de asignar (usando try-catch de Validador)
    public void setCodigo(String codigoTexto) {
        if (Validador.esEnteroValido(codigoTexto)) {
            this.codigo = Integer.parseInt(codigoTexto);
        } else {
            // Acción si la validación falla (el texto no es un número)
            System.err.println("Advertencia: Código de empleado inválido. Asignando 0 por defecto.");
            this.codigo = 0; // Asignar un valor por defecto para evitar errores
        }
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    // El toString() queda igual
    @Override
    public String toString() {
        return super.toString() +
                "\nCódigo Empleado: " + codigo +
                ", Cargo: " + cargo +
                "\n" + direccion.toString();
    }
}