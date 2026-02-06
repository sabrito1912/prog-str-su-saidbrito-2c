import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calc = new ShippingCalculator();

        System.out.println("=== SISTEMA DE ENVÍOS ===");

        // 1. ENTRADA (Input) - Delegado a InputValidatorHelper
        int servicio = InputValidatorHelper.leerIntEnRango(sc, "Servicio (1.Std, 2.Exp)", 1, 2);
        double peso  = InputValidatorHelper.leerDoubleEnRango(sc, "Peso (kg)", 0.1, 50.0);
        int dist     = InputValidatorHelper.leerIntEnRango(sc, "Distancia (km)", 1, 2000);
        boolean rem  = InputValidatorHelper.leerBoolean(sc, "¿Zona remota?");

        // 2. PROCESO (Process) - Delegado a ShippingCalculator
        double sub   = calc.calcularSubtotal(peso, dist, servicio, rem);
        double iva   = calc.calcularIVA(sub);
        double total = calc.calcularTotal(sub, iva);

        // 3. SALIDA (Output) - Delegado a ImpresoraTicket
        Ticket.imprimir(servicio, peso, dist, rem, sub, iva, total);

        sc.close();
    }
}