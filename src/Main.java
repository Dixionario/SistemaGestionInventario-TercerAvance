import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ubicación de la tienda: ");
        String ubiTienda = sc.nextLine().trim();
        if (ubiTienda.isEmpty()) ubiTienda = "Centro";
        Tienda tienda = new Tienda(ubiTienda, 10);

        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE VENTAS ===");
            System.out.println("1. Añadir producto al inventario");
            System.out.println("2. Registrar cliente y armar carrito");
            System.out.println("3. Atender cliente");
            System.out.println("4. Ver inventario");
            System.out.println("5. Gestionar grafo: añadir vértice");
            System.out.println("6. Gestionar grafo: añadir arista");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine().trim();
                    if (nombre.isEmpty()) { System.out.println("Nombre requerido."); break; }
                    System.out.print("Precio: ");
                    double precio = 1.0;
                    try { precio = Double.parseDouble(sc.nextLine().trim()); } catch (Exception e) {}
                    System.out.print("Categoría: ");
                    String cat = sc.nextLine().trim();
                    if (cat.isEmpty()) cat = "General";
                    System.out.print("Fecha venc. (opcional): ");
                    String fv = sc.nextLine().trim();
                    if (fv.isEmpty()) fv = null;
                    System.out.print("Cantidad: ");
                    int cant = 1;
                    try { cant = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) {}
                    if (cant < 1) cant = 1;

                    Producto p = new Producto(nombre, precio, cat, fv, cant);
                    tienda.añadirProducto(p);
                    break;

                case 2:
                    tienda.registrarCliente(sc);
                    break;

                case 3:
                    tienda.atenderCliente();
                    break;

                case 4:
                    tienda.getInventario().mostrarInventario();
                    break;

                case 5:
                    System.out.print("ubicación del vértice: ");
                    String vertice = sc.nextLine().trim();
                    if (!vertice.isEmpty()) {
                        tienda.agregarVerticeGrafo(vertice);
                    } else {
                        System.out.println("Ubicación inválida.");
                    }
                    break;

                case 6:
                    System.out.print("Origen: ");
                    String origen = sc.nextLine().trim();
                    System.out.print("Destino: ");
                    String destino = sc.nextLine().trim();
                    System.out.print("Distancia en km: ");
                    double peso = 1.0;
                    try { peso = Double.parseDouble(sc.nextLine().trim()); } catch (Exception e) {}
                    if (!origen.isEmpty() && !destino.isEmpty() && peso > 0) {
                        tienda.agregarAristaGrafo(origen, destino, peso);
                    } else {
                        System.out.println("Datos inválidos.");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    if (opcion != -1) System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        sc.close();
    }
}