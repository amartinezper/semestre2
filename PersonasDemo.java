package lambdas;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class PersonasDemo {
    public static void main(String[] args) {
        // Lista de personas (mínimo 5)
        List<Persona> personas = Arrays.asList(
                new Persona("Juan", 22, "Bogotá"),
                new Persona("María", 17, "Medellín"),
                new Persona("Andrés", 30, "Cali"),
                new Persona("Lucía", 25, "Bogotá"),
                new Persona("Pedro", 15, "Barranquilla")
        );

        // --- Declaración de interfaces funcionales ---

        // Consumer<T> - ejecuta una acción
        Consumer<Persona> imprimirPersona = p -> System.out.println(p);
        Consumer<String> imprimirTexto = System.out::println;

        // Predicate<T> - filtrar / validar
        Predicate<Persona> esMayorDeEdad = p -> p.getEdad() >= 18;
        Predicate<Persona> viveEnBogota = p -> p.getCiudad().equalsIgnoreCase("Bogotá")
                || p.getCiudad().equalsIgnoreCase("Bogota");

        // Function<T,R> - transformar datos
        Function<Persona, String> obtenerNombre = Persona::getNombre;
        Function<Persona, String> nombreEnMayuscula = p -> p.getNombre().toUpperCase();

        // Supplier<T> - proveer valores sin parámetros
        Supplier<Persona> generarPersonaAleatoria = () -> {
            String[] nombres = {"Carlos", "Ana", "Sofía", "Diego", "Valentina", "Mateo", "Camila"};
            String[] ciudades = {"Bogotá", "Medellín", "Cali", "Barranquilla", "Pereira", "Bucaramanga"};
            Random rnd = new Random();
            String nombre = nombres[rnd.nextInt(nombres.length)];
            int edad = 1 + rnd.nextInt(100);
            String ciudad = ciudades[rnd.nextInt(ciudades.length)];
            return new Persona(nombre, edad, ciudad);
        };

        // BiConsumer<T,U> - acción con dos valores
        BiConsumer<String, Integer> mostrarNombreEdad = (nombre, edad) ->
                System.out.println("Hola " + nombre + ", tienes " + edad + " años");

        // BiFunction<T,U,R> - combina valores y devuelve algo
        BiFunction<String, String, String> mensajeNombreCiudad = (nombre, ciudad) ->
                nombre + " vive en " + ciudad;


        // --- Aplicación práctica de las interfaces ---

        // 1) Mostrar únicamente los nombres
        System.out.println("1) Nombres de todas las personas:");
        personas.stream()
                .map(obtenerNombre)
                .forEach(imprimirTexto);
        System.out.println();

        // 2) Filtrar e imprimir mayores de edad
        System.out.println("2) Personas mayores de edad (>=18):");
        personas.stream()
                .filter(esMayorDeEdad)
                .forEach(imprimirPersona);
        System.out.println();

        // 3) Obtener lista con solo los nombres
        System.out.println("3) Lista con solo nombres:");
        List<String> nombres = personas.stream()
                .map(obtenerNombre)
                .toList();
        System.out.println(nombres);
        System.out.println();

        // 4) Mostrar mensaje que relacione nombre y ciudad
        System.out.println("4) Mensajes: 'X vive en Y'");
        personas.stream()
                .map(p -> mensajeNombreCiudad.apply(p.getNombre(), p.getCiudad()))
                .forEach(imprimirTexto);
        System.out.println();

        // 5) Mensaje personalizado con nombre y edad
        System.out.println("5) Mensaje personalizado:");
        personas.forEach(p -> mostrarNombreEdad.accept(p.getNombre(), p.getEdad()));
        System.out.println();

        // 6) Generar persona aleatoria (Supplier)
        System.out.println("6) Persona aleatoria generada:");
        Persona aleatoria = generarPersonaAleatoria.get();
        System.out.println(aleatoria);
        System.out.println();

        // 7) Nombres en mayúsculas (Function)
        System.out.println("7) Nombres en mayúsculas:");
        personas.stream()
                .map(nombreEnMayuscula)
                .forEach(imprimirTexto);
        System.out.println();

        // 8) Filtrar personas que vivan en Bogotá
        System.out.println("8) Personas que viven en Bogotá:");
        personas.stream()
                .filter(viveEnBogota)
                .forEach(imprimirPersona);
        System.out.println();

        // 9) Crear lista de mensajes formateados
        System.out.println("9) Lista de mensajes 'Juan (22 años) es de Bogotá':");
        List<String> mensajes = personas.stream()
                .map(p -> String.format("%s (%d años) es de %s", p.getNombre(), p.getEdad(), p.getCiudad()))
                .toList();
        mensajes.forEach(imprimirTexto);
        System.out.println();

        // Extra: cuántos mayores hay (Predicate)
        long mayores = personas.stream().filter(esMayorDeEdad).count();
        System.out.println("Extra) Cantidad de mayores de edad: " + mayores);
    }
}

// Clase Persona
class Persona {
    private String nombre;
    private int edad;
    private String ciudad;

    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCiudad() { return ciudad; }

    @Override
    public String toString() {
        return String.format("Persona{nombre='%s', edad=%d, ciudad='%s'}", nombre, edad, ciudad);
    }
}
