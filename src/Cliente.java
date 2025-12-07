public class Cliente {
    private String nombre;
    private int prioridad;
    private String ubicacion;
    private ListaProductos carrito;

    public Cliente(String nombre, int prioridad, String ubicacion) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.ubicacion = ubicacion;
        this.carrito = new ListaProductos();
    }

    public String getNombre() {
        return nombre;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public ListaProductos getCarrito() {
        return carrito;
    }
}