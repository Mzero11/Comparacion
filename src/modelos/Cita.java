package modelos;

public class Cita {
    private String id;
    private String nombre;
    private String fecha;
    private String motivo;

    public Cita(String id, String nombre, String fecha, String motivo) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.motivo = motivo;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getFecha() { return fecha; }
    public String getMotivo() { return motivo; }
}
