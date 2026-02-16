public class Alumno {
    private int id;
    private String name;
    private double promedio;
    private boolean isActive;

    public Alumno(int id, String name, double promedio) {
        this.id = id;
        this.name = name;
        this.promedio = promedio;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + name + " | Promedio: " + promedio;
    }
}