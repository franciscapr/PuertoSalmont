package model;

// Creamos una clase publica Direccion
public class Direccion {
    // Le asignamos sus atributos privados
    private String calle;
    private int numero;
    private String comuna;

    // Inicializamos el constructor
    public Direccion(String calle, int numero, String comuna) {
        this.calle = calle;
        this.numero = numero;
        this.comuna = comuna;
    }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getComuna() { return comuna; }
    public void setComuna(String comuna) { this.comuna = comuna; }

    @Override
    public String toString() {
        return "Direccion: " + calle + " #" + numero + ", Comuna: " + comuna;
    }
}