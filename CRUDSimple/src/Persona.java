public class Persona {
    private int id;
    private String name;
    private boolean isActive;

    public Persona() {
    }

    public Persona(int id, String name) {
        this.id = id;
        this.name = name;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + name + " | Activo: " + isActive;
    }
}
