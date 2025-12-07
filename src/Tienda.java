import java.util.List;
import java.util.Scanner;

public class Tienda {
    private String ubicacion;
    private ArbolProductos inventario;
    private ColaClientes cola;
    private Grafo grafo;

    public Tienda(String ubicacion, int capacidadCola) {
        this.ubicacion = ubicacion;
        this.inventario = new ArbolProductos();
        this.cola = new ColaClientes(capacidadCola);
        this.grafo = new Grafo();
        this.grafo.agregarVertice(ubicacion);
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
        grafo.agregarVertice(ubicacion);
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public ArbolProductos getInventario() {
        return inventario;
    }

    public ColaClientes getCola() {
        return cola;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void añadirProducto(Producto p) {
        inventario.insertar(p);
    }

    public void registrarCliente(Scanner sc) {
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("Nombre inválido.");
            return;
        }

        System.out.print("Prioridad, 1.básico, 2.afiliado, 3.premium: ");
        int prioridad;
        try {
            prioridad = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            prioridad = 1;
        }
        if (prioridad < 1) prioridad = 1;
        if (prioridad > 3) prioridad = 3;

        System.out.print("Ubicación del cliente: ");
        String ubicacionCliente = sc.nextLine().trim();
        if (ubicacionCliente.isEmpty()) {
            System.out.println("Ubicación requerida.");
            return;
        }

        Cliente cliente = new Cliente(nombre, prioridad, ubicacionCliente);
        grafo.agregarVertice(ubicacionCliente);

        System.out.println("Armando carrito para " + nombre);
        inventario.mostrarInventario();

        while (true) {
            System.out.print("Buscar producto o 'fin' para terminar: ");
            String busqueda = sc.nextLine().trim();
            if (busqueda.equalsIgnoreCase("fin")) break;

            Producto prod = inventario.buscar(busqueda);
            if (prod == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            System.out.print("Cantidad deseada (máx. " + prod.getCantidad() + "): ");
            int cant;
            try {
                cant = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Cantidad inválida.");
                continue;
            }

            if (cant <= 0) {
                System.out.println("Cantidad debe ser > 0.");
                continue;
            }
            if (cant > prod.getCantidad()) {
                System.out.print("Solo hay " + prod.getCantidad() + ". ¿Usar esa cantidad? (s/n): ");
                if (!sc.nextLine().trim().equalsIgnoreCase("s")) {
                    continue;
                }
                cant = prod.getCantidad();
            }

            Producto item = new Producto(
                    prod.getNombre(), prod.getPrecio(),
                    prod.getCategoria(), prod.getFechaVencimiento(), cant
            );
            cliente.getCarrito().insertarAlInicio(item);
            System.out.println("Añadido: " + cant + "x " + prod.getNombre());
        }

        cola.encolar(cliente);
        System.out.println("Cliente '" + nombre + "' registrado y encolado.");
    }

    public void atenderCliente() {
        Cliente c = cola.atender();
        if (c == null) {
            System.out.println("No hay clientes en la cola.");
            return;
        }

        String ubicCliente = c.getUbicacion();
        if (!grafo.contieneVertice(ubicCliente)) {
            System.out.println("Error: ubicación del cliente '" + c.getNombre() + "' no registrada en el grafo.");
            return;
        }

        List<String> camino = grafo.dijkstra(ubicCliente, ubicacion);
        if (camino == null) {
            System.out.println("Cliente '" + c.getNombre() + "' no puede ser atendido: su ubicación está desconectada de la tienda.");
            return;
        }

        System.out.println("\nAtendiendo a: " + c.getNombre() + " (Prioridad: " + c.getPrioridad() + ")");
        c.getCarrito().generarReporte(true);

        System.out.println("Ruta de entrega:");
        System.out.print("  ");
        for (int i = 0; i < camino.size(); i++) {
            if (i > 0) System.out.print(" → ");
            System.out.print(camino.get(i));
        }
        double distancia = grafo.distanciaMinima(ubicCliente, ubicacion);
        System.out.printf("\nDistancia total: %.2f km\n", distancia);
        System.out.println("Atención completada.");
    }

    public void agregarVerticeGrafo(String ubicacion) {
        grafo.agregarVertice(ubicacion);
        System.out.println("Vértice '" + ubicacion + "' añadido al grafo.");
    }

    public void agregarAristaGrafo(String origen, String destino, double peso) {
        if (!grafo.contieneVertice(origen)) {
            System.out.println("Origen '" + origen + "' no existe. Se agregará.");
            grafo.agregarVertice(origen);
        }
        if (!grafo.contieneVertice(destino)) {
            System.out.println("Destino '" + destino + "' no existe. Se agregará.");
            grafo.agregarVertice(destino);
        }
        grafo.agregarArista(origen, destino, peso);
        System.out.println("Arista añadida: " + origen + " ↔ " + destino + " (distancia: " + peso + ")");
    }
}