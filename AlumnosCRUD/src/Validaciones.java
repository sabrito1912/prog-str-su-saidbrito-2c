import java.util.Scanner;

public class Validaciones {
    private static Scanner sc = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido");
            }
        }
    }

    public static double leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Promedio invalido");
            }
        }
    }

    public static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) return texto;
            System.out.println("Error: Campo vacio");
        }
    }
}