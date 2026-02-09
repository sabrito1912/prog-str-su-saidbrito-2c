import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService servicio = new GradeService();

        String nombre = InputValidator.leerTextoNoVacio(sc, "Nombre del alumno:  ");

        double p1 = InputValidator.leerDoubleEnRango(sc, "Parcial 1  ", 0, 100);
        double p2 = InputValidator.leerDoubleEnRango(sc, "Parcial 2  ", 0, 100);
        double p3 = InputValidator.leerDoubleEnRango(sc, "Parcial 3  " , 0, 100);

        int asistencia = InputValidator.leerIntEnRango(sc, "Asistencia total  ", 0, 100);

        boolean entregaProy = InputValidator.leerBoolean(sc, "Entrego el proyecto final?  ");

        double promedio = servicio.calcularPromedio(p1, p2, p3);
        double califFinal = servicio.calcularFinal(promedio, asistencia);

        String estado = servicio.determinarEstado(califFinal, asistencia, entregaProy);

        ReporteFinal.imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregaProy, califFinal, estado);
        sc.close();
    }
}
