import java.util.Scanner;

public class laberintoFinal {
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
    static int[] vampiroPosicionX = { 10, 6, 4 };
    static int[] vampiroPosicionY = { 22, 4, 14 };

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

            for (int a = 0; a < 3; a = a + 1) {
                vampiroPosicionX[a] = nuevaPosicionX(vampiroPosicionX[a], vampiroPosicionY[a]);
                vampiroPosicionY[a] = nuevaPosicionY(vampiroPosicionX[a], vampiroPosicionY[a]);
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
                    antorchaAlcanceLargo();
                    break;
                default:
                    errorComando();
                    break;
            }
        }
    }

    static void arriba() {
        if ((personajePosicionX - 1 >= minimoX) && (mapaLaberinto[personajePosicionX - 1][personajePosicionY] != 1)) {
            personajePosicionX = personajePosicionX - 1;
            System.out.print("Caminas hacia el arriba");
        } else {
            errorSalirTablero();
        }
    }

    static void izquierda() {
        if ((personajePosicionY - 1 >= minimoY) && (mapaLaberinto[personajePosicionX][personajePosicionY - 1] != 1)) {
            personajePosicionY = personajePosicionY - 1;
            System.out.println("Caminas hacia la izquierda");
        } else {
            errorSalirTablero();
        }
    }

    static void derecha() {
        if ((personajePosicionY + 1 <= maximoY) && (mapaLaberinto[personajePosicionX][personajePosicionY + 1] != 1)) {
            personajePosicionY = personajePosicionY + 1;
            System.out.println("Caminas hacia la derecha");
        } else {
            errorSalirTablero();
        }
    }

    static void abajo() {
        if ((personajePosicionX + 1 <= maximoX) && (mapaLaberinto[personajePosicionX + 1][personajePosicionY] != 1)) {
            personajePosicionX = personajePosicionX + 1;
            System.out.println("Caminas hacia abajo");
        } else {
            errorSalirTablero();
        }
    }

    static void errorSalirTablero() {
        System.out.print("!Chocaste con una pared! No puedes ir mas allá");
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

    static void antorchaAlcanceLargo() {
        {
            alcanceAntorcha = 100;
            imprimeLaberinto();
            alcanceAntorcha = 2;
        }
    }

    static void imprimeLaberinto() {
        System.out.println();
        System.out.println("+----------------------------------------------------------+");
        for (int i = 0; i < mapaLaberinto.length; i++) {
            System.out.print("|");
            for (int j = 0; j < mapaLaberinto[i].length; j++) {
                String miElemento = obtenerElemento(i, j);
                System.out.print(miElemento);
            }
            System.out.println("|");
        }
        System.out.println("+----------------------------------------------------------+");
        System.out.println();
    }

    static String obtenerElemento(int i, int j) {
        String miElemento = "  ";
        if ((i == personajePosicionX) && (j == personajePosicionY)) {
            miElemento = "IJ";
        } else if (personajeEnAlcance(i, j)) {
            if (mapaLaberinto[i][j] == 1) {
                miElemento = "[]";
            } else {
                for (int a = 0; a < 3; a++) {
                    if ((i == vampiroPosicionX[a]) && (j == vampiroPosicionY[a])) {
                        miElemento = "^^";
                    }
                }
            }
        }
        return miElemento;
    }

    static boolean personajeEnAlcance(int i, int j) {
        return (personajePosicionX + alcanceAntorcha >= i) && (personajePosicionX - alcanceAntorcha <= i)
                && (personajePosicionY + alcanceAntorcha >= j) && (personajePosicionY - alcanceAntorcha <= j);
    }

    static int movimientoDelvampiro() {

        double probabilidadMovimiento = Math.random();
        if (probabilidadMovimiento < 0.40) {
            return 1;
        } else if (probabilidadMovimiento < 0.80) {
            return -1;
        } else {
            return 0;
        }
    }

    static int nuevaPosicionX(int viejaPosicionX, int viejaPosicionY) {
        int variacion = movimientoDelvampiro();
        int nuevaPosicionX = viejaPosicionX;
        if ((viejaPosicionX + variacion >= minimoX && viejaPosicionX + variacion <= maximoX)) {
            if ((viejaPosicionX + variacion != minimoX && viejaPosicionX + variacion != maximoX)) {
                if (mapaLaberinto[viejaPosicionX + variacion][viejaPosicionY] != 1) {
                    nuevaPosicionX = viejaPosicionX + variacion;
                }
            }
        }
        return nuevaPosicionX;
    }

    static int nuevaPosicionY(int viejaPosicionX, int viejaPosicionY) {
        int variacion = movimientoDelvampiro();
        int nuevaPosicionY = viejaPosicionY;
        if ((viejaPosicionY + variacion >= minimoY && viejaPosicionY + variacion <= maximoY)) {
            if ((viejaPosicionY + variacion != minimoY && viejaPosicionY + variacion != maximoY)) {
                if (mapaLaberinto[viejaPosicionX][viejaPosicionY + variacion] != 1) {
                    nuevaPosicionY = viejaPosicionY + variacion;
                }
            }
        }
        return nuevaPosicionY;
    }

}
