import java.util.Scanner;

public class ActividadSwitchCalculadora {

    public static void mostrarMenu() {
        System.out.println("Selecciona una opción del menu para realizar (Teclea únicamente el número):");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1, num2, resultado = 0;

        mostrarMenu();
        int opc = sc.nextInt();

        if (opc < 1 || opc > 4) {
            System.out.println("Error: '" + opc + "' no es una opción válida.");
        } else {
            System.out.print("Ingresa el primer número: ");
            num1 = sc.nextDouble();
            System.out.print("Ingresa el segundo número: ");
            num2 = sc.nextDouble();

            switch (opc) {
                case 1:
                    resultado = sumar(num1, num2);
                    break;
                case 2:
                    resultado = restar(num1, num2);
                    break;
                case 3:
                    resultado = multiplicar(num1, num2);
                    break;
                case 4:
                    if (num2 != 0) {
                        resultado = dividir(num1, num2);
                    } else {
                        System.out.println("Error: No se puede dividir entre cero.");
                        return;
                    }
                    break;
            }
            System.out.println("El resultado de la operación es: " + resultado);
        }

        sc.close();
    }
}
