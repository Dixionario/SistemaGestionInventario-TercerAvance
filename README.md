# Sistema de Gestión de Ventas con Estructuras de Datos Avanzadas

Este proyecto es un **sistema de gestión de ventas desarrollado en Java**, que integra varias estructuras de datos avanzadas para manejar inventario, clientes, logística y rutas de entrega.  
Todo se controla mediante un menú de consola y **no requiere librerías externas**.

## 📌 Funcionalidades Principales
- **Inventario (Árbol Binario de Búsqueda - ABB)**  
  Los productos se almacenan y ordenan por nombre, permitiendo búsquedas eficientes.

- **Carrito de compras (Lista Enlazada)**  
  Cada cliente gestiona su propio carrito mediante una lista enlazada dinámica.

- **Atención de clientes (Cola de Prioridad)**  
  Los clientes se atienden según su nivel:  
  - Básico  
  - Afiliado  
  - Premium  

- **Rutas de entrega (Grafo + Dijkstra)**  
  - Grafo no dirigido y ponderado que representa ubicaciones y distancias.  
  - Implementación del algoritmo de **Dijkstra** para calcular la ruta óptima desde la tienda hasta el cliente.  
  - Validación previa de conectividad para evitar ubicaciones inválidas.

- **Menú interactivo en consola**  
  Permite navegar por todas las opciones del sistema de forma sencilla e intuitiva.

## 🧩 Estructura del Proyecto
- **Producto, Cliente y Carrito:** Modelos básicos del sistema.  
- **Lista Enlazada:** Manejo dinámico del carrito de cada cliente.  
- **Árbol Binario de Búsqueda:** Organización y consulta del inventario.  
- **Cola de Prioridad:** Gestión de turnos según niveles del cliente.  
- **Grafo (no dirigido y ponderado):** Mapa de ubicaciones y distancias.  
- **Dijkstra:** Cálculo de la ruta más corta para las entregas.  
- **Main:** Control del flujo y del menú de la aplicación.

## 🛠️ Tecnologías Utilizadas
- **Lenguaje:** Java  
- **IDE:** IntelliJ IDEA  
- **Paradigma:** Programación Orientada a Objetos  
- **Estructuras:**  
  - Listas enlazadas  
  - Árbol binario de búsqueda  
  - Cola de prioridad  
  - Grafo y algoritmo de Dijkstra  

## ▶️ Cómo Ejecutarlo
1. Abrí el proyecto en **IntelliJ IDEA**.  
2. Ejecutá `Main.java`.  
3. Usá el menú de consola para administrar inventario, clientes y rutas de entrega.

## 📚 Propósito de Aprendizaje
Este proyecto refuerza conocimientos sobre:
- Estructuras de datos dinámicas  
- Algoritmos de búsqueda y optimización  
- Aplicación del grafo y Dijkstra en contextos reales  
- Diseño modular de sistemas  
- Simulación de un flujo completo de ventas y logística  

## 🚚 Aplicaciones Prácticas
- Sistemas de inventario  
- Programas de fidelización y prioridades  
- Modelado de rutas y entregas  
- Logística y optimización de recursos  

---

✍️ **Autor:** D’Jehovann Dixon Lawrence
