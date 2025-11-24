# **Ordenación básica en Java: Burbuja, Selección e Inserción**

## **Integrantes**
- Yober Gaona
- Mateo Silva
  
---

## **1. Objetivo(s) de la Práctica**

- Ejecutar y analizar comparativamente los algoritmos de **Burbuja**, **Selección** e **Inserción** sobre casos de prueba.  
- Determinar cuándo conviene cada uno en función de tamaño, grado de orden y duplicados.

---

## **2. Materiales y reactivos**

- Guía de pruebas con datasets y salidas esperadas.

---

## **3. Equipos y herramientas**

- **JDK OpenJDK (obligatorio)**  
- **IDE:** Visual Studio Code (Extension Pack for Java) o IntelliJ IDEA Community  
- **Sistema de control de versiones:** Git + GitHub  
- **Moodle/EVA institucional** para subir evidencias  
- **Documentación:** README.md, Google Docs, LibreOffice o Word  

---

## **4. Procedimiento / Metodología**

### **Enfoque metodológico: ABPr (Aprendizaje Basado en Proyectos)**

---

### **Paso 1: Instrumentación**

- Añadir contadores:

  - `comparisons++` al comparar dos claves  
  - `swaps++` al intercambiar posiciones  

- Medir tiempo con `System.nanoTime()`  
- Ejecutar **R=10 repeticiones**, descartar las primeras 3 (calentamiento)  
- Reportar la **mediana**  
- Aislar el IO (cargar CSV antes de medir)

---

### **Paso 2: Casos de prueba**

- Definir clave de orden (fecha, apellido, stock, etc.)
- Convertir a array o a objetos `Comparable`
- Ejecutar:

  - Insertion Sort  
  - Selection Sort  
  - Bubble Sort (con corte temprano)

- Registrar:

n, %casi-ordenado, %duplicados, comparisons, swaps, tiempo(ns)

yaml
Copy code

---

### **Paso 3: Análisis**

- Tablas comparativas (por n, orden, duplicados)
- Gráficos (tiempo vs n, tiempo vs % orden)
- Matriz de recomendación:

  - Casi ordenado Inserción  
  - Muchos duplicados Inserción (estable)  
  - Minimizar swaps Selección  
  - Aleatorio / inverso Selección o Inserción  
  - Burbuja penaliza en general  

---

## **7. Resultados esperados**

- Tabla por dataset:
n | tipo | algoritmo | comparisons | swaps | tiempo_mediana(ns)

- Gráficos (opcionales)
- Matriz de recomendación final
- Capturas o logs de ejecución
- Código instrumentado

---

## **Imágenes**

### Código
![Código](https://i.postimg.cc/SNx2525m/Imagen1.png)

### Ejecución
![Ejecución](https://i.postimg.cc/hPtzwzY6/Imagen2.png)

---

## **8. Preguntas de Control**

### **¿Por qué imprimir trazas distorsiona los tiempos?**
Porque imprimir en consola es una operación lenta (IO bloqueante), altera la medición y no representa el tiempo real del algoritmo.

---

### **¿Por qué Selección siempre tiene ~n(n−1)/2 comparaciones?**
Porque siempre recorre toda la lista buscando el mínimo, aunque ya esté ordenada.  
No tiene corte temprano.

---

### **¿Por qué Inserción es competitivo en datos casi ordenados?**
Porque el ciclo interno casi no se ejecuta: los elementos ya están en su lugar y se mueve muy poco.  
Pasa de O(n²) a casi O(n).

---

### **¿Qué papel juegan los duplicados?**
- Inserción y Burbuja
   **estables**
  - mantienen el orden  
- Selección
   **inestable**
  - puede invertir duplicados

---

### **¿Por qué Burbuja con corte temprano mejora en casi ordenado pero no en inverso?**

- **Casi ordenado:**
- no hay swaps
- se activa el corte
- termina en O(n)  
- **Inverso:**
- siempre hay swaps
- nunca corta
- sigue siendo O(n²)
