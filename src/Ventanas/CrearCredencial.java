package Ventanas;
import java.util.Random;

public class CrearCredencial {
    private static final String numeros = "1234567890";
    private static final int sizeUsuario = 6;
    private static final int sizeContraseña = 8;

    public static String generarUsuario() {
        StringBuilder usuarioBuilder = new StringBuilder();
        Random random = new Random();

        // Generar un usuario compuesto solo por números
        for (int i = 0; i < sizeUsuario; i++) {
            int index = random.nextInt(numeros.length());
            char caracter = numeros.charAt(index);
            usuarioBuilder.append(caracter);
        }

        // Retornar el usuario generado
        return usuarioBuilder.toString();
    }

    public static String generarContrasena() {
        StringBuilder contraBuilder = new StringBuilder();
        Random random = new Random();

        // Generar una contraseña aleatoria
        for (int i = 0; i < sizeContraseña; i++) {
            int index = random.nextInt(numeros.length());
            char caracter = numeros.charAt(index);
            contraBuilder.append(caracter);
        }
        // Retornar la contraseña generada
        return contraBuilder.toString();
    }
}
