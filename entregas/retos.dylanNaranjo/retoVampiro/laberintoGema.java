import java.util.Scanner;

public class laberintoGema {
    static int[][] mapaLaberinto = {
            { 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
            { 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
            { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0 },
            { 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0 },
            { 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
            { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0 },
            { 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0 },
            { 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0 },
            { 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
            { 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0 },
            { 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 }
    };

    static int personajePosicionX;
    static int personajePosicionY;
    static int minimoX; // Minimo en el X que el Personaje se puede mover en el Mapa//
    static int minimoY; // Minimo en el Y que el Personaje se puede mover en el Mapa//
    static int maximoX; // Maximo en el X que el Personaje se puede mover en el Mapa//
    static int maximoY; // Maximo en el Y que el Personaje se puede mover en el Mapa//
    static int alcanceAntorcha = 2;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        personajePosicionX = 2;
        personajePosicionY = 28;
        minimoX = 0;
        minimoY = 0;
        maximoX = mapaLaberinto.length - 1;
        maximoY = mapaLaberinto[0].length - 1;

        boolean caminando = true;
        String accion;
        bienvenidaalPrograma();
        mostrarlaberinto();

        while (caminando) {
            comandosdelPrograma();
            System.out.print("Ingrese comando: ");
            accion = entrada.nextLine();
            if (accion.length() > 1) {
                accion = accion.substring(0, 1);
            }

            switch (accion) {
                case "w":
                    arriba();
                    mostrarlaberinto();
                    break;
                case "s":
                    abajo();
                    mostrarlaberinto();
                    break;
                case "d":
                    derecha();
                    mostrarlaberinto();
                    break;
                case "a":
                    izquierda();
                    mostrarlaberinto();
                    break;
                case "f":
                    caminando = false;
                    break;
                case "g":
                    antorchaAlcancelargo();
                    break;
                default:
                    errorComando();
                    mostrarlaberinto();
                    break;
            }
        }
    }

    static void arriba() {
        if ((personajePosicionX > minimoX) && (mapaLaberinto[personajePosicionX - 1][personajePosicionY] != 1)) {
            personajePosicionX = personajePosicionX - 1;
            System.out.print("Caminas hacia el arriba");
        } else {
            errorSalirTablero();
        }
    }

    static void izquierda() {
        if ((personajePosicionY > minimoY) && (mapaLaberinto[personajePosicionX][personajePosicionY - 1] != 1)) {
            personajePosicionY = personajePosicionY - 1;
            System.out.println("Caminas hacia la izquierda");
        } else {
            errorSalirTablero();
        }
    }

    static void derecha() {
        if ((personajePosicionY < maximoY) && (mapaLaberinto[personajePosicionX][personajePosicionY + 1] != 1)) {
            personajePosicionY = personajePosicionY + 1;
            System.out.println("Caminas hacia la derecha");
        } else {
            errorSalirTablero();
        }
    }

    static void abajo() {
        if ((personajePosicionX < maximoX) && (mapaLaberinto[personajePosicionX + 1][personajePosicionY] != 1)) {
            personajePosicionX = personajePosicionX + 1;
            System.out.println("Caminas hacia abajo");
        } else {
            errorSalirTablero();
        }
    }

    static void errorSalirTablero() {
        System.out.print("!Chocaste con una pared! No puedes ir mas allá");
    }

    static void mostrarlaberinto() {
        imprimeLaberinto();
    }

    static void errorComando() {
        System.out.println("Comando Inválido!");
    }

    static void bienvenidaalPrograma() {
        System.out.println(
                "Hola, Indiana Jones. Spawneaste en un laberinto. Empieza a caminar a ver si encuentras una salida...");
    }

    static void comandosdelPrograma() {
        System.out.println("[w] Arriba, [s] Abajo, [a] Izquierda, [d] Derecha, [g] Gema,  [f] Fin del Juego.");
    }

    static void antorchaAlcancelargo() {
        {
            alcanceAntorcha = 100;
            mostrarlaberinto();
            alcanceAntorcha = 2;
        }
    }

    static void imprimeLaberinto() {
        System.out.println();
        System.out.println("+----------------------------------------------------------+");
        for (int i = 0; i < mapaLaberinto.length; i++) {
            System.out.print("|");
            for (int j = 0; j < mapaLaberinto[i].length; j++) {
                if ((i == personajePosicionX) && (j == personajePosicionY)) {
                    System.out.print("IJ");
                } else if ((personajePosicionX + alcanceAntorcha >= i) && (personajePosicionX - alcanceAntorcha <= i)
                        && (personajePosicionY + alcanceAntorcha >= j) && (personajePosicionY - alcanceAntorcha <= j)) {
                    if (mapaLaberinto[i][j] == 1) {
                        System.out.print("[]");
                    } else {
                        System.out.print("  ");
                    }
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+----------------------------------------------------------+");
        System.out.println();
    }
}