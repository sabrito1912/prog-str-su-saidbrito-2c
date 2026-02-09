public class GradeService {

    public double calcularPromedio(double p1, double p2, double p3) {
        return (p1 + p2 + p3) / 3.0;
    }

    public double calcularFinal(double promedio, int asistencia) {
        return (promedio * 0.70) + (asistencia * 0.30);
    }

    public String determinarEstado(double califFinal, int asistencia, boolean entregaProyecto) {

        if (asistencia < 80) {
            return "Reprobado por asistencia";
        }
        else if (entregaProyecto == false) {
            return "Reprobado por proyecto";
        }
        else {
            if (califFinal >= 70.0) {
                return "Aprovado";
            } else {
                return "Reprobado por calificación";
            }
        }
    }
}