public class ColaClientes {
    private Cliente[] cola;
    private int frente;
    private int fin;
    private int capacidad;
    private int tamaño;

    public ColaClientes(int capacidad) {
        this.capacidad = capacidad;
        this.cola = new Cliente[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamaño = 0;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public void encolar(Cliente cliente) {
        if (tamaño == capacidad) {
            System.out.println("Cola llena. No se puede añadir más clientes.");
            return;
        }
        fin = (fin + 1) % capacidad;
        cola[fin] = cliente;
        tamaño++;
    }

    public Cliente atender() {
        if (estaVacia()) return null;

        int mejorIdx = frente;
        int mejorPrioridad = cola[frente].getPrioridad();

        for (int i = 0; i < tamaño; i++) {
            int idx = (frente + i) % capacidad;
            int prioridad = cola[idx].getPrioridad();
            if (prioridad > mejorPrioridad) {
                mejorPrioridad = prioridad;
                mejorIdx = idx;
            }
        }

        Cliente atendido = cola[mejorIdx];

        for (int i = mejorIdx; i != fin; i = (i + 1) % capacidad) {
            cola[i] = cola[(i + 1) % capacidad];
        }
        cola[fin] = null;
        fin = (fin - 1 + capacidad) % capacidad;
        tamaño--;

        return atendido;
    }

    public int getTamaño() {
        return tamaño;
    }
}