import java.util.*;

public class Grafo {
    private Map<String, Map<String, Double>> adyacencia;

    public Grafo() {
        this.adyacencia = new HashMap<>();
    }

    public void agregarVertice(String ubicacion) {
        adyacencia.putIfAbsent(ubicacion, new HashMap<>());
    }

    public void agregarArista(String origen, String destino, double peso) {
        agregarVertice(origen);
        agregarVertice(destino);
        adyacencia.get(origen).put(destino, peso);
        adyacencia.get(destino).put(origen, peso);
    }

    public boolean contieneVertice(String ubicacion) {
        return adyacencia.containsKey(ubicacion);
    }

    public List<String> getVertices() {
        return new ArrayList<>(adyacencia.keySet());
    }

    public Map<String, Double> getVecinos(String ubicacion) {
        return adyacencia.getOrDefault(ubicacion, new HashMap<>());
    }

    public boolean estanConectados(String origen, String destino) {
        return dijkstra(origen, destino) != null;
    }

    public List<String> dijkstra(String inicio, String fin) {
        if (!adyacencia.containsKey(inicio) || !adyacencia.containsKey(fin)) {
            return null;
        }

        Map<String, Double> distancias = new HashMap<>();
        Map<String, String> previos = new HashMap<>();
        Set<String> visitados = new HashSet<>();

        for (String v : adyacencia.keySet()) {
            distancias.put(v, Double.MAX_VALUE);
        }
        distancias.put(inicio, 0.0);

        PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));
        cola.offer(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            if (visitados.contains(actual)) continue;
            visitados.add(actual);

            if (actual.equals(fin)) break;

            for (Map.Entry<String, Double> vecino : adyacencia.get(actual).entrySet()) {
                String v = vecino.getKey();
                double peso = vecino.getValue();
                double nuevaDist = distancias.get(actual) + peso;

                if (nuevaDist < distancias.get(v)) {
                    distancias.put(v, nuevaDist);
                    previos.put(v, actual);
                    cola.offer(v);
                }
            }
        }

        if (distancias.get(fin) == Double.MAX_VALUE) {
            return null;
        }

        List<String> camino = new ArrayList<>();
        String paso = fin;
        while (paso != null) {
            camino.add(0, paso);
            paso = previos.get(paso);
        }
        return camino;
    }

    public double distanciaMinima(String inicio, String fin) {
        List<String> camino = dijkstra(inicio, fin);
        if (camino == null) return -1;
        double total = 0.0;
        for (int i = 0; i < camino.size() - 1; i++) {
            String u = camino.get(i);
            String v = camino.get(i + 1);
            total += adyacencia.get(u).get(v);
        }
        return total;
    }
}