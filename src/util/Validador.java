package util;

public class Validador {

    public static boolean esEnteroValido(String texto) {
        // Validamos si el texto esta nulo o vacio
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }

        // Utilizamos el try-catch
        try {
            Integer.parseInt(texto.trim());
            return true;
        } catch (NumberFormatException e) {
            // El catch captura el error si la conversión falla
            System.err.println("Error de validación: El valor ingresado '" + texto + "' no es un número entero válido.");
            return false;
        }
    }
}