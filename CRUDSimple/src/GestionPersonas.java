public class GestionPersonas {
    private Persona[] personas = new Persona[20];
    private int contador = 0;

    public void alta() {
        if (contador >= personas.length) {
            System.out.println("Error: Arreglo lleno");
            return;
        }
        int id = Validaciones.leerEntero("Ingrese ID: ");
        if (id <= 0 || buscarIndice(id) != -1) {
            System.out.println("Error: ID invalido o repetido.");
            return;
        }
        String nombre = Validaciones.leerTexto("Ingrese Nombre: ");
        personas[contador] = new Persona(id, nombre);
        contador++;
        System.out.println("Registro exitoso");
    }

    public void buscar() {
        int id = Validaciones.leerEntero("ID a buscar: ");
        int i = buscarIndice(id);
        if (i != -1 && personas[i].isActive()) {
            System.out.println(personas[i].toString());
        } else {
            System.out.println("No encontrado o inactivo");
        }
    }

    public void bajaLogica() {
        int id = Validaciones.leerEntero("ID para baja: ");
        int i = buscarIndice(id);
        if (i != -1) {
            personas[i].setActive(false);
            System.out.println("Baja realizada");
        } else {
            System.out.println("ID no encontrado");
        }
    }

    public void listarActivas() {
        boolean hay = false;
        for (int i = 0; i < contador; i++) {
            if (personas[i].isActive()) {
                System.out.println(personas[i].toString());
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay personas activas");
        }
    }

    public void actualizar() {
        int id = Validaciones.leerEntero("ID para actualizar: ");
        int i = buscarIndice(id);
        if (i != -1 && personas[i].isActive()) {
            personas[i].setName(Validaciones.leerTexto("Nuevo nombre: "));
            System.out.println("Actualizado");
        } else {
            System.out.println("No disponible para actualizar");
        }
    }

    private int buscarIndice(int id) {
        for (int i = 0; i < contador; i++) {
            if (personas[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}