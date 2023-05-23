import java.util.Scanner;

public class ReservaAulas {

    public static void main(String[] args) {
        int opcion, aulaReservada, numeroAula;
        boolean[] aulas = { true, true, true };
        boolean aulaLiberada;

        Scanner scanner = new Scanner(System.in);

        do {
            mostrarEstadoAulas(aulas);

            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Reservar un aula");
            System.out.println("2. Liberar un aula");
            System.out.println("3. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del profesor para reservar un aula:");
                    String nombreProfesor = scanner.nextLine();
                    aulaReservada = reservarAula(aulas);
                    if (aulaReservada == -1) {
                        System.out.println("No hay aulas disponibles. Por favor, inténtelo nuevamente más tarde.");
                    } else {
                        System.out.println(
                                "El profesor " + nombreProfesor + " ha reservado el Aula " + (aulaReservada + 1) + ".");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el número de aula a liberar:");
                    numeroAula = scanner.nextInt();
                    scanner.nextLine();
                    aulaLiberada = liberarAula(aulas, numeroAula);
                    if (aulaLiberada) {
                        System.out.println("El Aula " + numeroAula + " ha sido liberada.");
                    } else {
                        System.out.println("El número de aula ingresado es inválido o el aula ya estaba libre.");
                    }
                    break;
                case 3:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }

            System.out.println();
        } while (opcion != 3);
    }

    public static void mostrarEstadoAulas(boolean[] aulas) {
        System.out.println("Estado de las aulas:");
        for (int i = 0; i < aulas.length; i++) {
            String estado = aulas[i] ? "Libre" : "Ocupada";
            System.out.println("Aula " + (i + 1) + ": " + estado);
        }
        System.out.println();
    }

    public static int reservarAula(boolean[] aulas) {
        for (int i = 0; i < aulas.length; i++) {
            if (aulas[i]) {
                aulas[i] = false;
                return i;
            }
        }
        return -1;
    }

    public static boolean liberarAula(boolean[] aulas, int numeroAula) {
        if (numeroAula >= 1 && numeroAula <= aulas.length) {
            if (!aulas[numeroAula - 1]) {
                aulas[numeroAula - 1] = true;
                return true;
            }
        }
        return false;
    }
}