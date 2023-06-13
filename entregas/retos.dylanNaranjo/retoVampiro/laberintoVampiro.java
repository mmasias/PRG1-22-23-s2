import java.util.Scanner;

class laberintoAntorcha {

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
    static int alcanceAntorcha;
    static int vampiroPosicionX;
    static int vampiroPosicionY;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        personajePosicionX = 0;
        personajePosicionY = 2;
        minimoX = 0;
        minimoY = 0;
        maximoX = mapaLaberinto.length - 1;
        maximoY = mapaLaberinto[0].length - 1;
        vampiroPosicionX = 0;
        vampiroPosicionY = 8;
        alcanceAntorcha = 100;

        boolean caminando = true;
        String accion;
        bienvenidaAlPrograma();

        while (caminando) {
            comandosDelPrograma();
            System.out.print("Ingrese comando: ");
            accion = entrada.nextLine();
            if (accion.length() > 1) {
                accion = accion.substring(0, 1);
            }

            vampiroPosicionX = nuevaPosicionX(vampiroPosicionX, vampiroPosicionY);
            vampiroPosicionY = nuevaPosicionY(vampiroPosicionX, vampiroPosicionY);

            switch (accion) {
                case "w":
                    arriba();
                    imprimeLaberinto();
                    break;
                case "s":
                    abajo();
                    imprimeLaberinto();
                    break;
                case "d":
                    derecha();
                    imprimeLaberinto();
                    break;
                case "a":
                    izquierda();
                    imprimeLaberinto();
                    break;
                case "f":
                    caminando = false;
                    break;
                default:
                    errorComando();
                    imprimeLaberinto();
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
        System.out.println("[w] Arriba, [s] Abajo, [a] Izquierda, [d] Derecha, [f] Fin del Juego.");
    }

    static void imprimeLaberinto() {
        System.out.println();
        System.out.println("+----------------------------------------------------------+");
        for (int i = 0; i < mapaLaberinto.length; i++) {
            System.out.print("|");
            for (int j = 0; j < mapaLaberinto[i].length; j++) {
                if ((i == personajePosicionX) && (j == personajePosicionY)) {
                    System.out.print("IJ");
                } else {
                    if ((personajePosicionX + alcanceAntorcha >= i) && (personajePosicionX - alcanceAntorcha <= i)
                            && (personajePosicionY + alcanceAntorcha >= j)
                            && (personajePosicionY - alcanceAntorcha <= j)) {
                        if ((i == vampiroPosicionX) && (j == vampiroPosicionY)) {
                            System.out.print("^^");
                        } else if (mapaLaberinto[i][j] == 1) {
                            System.out.print("[]");
                        } else {
                            System.out.print("  ");
                        }
                        ;
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("+----------------------------------------------------------+");
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
