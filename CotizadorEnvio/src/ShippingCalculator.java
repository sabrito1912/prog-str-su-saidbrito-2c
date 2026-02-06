public class ShippingCalculator {

    // 1. Constantes de dinero (Precios e Impuestos)
    private static final double PRECIO_STD = 50.0;
    private static final double PRECIO_EXP = 90.0;
    private static final double TASA_IVA = 0.16;       // 16%
    private static final double TASA_REMOTA = 0.10;    // 10%
    private static final double PRECIO_POR_KG = 12.0;

    // 2. Constantes de reglas (Distancias)
    private static final int LIMITE_CORTA = 50;
    private static final int LIMITE_MEDIA = 200;

    public double calcularSubtotal(double peso, int distancia, int tipo, boolean esRemota) {
        double costoAcumulado = 0.0;

        // A) Costo Base
        if (tipo == 1) {
            costoAcumulado += PRECIO_STD;
        } else {
            costoAcumulado += PRECIO_EXP;
        }

        // B) Costo por Peso
        costoAcumulado += (peso * PRECIO_POR_KG);

        // C) Costo por Distancia
        if (distancia <= LIMITE_CORTA) {
            costoAcumulado += 20;
        } else if (distancia <= LIMITE_MEDIA) {
            costoAcumulado += 60;
        } else {
            costoAcumulado += 120;
        }

        // D) Zona Remota
        if (esRemota) {
            costoAcumulado += (costoAcumulado * TASA_REMOTA);
        }

        return costoAcumulado;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * TASA_IVA;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}