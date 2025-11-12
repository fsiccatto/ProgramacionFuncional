# Proyecto: Programación Funcional en Java

Pequeña colección de ejemplos que uso para aprender y practicar operaciones con streams, colecciones y agrupaciones en Java (Gradle).

Un poco sobre el proyecto
- Lenguaje: Java
- Build: Gradle (se incluye Gradle Wrapper)
- Entrada: Clase principal `Main` en `src/main/java/Main.java`

Cómo compilar y ejecutar (Windows)
Desde la raíz del proyecto, en PowerShell o cmd.exe:

```
.\gradlew.bat build
.\gradlew.bat run
```

Alternativa: abrir el proyecto en IntelliJ IDEA y ejecutar la clase `Main`.

Requisitos
- JDK 17+ instalado y configurado en la variable `PATH`.
- No se requieren dependencias externas adicionales.

Estructura relevante
- `src/main/java/Main.java` — Punto de entrada con ejemplos de streams.
- `src/main/java/Entidades/` — Clases de dominio: `Alumno`, `Producto`, `Libro`, `Empleado`.
- `build.gradle` — Configuración de compilación.

Notas
- Es un proyecto didáctico, pensado para experimentar con streams (map, filter, collect, groupingBy, etc.).
- Si haces cambios, sigue la convención de `toString()` en las entidades para salida legible.

Por: fsiccatto ⚡️

