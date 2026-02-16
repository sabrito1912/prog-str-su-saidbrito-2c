public class Main {
    public static void main(String[] args) {
        ReportesAlumnos gestor = new ReportesAlumnos();
        int op = -1;

        while (op != 0) {
            System.out.println("-------------------------------------");
            System.out.println(" Selecciona una opcion del menu");
            System.out.println("1 Alta alumno");
            System.out.println("2 Buscar por ID");
            System.out.println("3 Actualizar promedio");
            System.out.println("4 Baja");
            System.out.println("5 Listar alumnos activos");
            System.out.println("6 Reporte de alumnos");
            System.out.println("0. Salir");
            System.out.println("-------------------------------------");
            op = Validaciones.leerEntero("Opcion: ");

            switch (op) {
                case 1:
                    gestor.alta();
                    break;
                case 2:
                    gestor.buscar();
                    break;
                case 3:
                    gestor.actualizarPromedio();
                    break;
                case 4:
                    gestor.bajaLogica();
                    break;
                case 5:
                    gestor.listarActivos();
                    break;
                case 6:
                    gestor.generarReportes();
                    break;
                case 0:
                    System.out.println("Fin");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}