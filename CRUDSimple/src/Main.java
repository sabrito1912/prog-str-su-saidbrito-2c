public class Main {
    public static void main(String[] args) {
        GestionPersonas gestor = new GestionPersonas();
        int op = -1;

        while (op != 0) {
            System.out.println("1 Alta");
            System.out.println("2 Buscar ID");
            System.out.println("3 Baja");
            System.out.println("4 Listas");
            System.out.println("5 Actualizar Nombre");
            System.out.println("0 Salir");
            op = Validaciones.leerEntero("Opcion: ");

            switch (op) {
                case 1:
                    gestor.alta();
                    break;
                case 2:
                    gestor.buscar();
                    break;
                case 3:
                    gestor.bajaLogica();
                    break;
                case 4:
                    gestor.listarActivas();
                    break;
                case 5:
                    gestor.actualizar();
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