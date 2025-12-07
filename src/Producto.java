import java.util.ArrayList;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private String fechaVencimiento;
    private int cantidad;
    private ArrayList<String> listaImagenes;

    private Producto siguiente;
    private Producto izquierdo;
    private Producto derecho;

    public Producto(String nombre, double precio, String categoria, String fechaVencimiento, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.listaImagenes = new ArrayList<>();
        this.siguiente = null;
        this.izquierdo = null;
        this.derecho = null;
    }

    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    public int getCantidad() {
        return cantidad;
    }
    public ArrayList<String> getListaImagenes() {
        return listaImagenes;
    }
    public Producto getSiguiente() {
        return siguiente;
    }
    public Producto getIzquierdo() {
        return izquierdo;
    }
    public Producto getDerecho() {
        return derecho;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setSiguiente(Producto siguiente) {
        this.siguiente = siguiente;
    }
    public void setIzquierdo(Producto izquierdo) {
        this.izquierdo = izquierdo;
    }
    public void setDerecho(Producto derecho) {
        this.derecho = derecho;
    }

    public int compararPorNombre(String otroNombre) {
        return this.nombre.compareToIgnoreCase(otroNombre);
    }

    @Override
    public String toString() {
        return "Producto{nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", cantidad=" + cantidad +
                ", imágenes=" + listaImagenes.size() + "}";
    }
}