public class Ticket {
    public static void imprimir(int servicio, double peso, int dist, boolean remota, double sub, double iva, double total) {

        System.out.println("--------------------------------");
        System.out.println("      TICKET DE ENVÍO");
        System.out.println("--------------------------------");

        // Lógica de presentación: Convertir números a texto legible
        String nombreServicio;
        if (servicio == 1) {
            nombreServicio = "Estándar";
        } else {
            nombreServicio = "Express";
        }
        String textoRemota;
        if (remota) {
            textoRemota = "SÍ";
        } else {
            textoRemota = "NO";
        }
        System.out.println("Servicio:     " + nombreServicio);
        System.out.println("Peso:         " + peso + " kg");
        System.out.println("Distancia:    " + dist + " km");
        System.out.println("Zona Remota:  " + textoRemota);

        System.out.println("--------------------------------");
        System.out.println("Subtotal:     $"+ sub);
        System.out.println("IVA (16%):    $"+ iva);
        System.out.println("--------------------------------");
        System.out.println("TOTAL:        $"+ total);
        System.out.println("--------------------------------");
    }
}

