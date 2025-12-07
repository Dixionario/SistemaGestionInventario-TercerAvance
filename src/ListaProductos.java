public class ListaProductos {
    private Producto cabeza;

    public ListaProductos() {
        this.cabeza = null;
    }

    public Producto getCabeza() {
        return cabeza;
    }

    public void insertarAlInicio(Producto p) {
        p.setSiguiente(cabeza);
        cabeza = p;
    }

    public void insertarAlFinal(Producto p) {
        p.setSiguiente(null);
        if (cabeza == null) {
            cabeza = p;
        } else {
            Producto actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(p);
        }
    }

    public void agregarImagenAProducto(String nombre, String ruta) {
        Producto actual = cabeza;
        while (actual != null) {
            if (actual.getNombre().equalsIgnoreCase(nombre)) {
                actual.getListaImagenes().add(ruta);
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    public double generarReporte(boolean imprimir) {
        if (cabeza == null) {
            if (imprimir) System.out.println("Carrito vacío.");
            return 0.0;
        }

        double total = 0.0;
        Producto actual = cabeza;

        if (imprimir) {
            System.out.println("=== FACTURA ===");
        }

        while (actual != null) {
            double subtotal = actual.getPrecio() * actual.getCantidad();
            total += subtotal;
            if (imprimir) {
                System.out.printf("- %s (%d x $%.2f) = $%.2f%n",
                        actual.getNombre(), actual.getCantidad(), actual.getPrecio(), subtotal);
            }
            actual = actual.getSiguiente();
        }

        if (imprimir) {
            System.out.printf("TOTAL: $%.2f%n", total);
            System.out.println("================");
        }
        return total;
    }
}