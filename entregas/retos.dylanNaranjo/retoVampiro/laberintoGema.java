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
    static int minimoX;
    static int minimoY;
    static int maximoX;
    static int maximoY;
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
        bienvenidaAlPrograma();

        while (caminando == true) {
            imprimeLaberinto();
            comandosDelPrograma();
            System.out.print("Ingrese comando: ");
            accion = entrada.nextLine();
            if (accion.length() > 1) {
                accion = accion.substring(0, 1);
            }

            switch (accion) {
                case "w":
                    arriba();
                    break;
                case "s":
                    abajo();
                    break;
                case "d":
                    derecha();
                    break;
                case "a":
                    izquierda();
                    break;
                case "f":
                    caminando = false;
                    break;
                case "g":
                    antorchaAlcancelargo();
                    break;
                default:
                    errorComando();
                    break;
            }
        }
    }

    static void arriba() {
        if ((personajePosicionX > minimoX) && (mapaLaberinto[personajePosicionX - 1][personajePosicionY] != 1)) {
            personajePosicionX = personajePosicionX - 1;
            System.out.println("Caminas hacia el arriba");
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
        System.out.println("!Chocaste con una pared! No puedes ir mas allá");
    }

    static void errorComando() {
        System.out.println("Comando Inválido!");
    }

    static void bienvenidaAlPrograma() {
        System.out.println(
                "Hola, Indiana Jones. Spawneaste en un laberinto. Empieza a caminar a ver si encuentras una salida...");
    }

    static void comandosDelPrograma() {
        System.out.println("[w] Arriba, [s] Abajo, [a] Izquierda, [d] Derecha, [g] Gema,  [f] Fin del Juego.");
    }

    static void antorchaAlcancelargo() {
        alcanceAntorcha = 100;
        imprimeLaberinto();
        alcanceAntorcha = 2;
    }

    static void imprimeLaberinto() {
        imprimirSeparador();
        for (int i = 0; i < mapaLaberinto.length; i++) {
            System.out.print("|");
            for (int j = 0; j < mapaLaberinto[i].length; j++) {
                imprimirCasilla(i, j);
            }
            System.out.println("|");
        }
        imprimirSeparador();
        System.out.println();
    }

    static void imprimirSeparador() {
        System.out.println("+----------------------------------------------------------+");
    }

    static void imprimirCasilla(int i, int j) {
        if ((i == personajePosicionX) && (j == personajePosicionY)) {
            System.out.print("IJ");
        } else if ((personajeEnAlcance(i, j))) {
            if (mapaLaberinto[i][j] == 1) {
                System.out.print("[]");
            } else {
                System.out.print("  ");
            }
        } else {
            System.out.print("  ");
        }
    }

    static boolean personajeEnAlcance(int i, int j) {
        return (personajePosicionX + alcanceAntorcha >= i) && (personajePosicionX - alcanceAntorcha <= i)
                && (personajePosicionY + alcanceAntorcha >= j) && (personajePosicionY - alcanceAntorcha <= j);
    }
}
