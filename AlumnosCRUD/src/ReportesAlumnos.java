public class ReportesAlumnos {
    private Alumno[] alumnos = new Alumno[25];
    private int contador = 0;

    public void alta() {
        if (contador >= alumnos.length) {
            System.out.println("Error: Limite de 25 alumnos alcanzado.");
            return;
        }
        int id = Validaciones.leerEntero("Ingrese ID: ");
        if (id <= 0 || buscarIndice(id) != -1) {
            System.out.println("Error: ID invalido o repetido");
            return;
        }
        String nombre = Validaciones.leerTexto("Ingresa un nombre: ");
        double promedio = Validaciones.leerDecimal("Ingresa el promedio: ");

        alumnos[contador] = new Alumno(id, nombre, promedio);
        contador++;
        System.out.println("Alumno registrado");
    }

    public void buscar() {
        int id = Validaciones.leerEntero("ID a buscar: ");
        int i = buscarIndice(id);
        if (i != -1 && alumnos[i].isActive()) {
            System.out.println(alumnos[i].toString());
        } else {
            System.out.println("Alumno no encontrado o inactivo");
        }
    }

    public void actualizarPromedio() {
        int id = Validaciones.leerEntero("ID para actualizar promedio: ");
        int i = buscarIndice(id);
        if (i != -1 && alumnos[i].isActive()) {
            double nuevoProm = Validaciones.leerDecimal("Nuevo promedio: ");
            alumnos[i].setPromedio(nuevoProm);
            System.out.println("Promedio actualizado");
        } else {
            System.out.println("No se puede actualizar");
        }
    }

    public void bajaLogica() {
        int id = Validaciones.leerEntero("ID para baja: ");
        int i = buscarIndice(id);
        if (i != -1) {
            alumnos[i].setActive(false);
            System.out.println("Baja realizada");
        } else {
            System.out.println("ID no encontrado");
        }
    }

    public void listarActivos() {
        boolean hayActivos = false;
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].isActive()) {
                System.out.println(alumnos[i].toString());
                hayActivos = true;
            }
        }
        if (!hayActivos) {
            System.out.println("No hay alumnos activos");
        }
    }

    public void generarReportes() {
        int activos = 0;
        double sumaPromedios = 0;
        int mayoresOcho = 0;
        Alumno mejor = null;
        Alumno peor = null;

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].isActive()) {
                double p = alumnos[i].getPromedio();
                sumaPromedios += p;
                activos++;

                if (p >= 8.0) {
                    mayoresOcho++;
                }

                if (mejor == null || p > mejor.getPromedio()) {
                    mejor = alumnos[i];
                }

                if (peor == null || p < peor.getPromedio()) {
                    peor = alumnos[i];
                }
            }
        }
        if (activos > 0) {
            System.out.println("    Reportes de Alumnos    ");
            System.out.println("Promedio general: " + (sumaPromedios / activos));
            System.out.println("Alumno con mayor promedio: " + mejor.toString());
            System.out.println("Alumno con menor promedio: " + peor.toString());
            System.out.println("Alumnos con promedio >= 8.0: " + mayoresOcho);
        } else {
            System.out.println("No hay alumnos activos para generar reportes");
        }
    }
    private int buscarIndice(int id) {
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}