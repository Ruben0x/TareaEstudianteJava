package estudiante.util;

import java.util.Scanner;

public class Validaciones {

    private static final Scanner sc = new Scanner(System.in, "UTF-8");

    public static int leerEnteroPositivo(String mensaje, int min, int max ) {
        int numero = -1;
        do {
            System.out.print(mensaje);

            String entrada = sc.nextLine().trim();

             if(entrada.isEmpty()){
                 System.out.println("La entrada no puede estar vacía.");
                 continue;
             }

             try {
                 numero = Integer.parseInt(entrada);
                 if (numero <= 0) {
                     System.out.println("Por favor, ingrese un número entero positivo.");
                 }else if (numero < min || numero > max) {
                     System.out.println("Por favor, ingrese un número entre " + min + " y " + max + ".");
                     numero = -1;
                 }
             } catch (NumberFormatException e) {
                 System.out.println("Entrada inválida. Por favor, ingrese un número entero positivo.");
             }

        } while (numero <= 0);
        return numero;
    }


    public static double leerDouble(String mensaje, double min, double max ){
        double numero = -1;
        do {
            System.out.print(mensaje);

                   String entrada = sc.nextLine().trim();

             if(entrada.isEmpty()){
                 System.out.println("La entrada no puede estar vacía.");
                 continue;
             }
        
             try {
              
                numero = Double.parseDouble(entrada);
                 if (numero < min || numero > max) {
                     System.out.println("Por favor, ingrese un número entre " + min + " y " + max + ".");

                     numero = -1;
                 }
             } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número decimal válido. (Use punto decimal).");             }
        } while (numero < min || numero > max);
        return numero;
    }
    

public static String leerString(String mensaje, int minLength, int maxLength) {
    String texto;
    String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+(?:\\s[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+)*$";
    
    java.io.Console console = System.console();
    do {
        System.out.print(mensaje);
        texto = (console != null) ? console.readLine().trim() : sc.nextLine().trim();
        if (texto.isEmpty()) {
            System.out.println("La entrada no puede estar vacía.");
        } else if (!texto.matches(regex)) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            texto = "";
        } else if (texto.length() < minLength || texto.length() > maxLength) {
            System.out.println("La entrada debe tener entre " + minLength + " y " + maxLength + " caracteres.");
            texto = "";
        }
    } while (texto.isEmpty());
    
    return texto;
}
    
}
