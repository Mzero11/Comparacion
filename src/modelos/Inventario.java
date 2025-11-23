package modelos;

public class Inventario {
    private String id;
    private String producto;
    private int cantidad;

    public Inventario(String id, String producto, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public String getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
}
