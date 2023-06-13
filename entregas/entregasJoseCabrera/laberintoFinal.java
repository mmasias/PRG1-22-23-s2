import java.util.Scanner;

public class elLaberintoVs {

    static int[][] elLaberinto = {
            { 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
            { 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
            { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0 },
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

    static int posX, posY;
    static int minX, minY, maxX, maxY;
    static int alcanceAntorcha = 3;
    static int[] vampiroPosX = { 10, 6, 4 }, vampiroPosY = { 22, 4, 14 };

    // Cambios bien pequeños le hice al main no son tan grandes
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        posX = 0;
        posY = 0;

        minX = 0;
        minY = 0;
        maxX = elLaberinto.length - 1;
        maxY = elLaberinto[0].length - 1;

        boolean caminando = true;
        String accion;
        laIntro();
        impLab();

        while (caminando) {
            losComandos();
            System.out.print("Ingrese comando: ");
            accion = entrada.nextLine();

            for (int v = 0; v < 3; v++) {
                vampiroPosX[v] = nuevaPosX(vampiroPosX[v], vampiroPosY[v]);
                vampiroPosY[v] = nuevaPosY(vampiroPosX[v], vampiroPosY[v]);
            }

            if (accion.equals("w")) {
                mover("norte");
            } else if (accion.equals("s")) {
                mover("sur");
            } else if (accion.equals("d")) {
                mover("oeste");
            } else if (accion.equals("a")) {
                mover("este");
            } else if (accion.equals("f")) {
                caminando = false;
            } else {
                System.out.println(
                        "Entrada inválida! Usar las siguientes entradas:\n[w]Norte,[s]Sur,[a]Oeste,[d]Este,[f]Fin");
            }
            impLab();
        }
    }

    // Movimientos cambie poco la logica solo hice que todo estubiera en una sola
    // funcion)
    static void mover(String direccion) {
        switch (direccion) {
            case "este":
                if ((posY > minY) && (elLaberinto[posX][posY - 1] != 1)) {
                    posY = posY - 1;
                    System.out.print("Caminas hacia el oeste...");
                } else {
                    System.out.print("No puedes ir más allá! ");
                }
                break;
            case "oeste":

                if ((posY < maxY) && (elLaberinto[posX][posY + 1] != 1)) {
                    posY = posY + 1;
                    System.out.print("Caminas hacia el este...");
                } else {
                    System.out.print("No puedes ir más allá! ");
                }
                break;
            case "sur":
                if ((posX < maxX) && (elLaberinto[posX + 1][posY] != 1)) {
                    posX = posX + 1;
                    System.out.print("Caminas hacia el sur...");
                } else {
                    System.out.print("No puedes ir más allá! ");
                }
                break;
            case "norte":
                if ((posX > minX) && (elLaberinto[posX - 1][posY] != 1)) {
                    posX = posX - 1;
                    System.out.print("Caminas hacia el norte...");
                } else {
                    System.out.print("No puedes ir más allá! ");
                }
                break;
            default:
                System.out.print("Dirección no válida");
                break;
        }
    }

    // Mensajes generales (Pues solo son mensajes cambialos a lo que vos queras)
    static void laIntro() {
        System.out.print("Despiertas en medio de un laberinto. Empiezas a caminar...");
    }

    static void losComandos() {
        System.out.println("Comandos: [w]Norte,[s]Sur,[a]Este,[d]Oeste,[f]Fin");
    }

    // Imprimir laberinto (casi nada de cambios)
    static void impLab() {

        String miElemento = "";
        System.out.println("");
        System.out.println("+----------------------------------------------------------+");
        for (int i = 0; i < (elLaberinto.length); i++) {
            System.out.print("|");
            for (int j = 0; j < (elLaberinto[i].length); j++) {
                miElemento = "  ";
                if ((i == posX) && (j == posY)) {
                    miElemento = "HM";
                } else {

                    if ((posX + alcanceAntorcha >= i) && (posX - alcanceAntorcha <= i) && (posY + alcanceAntorcha >= j)
                            && (posY - alcanceAntorcha <= j)) {
                        if (elLaberinto[i][j] == 1) {
                            miElemento = "[]";
                        } else if (elLaberinto[i][j] == 2) {
                            miElemento = "/|";
                        } else if (elLaberinto[i][j] == 5) {
                            miElemento = "/\\";
                        } else if (elLaberinto[i][j] == 9) {
                            miElemento = "O-";
                        } else {
                            miElemento = "··";
                        }
                        ;
                        for (int v = 0; v < 3; v = v + 1) {
                            if ((i == vampiroPosX[v]) && (j == vampiroPosY[v])) {
                                miElemento = "^^";
                            }
                        }
                    } else {
                        miElemento = "  ";
                    }

                }
                System.out.print(miElemento);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("+----------------------------------------------------------+");
    }

    /*
     * Movimientos (no toque movimiento porque
     * no le entendia a el proposito pero para
     * nuevaPos X y Y si hice arios cambios
     * validaciones mas que nada
     */

    static int movimiento() {
        double probabilidadMovimiento = Math.random();
        if (probabilidadMovimiento < 0.40) {
            return 1;
        } else if (probabilidadMovimiento < 0.80) {
            return -1;
        } else {
            return 0;
        }
    }

    static int nuevaPosX(int oldPosX, int oldPosY) {
        int variacion = movimiento();
        int newPosX = oldPosX;

        if (variacion == 1) {
            if ((oldPosX != minX) && (oldPosX != maxX)) {
                if (elLaberinto[oldPosX + 1][oldPosY] != 1) {
                    newPosX = oldPosX + 1;
                }
            }
        } else if (variacion == -1) {
            if ((oldPosX != minX) && (oldPosX != maxX)) {
                if (elLaberinto[oldPosX - 1][oldPosY] != 1) {
                    newPosX = oldPosX - 1;
                }
            }
        }

        return newPosX;
    }

    static int nuevaPosY(int oldPosX, int oldPosY) {
        int variacion = movimiento();
        int newPosY = oldPosY;

        if (variacion == 1) {
            if ((oldPosY != minY) && (oldPosY != maxY)) {
                if (elLaberinto[oldPosX][oldPosY + 1] != 1) {
                    newPosY = oldPosY + 1;
                }
            }
        } else if (variacion == -1) {
            if ((oldPosY != minY) && (oldPosY != maxY)) {
                if (elLaberinto[oldPosX][oldPosY - 1] != 1) {
                    newPosY = oldPosY - 1;
                }
            }
        }

        return newPosY;
    }

}