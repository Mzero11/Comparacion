Ordenación	básica	en	Java:	Burbuja, Selección e Inserción

1.	Objetivo(s) de la Práctica:
•	Ejecutar y analizar comparativamente los algoritmos de Burbuja, Selección e Inserción sobre casos de prueba, para determinar cuándo conviene cada uno en función de tamaño, grado de orden y duplicados.

2.	Materiales y reactivos:
•	Guía de pruebas con datasets y salidas esperadas.

3.	Equipos y herramientas
•	JDK OpenJDK (obligatorio).
•	IDE: Visual Studio Code (extensión “Extension Pack for Java”) o IntelliJ IDEA
Community.
•	Sistema de control de versiones: Git; repositorio en GitHub.
•	EVA/Moodle institucional: para entrega de evidencias.
•	Herramientas de documentación: README Markdown, editor ofimático (Google Docs/LibreOffice/Word).
 
4.	Procedimiento / Metodología
Enfoque metodológico: ABPr (Aprendizaje Basado en Proyectos). Inicio
•	Presentación del objetivo comparativo y criterios de éxito.
•	Formación de equipos (3–4) y revisión de la rúbrica.
•	Creación de repo Git.
•	Lineamientos de uso responsable de IA. Desarrollo
•	Paso 1. Instrumentación (obligatorio)
o	Añade contadores a tus algoritmos:
	comparisons++ al comparar dos claves,
	swaps++ al intercambiar posiciones.
o	Mide tiempo con `System.nanoTime()` sin imprimir durante la medición (las trazas distorsionan).
o	Ejecuta R repeticiones por caso (sug.: R=10), descarta las 3 primeras (calentamiento/JIT) y reporta la mediana de tiempo.
o	Aísla IO: carga CSV fuera de la medición; mide sólo el ordenamiento del array en memoria.
•	Paso 2. Casos de prueba
o	Define clave de orden (p. ej., `fechaHora` en `citas`, `apellido` en
`pacientes`, `stock` en `inventario`).
o	Convierte a array de la clave (o a registros con `Comparable` por clave).
o	Ejecuta: Insertion, Selection, Bubble (con “corte temprano” en
Burbuja).
o	Registra: n, %casi-ordenado, %duplicados, comparisons, swaps, tiempo(ns) (mediana de R-3 corridas).
•	Paso 3. Análisis
o	Tablas comparativas por caso (n, orden, duplicados) y gráficos (tiempo vs. n; tiempo vs. %casi-ordenado).
o	Matriz de recomendación (reglas prácticas):
	Casi ordenado + n pequeño/medio → Inserción gana (menos
movimientos).
	Muchos duplicados → Inserción tiende a mantener estabilidad útil; Selección hace n(n−1)/2 comparaciones siempre, con pocos swaps.
	Inverso o aleatorio (n pequeño/educativo) → cualquiera, pero Burbuja penaliza; Selección constante en comparaciones; Inserción peor en inverso pero mejor si detecta localmente orden.
Cierre
•	Discusión guiada: ¿Cuándo conviene cada uno? ¿Qué sesgos introdujo la medición?
•	Completar	README	e	informe	con	evidencias	y	la	matriz	de recomendación.
 

 
5.	Resultados esperados:
•	Tabla	por	dataset:	`n,	tipo	(aleat/casi-ord/dup/inverso),	algoritmo, comparisons, swaps, tiempo_mediana(ns)`.
•	Gráficos (opcional): barras o líneas para tiempo y comparaciones.
•	Matriz de recomendación (texto/tabla): “si casi ordenado y n≤500 → Inserción”, “si minimizar swaps → Selección”, etc.
•	Capturas/Logs de ejecución (sin trazas durante medición).
•	Código con instrumentación y scripts de generación de datasets (si aplica).

[url=https://postimg.cc/JtSzHnMF][img]https://i.postimg.cc/JtSzHnMF/Imagen1.png[/img][/url]

[url=https://postimg.cc/YjTCL9Mz][img]https://i.postimg.cc/YjTCL9Mz/Imagen2.png[/img][/url]


6.	Preguntas de Control:
•	¿Por qué imprimir trazas durante la medición distorsiona los tiempos?

Imprimir en consola es una de las operaciones más lentas que puede ejecutar un programa Java, porque involucra operaciones de entrada y salida, obliga al programa a esperar a que el sistema procese la salida

•	Explica por qué Selección tiene comparaciones ~ n(n−1) /2 sin importar el
orden inicial.

El algoritmo Selection Sort siempre recorre todo el arreglo buscando el mínimo, luego repite con el resto de elementos y en cada iteración, compara todos los elementos restantes, aunque el arreglo ya esté ordenado o casi ordenado, porque no tiene cortes tempranos y no detecta si ya está ordenado.

•	¿Por qué Inserción es competitivo en datos casi ordenados?

Insertion Sort funciona desplazando elementos hacia la izquierda solo mientras encuentra valores mayores, cuando los datos ya están casi ordenados el bucle interior while casi nunca entra y cada elemento avanza muy pocas posiciones El algoritmo hace casi solo una comparación por elemento. Por eso, este es excelente para datos casi ordenados, como los que suelen aparecer en casos reales.

•	¿Qué papel juegan los duplicados en la estabilidad del resultado?

Cuando hay duplicados, la importancia de la estabilidad aumenta, un algoritmo estable mantiene el orden relativo de los elementos con la misma clave como por ejemplo, mismo ID, pero esto puede ser relevante ya que, los objetos tienen más atributos además del ID, la ordenación posterior depende del orden original y referente a la influencia de duplicados en algoritmos estables como Inserción o Burbuja, dos elementos con el mismo ID se mantienen en el mismo orden y en algoritmos inestables como Selección, los duplicados pueden invertirse, cambiando el orden relativo.

•	¿Por qué Burbuja con corte temprano mejora en “casi ordenado” pero no en “inverso”?

Burbuja con corte temprano optimizado detiene el algoritmo cuando detecta que no hubo swaps en una pasada.
En casi ordenado
•	En la primera pasada casi no hay intercambios.
•	A veces no hay ninguno.
•	Se activa el corte temprano.
•	El algoritmo termina en O(n).
•	Por eso mejora muchísimo.

En inverso

•	En una lista invertida todos los pares están desordenados.
•	Se hace un swap en cada comparación.
•	Nunca se cumple la condición de corte temprano
•	Seguimos realizando las n-1 pasadas completas.
•	Por eso, en el peor caso (inverso), Burbuja sigue siendo O(n²) y no mejora nada.

