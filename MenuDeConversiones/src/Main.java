import java.util.Scanner;

public class Main {
    static final double Factor_Millas_KM = 0.621371;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc;
        int CelAFah = 0, FahACel = 0, kmAMi = 0, miAKm = 0;
        int totalConversiones = 0;
        int totalNoNumerico = 0;
        int totalFueraRango = 0;

        do {
            mostrarMenu();

            // Validacion de entrada del menú
            if (!sc.hasNextInt()) {
                System.out.println("Coloque un dato numerico");
                sc.next();
                totalNoNumerico++;
                continue;
            }

            opc = sc.nextInt();

            if (opc < 1 || opc > 5) {
                System.out.println("Ingresa un numero del 1 al 5");
                totalFueraRango++;
                continue;
            }

            if (opc == 5) {
                break;
            }

            System.out.println("Ingresa el valor a convertir");

            // Validación del valor a convertir
            if (!sc.hasNextDouble()) {
                System.out.println("Dato no numerico");
                sc.next();
                continue;
            }

            double valor = sc.nextDouble();
            double resultado = 0;

            // Integración de metodos
            switch (opc) {
                case 1:
                    resultado = convertirCelsiusAFahren(valor);
                    System.out.println(valor + " °C = " + resultado + " °F");
                    CelAFah++;
                    break;

                case 2:
                    resultado = convertirFahrenACelsius(valor);
                    System.out.println(valor + " °F = " + resultado + " °C");
                    FahACel++;
                    break;

                case 3:
                    resultado = convertirKmAMillas(valor);
                    System.out.println(valor + " Km = " + resultado + " Millas");
                    kmAMi++;
                    break;

                case 4:
                    resultado = convertirMillasAKM(valor);
                    System.out.println(valor + " Millas = " + resultado + " Km");
                    miAKm++;
                    break;
            }

            totalConversiones++;

        } while (true);

        System.out.println("Total de conversiones: " + totalConversiones);
        System.out.println("Total de intentos fuera del rango: " + totalFueraRango);
        System.out.println("Total de valores no numericos " + totalNoNumerico);
        System.out.println("°C a °F: " + CelAFah);
        System.out.println("°F a °C: " + FahACel);
        System.out.println("Km a Millas: " + kmAMi);
        System.out.println("Millas a Km: " +  miAKm);
        System.out.println("Programa terminado");
    }

    public static void mostrarMenu() {
        System.out.println("Bienvenido selecciona una opción del menu para realizar (Teclea únicamente el número");
        System.out.println("1) °C a °F");
        System.out.println("2) °F a °C");
        System.out.println("3) Km a Millas");
        System.out.println("4) Millas a Km");
        System.out.println("5) Salir");
    }

    public static double convertirCelsiusAFahren(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static double convertirFahrenACelsius(double fahren){
        return (fahren - 32) *5.0 / 9.0;
    }

    public static double convertirKmAMillas(double KM){
        return (KM *Factor_Millas_KM);
    }

    public static double convertirMillasAKM(double millas){
        return (millas/Factor_Millas_KM);
    }

}