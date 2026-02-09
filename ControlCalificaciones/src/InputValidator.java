import java.util.Scanner;

public class InputValidator {

    public static String leerTextoNoVacio(Scanner sc, String mensaje) {
        String texto = "";
        boolean valido = false;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Error: No puedes dejar el nombre vacío.");
            }
            // Aqui no supe como validar que no fuera número el nombre y le pregunté a gemini ;( pq me daba algo que el nombre fuera un número
            else if (texto.chars().anyMatch(Character::isDigit)) {
                System.out.println("Error: El nombre no puede tener números.");
            }
            else {
                valido = true;
            }
        } while (!valido);
        return texto;
    }

    public static double leerDoubleEnRango(Scanner sc, String mensaje, double min, double max) {
        double valor = 0.0;
        boolean datoValido = false;
        do {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= min && valor <= max) {
                    datoValido = true;
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max);
                }
            } else {
                System.out.println("Error: Ingresa un número valido.");
                sc.next();
            }
        } while (!datoValido);
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String mensaje, int min, int max) {
        int valor = 0;
        boolean datoValido = false;
        do {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    datoValido = true;
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max);
                }
            } else {
                System.out.println("Error: Ingresa un número entero.");
                sc.next();
            }
        } while (!datoValido);
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String mensaje) {
        String entrada;
        boolean resultado = false;
        boolean datoValido = false;

        do {
            System.out.print(mensaje + " (si/no): ");
            entrada = sc.next().toLowerCase();
            if (entrada.equals("si") || entrada.equals("s") || entrada.equals("true")) {
                resultado = true;
                datoValido = true;
            } else if (entrada.equals("no") || entrada.equals("n") || entrada.equals("false")) {
                resultado = false;
                datoValido = true;
            } else {
                System.out.println("Error: Escribe 'si' o 'no'.");
            }
        } while (!datoValido);
        sc.nextLine();

        return resultado;
    }
}