import java.util.Scanner;
public class InputValidatorHelper {
    public static int leerIntEnRango(Scanner sc, String mensaje, int min, int max) {
        int valor = 0;
        boolean datoValido = false;

        do {
            System.out.print(mensaje + ": "); // Mostramos el mensaje

            if (sc.hasNextInt()) {
                valor = sc.nextInt();

                if (valor >= min && valor <= max) {
                    datoValido = true;
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max);
                }
            } else {
                System.out.println("Error: Debes ingresar un número entero válido.");
                sc.next();
            }
        } while (!datoValido);

        return valor;
    }

    //  Leer Decimales (para el peso)
    public static double leerDoubleEnRango(Scanner sc, String mensaje, double min, double max) {
        double valor = 0.0;
        boolean datoValido = false;

        do {
            System.out.print(mensaje + ": ");

            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();

                if (valor >= min && valor <= max) {
                    datoValido = true;
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max);
                }
            } else {
                System.out.println("Error: Ingresa un número decimal (ej. 10.5).");
                sc.next();
            }
        } while (!datoValido);

        return valor;
    }

    // Leer Booleanos (para zona remota)
    public static boolean leerBoolean(Scanner sc, String mensaje) {
        String entrada;
        boolean resultado = false;
        boolean datoValido = false;

        do {
            System.out.print(mensaje + " (Escribe 'si' o 'no'): ");
            entrada = sc.next().toLowerCase();

            // Validamos las opciones afirmativas alternativas
            if (entrada.equals("true") || entrada.equals("si") || entrada.equals("verdadero") || entrada.equals("yes") ) {
                resultado = true;
                datoValido = true;

                // Validamos las opciones negativas alternativas
            } else if (entrada.equals("false") || entrada.equals("no") || entrada.equals("falso")) {
                resultado = false;
                datoValido = true;

            } else {
                System.out.println("Error:Intenta con 'si' o 'no'.");
            }

        } while (!datoValido);

        return resultado;
    }
}
