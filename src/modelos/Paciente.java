package modelos;

public class Paciente {
    private String id;
    private String nombre;
    private int edad;

    public Paciente(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
}
