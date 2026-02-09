public class ReporteFinal {

    public static void imprimirReporte(String nom, double p1, double p2, double p3, double prom, int asis, boolean proy, double fin, String est) {

        System.out.println("Reporte Final: " + nom);
        System.out.println("Parciales:  "+ p1 +"  " + p2 + "  "  + p3 + "  ");
        System.out.println("Promedio:    " + prom);

        System.out.println("Asistencia:     " + asis + "%");

        String mensaje;
        if (proy == true) {
            mensaje = "Entregado";
        } else {
            mensaje = "No Entregado";
        }
        System.out.println("Proyecto: " + mensaje);
        System.out.println("Calificación Final:   "+ fin + "  "+est);
    }

}
