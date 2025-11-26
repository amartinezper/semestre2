package lambdas.Consumer;

import java.util.function.Consumer;

public class Ej1Consumer {
    public static void main(String[] args) {

        Consumer<String> imprimir = mensaje ->
                System.out.println("Mensaje recibido: " + mensaje);

        imprimir.accept("Hola mundo");
    }
}
