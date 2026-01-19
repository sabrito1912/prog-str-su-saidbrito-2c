import java.util.Scanner;

public class Main {
    /**
     * Muestra las opciones del menú principal en la consola.
     * No recibe parámetros ni devuelve valores.
     */
    public static void mostrarMenu() {
        System.out.println("Selecciona una opción del menu para realizar (Teclea únicamente el número):");
        System.out.println("1. Calcular IMC");
        System.out.println("2. Calcular Área de un rectangulo");
        System.out.println("3. Convertir °C a °F (Celsius a Fahrenheit");
        System.out.println("4. Calcular Área de un Circulo");
        System.out.println("5. Salir");
    }

    /**
     * Calcula el IMC del usuario basado en su peso y altura.
     * @param pesoKg Peso del usuario en Kilogramos (ej. 70.0).
     * @param alturaM Altura del usuario en Metros (ej. 1.75).
     * @return El índice de masa corporal (IMC) resultante.
     */
    public static double calcularIMC(double pesoKg, double alturaM) {
        return pesoKg / (alturaM * alturaM);
    }

    /**
     * Calcula el área de un rectángulo multiplicando base por altura.
     * @param base La longitud de la base del rectángulo.
     * @param altura La longitud de la altura del rectángulo.
     * @return El área total calculada (unidades cuadradas).
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return (base * altura);
    }

    /**
     * Convierte una temperatura de grados Celsius a Fahrenheit.
     * @param celsius La temperatura en grados Celsius.
     * @return La temperatura equivalente en grados Fahrenheit.
     */
    public static double convertirCF(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Calcula el área de un círculo usando su radio.
     * @param radio El radio del círculo.
     * @return El área calculada usando PI.
     */
    public static double calcularAreaCirculo(double radio) {
        return 3.1416 * (radio * radio);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do {
            mostrarMenu();
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingresa peso en Kg (73.5):");
                    double pesoKg = sc.nextDouble();
                    System.out.println("Ingresa altura en metros (1.70) :");
                    double alturaM = sc.nextDouble();

                    double imc = calcularIMC(pesoKg, alturaM);
                    System.out.println("Tu IMC es: " + imc);
                    break;
                case 2:
                    System.out.println("Ingresa la base del rectangulo en cm:");
                    double base = sc.nextDouble();
                    System.out.println("Ingresa la altura del rectangulo en cm:");
                    double altura = sc.nextDouble();

                    double area = calcularAreaRectangulo(base, altura);
                    System.out.println("El area del rectangulo es: " + area);
                    break;
                case 3:
                    System.out.println("Ingresa los grados Celsius:");
                    double celsius = sc.nextDouble();
                    double fahren = convertirCF(celsius);
                    System.out.println("La conversión de grados es: " + fahren + "°F");
                    break;
                case 4:
                    System.out.println("Ingresa el radio en cm:");
                    double radio = sc.nextDouble();
                    double areaC = calcularAreaCirculo(radio);
                    System.out.println("El area del cirulo es: " + areaC);
                    break;
                case 5:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Opción no valida. Intenta de nuevo");
                    break;
            }
        }while (opc != 5) ;
    }
}