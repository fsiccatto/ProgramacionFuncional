import Entidades.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    private static void sep(String titulo) {
        System.out.println();
        System.out.println("=== " + titulo + " ===");
    }

    public static void main(String[] args) {

        // ---------- ALUMNOS ----------
        sep("Alumnos");

        Alumno ana   = new Alumno("Ana", 9, "3k8");
        Alumno bruno = new Alumno("Bruno", 5, "3k8");
        Alumno caro  = new Alumno("Carolina", 7, "3k11");
        Alumno dario = new Alumno("Dario", 4, "3k11");

        List<Alumno> alumnos = List.of(ana, bruno, caro, dario);

        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(Alumno::getNombre)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Alumnos aprobados: " + aprobados);

        double promedioNotas = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);
        System.out.println("Promedio general: " + promedioNotas);

        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
        alumnosPorCurso.forEach((curso, lista) -> {
            System.out.println("Curso: " + curso);
            lista.forEach(System.out::println);
        });

        // ---------- PRODUCTOS ----------
        sep("Productos");

        Producto teclado  = new Producto("Teclado Mecanico", "Perifericos", 48990.0, 12);
        Producto mouse    = new Producto("Mouse Inalambrico", "Perifericos", 18990.0, 35);
        Producto monitor  = new Producto("Monitor 27\"", "Pantallas", 219990.0, 7);
        Producto hdmi     = new Producto("Cable HDMI 2.1", "Accesorios", 9990.0, 60);

        List<Producto> productos = List.of(teclado, mouse, monitor, hdmi);

        List<Producto> caros = productos.stream()
                .filter(p -> p.getPrecio() > 50000)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
        System.out.println("Productos caros: " + caros);

        Map<String, List<Producto>> prodPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria));
        prodPorCategoria.forEach((cat, lista) -> {
            System.out.println("Categoria: " + cat);
            lista.forEach(System.out::println);
        });

        double stockTotal = productos.stream()
                .mapToDouble(Producto::getStock)
                .sum();
        System.out.println("Stock total: " + stockTotal);

        String listado = productos.stream()
                .map(p -> p.getNombre() + " $" + p.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println("Listado: " + listado);

        double precioPromedio = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
        System.out.println("Precio promedio: " + precioPromedio);

        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        promedioPorCategoria.forEach((cat, prom) ->
                System.out.println("Categoria: " + cat + " -> Promedio: $" + prom)
        );

        // ---------- LIBROS ----------
        sep("Libros");

        Libro l1 = new Libro("Fundacion", "Isaac Asimov", 296, 18999);
        Libro l2 = new Libro("Duna", "Frank Herbert", 688, 25999);
        Libro l3 = new Libro("Hyperion", "Dan Simmons", 496, 22999);
        Libro l4 = new Libro("El problema de los tres cuerpos", "Liu Cixin", 400, 19999);

        List<Libro> libros = List.of(l1, l2, l3, l4);

        List<String> librosLargos = libros.stream()
                .filter(lib -> lib.getPaginas() >= 350)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Libros de 350 o mas paginas: " + librosLargos);

        double promPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);
        System.out.println("Promedio de paginas: " + promPaginas);

        Map<String, List<Libro>> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(Libro::getAutor));
        librosPorAutor.forEach((autor, lista) -> {
            System.out.println("Autor: " + autor);
            lista.forEach(System.out::println);
        });

        Optional<Libro> masCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));
        masCaro.ifPresent(lib ->
                System.out.println("Libro mas caro: " + lib.getTitulo() + " ($" + lib.getPrecio() + ")")
        );

        // ---------- EMPLEADOS ----------
        sep("Empleados");

        Empleado e1 = new Empleado("Lucia",  "Ventas",  850000.0, 28);
        Empleado e2 = new Empleado("Martin", "Ventas",  620000.0, 32);
        Empleado e3 = new Empleado("Sofia",  "IT",     1250000.0, 26);
        Empleado e4 = new Empleado("Tomas",  "IT",      980000.0, 30);

        List<Empleado> empleados = List.of(e1, e2, e3, e4);

        double umbral = 900000.0;
        List<Empleado> altosIngresos = empleados.stream()
                .filter(emp -> emp.getSalario() >= umbral)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .collect(Collectors.toList());
        System.out.println("Empleados con salario >= $" + umbral + ": " + altosIngresos);

        double salarioPromedio = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);
        System.out.println("Salario promedio: " + salarioPromedio);

        Map<String, List<Empleado>> empPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento));
        empPorDepto.forEach((depto, lista) -> {
            System.out.println("Departamento: " + depto);
            lista.forEach(System.out::println);
        });

        double totalSalarios = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .sum();
        System.out.println("Total de salarios: " + totalSalarios);

        Map<String, Double> sumaPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));
        sumaPorDepto.forEach((depto, suma) ->
                System.out.println("Depto: " + depto + " -> Suma: $" + suma)
        );

        List<Empleado> dosMasJovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("Los 2 mas jovenes: " + dosMasJovenes);
    }
}

