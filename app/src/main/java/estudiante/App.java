
package estudiante;

import java.util.ArrayList;

import estudiante.model.Estudiante;
import estudiante.util.Validaciones;

public class App {

    public static void main(String[] args) {


        System.out.println("Bienvenido al sistema de gestión de estudiantes");

        int numeroEstudiantes = Validaciones.leerEnteroPositivo("Ingrese el numero de estudiantes: ", 1, 100 );

        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();


        for (int i = 0; i < numeroEstudiantes; i++) {
            System.out.println("Ingrese los datos del estudiante " + (i + 1) + ":");
            String nombre = Validaciones.leerString("Nombre: ", 1, 24);

            int edad = Validaciones.leerEnteroPositivo("Edad: ", 1, 120);

            double notaFinal = Validaciones.leerDouble("Nota Final: ", 0.0, 7.0);

            Estudiante estudiante = new Estudiante(nombre, edad, notaFinal);
            listaEstudiantes.add(estudiante);
        }


        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar información de todos los estudiantes");
            System.out.println("2. Mostrar estudiantes aprobados");
            System.out.println("3. Salir");
            int opcion = Validaciones.leerEnteroPositivo("Seleccione una opción: ", 1, 3);

            if (opcion == 1) {
                for (Estudiante estudiante : listaEstudiantes) {
                    estudiante.mostrarInformacion();
                    System.out.println("-----------------------");
                }
            } else if (opcion == 2) {
                System.out.println("Estudiantes aprobados:");
                for (Estudiante estudiante : listaEstudiantes) {
                    if (estudiante.getNotaFinal() >= 6.0) {
                        estudiante.mostrarInformacion();
                        System.out.println("-----------------------");
                    }
                }
            } else if (opcion == 3) {
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }


    }
}
