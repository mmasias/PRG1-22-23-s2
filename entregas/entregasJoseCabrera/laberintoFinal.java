import java.util.Scanner;

public class laberintoFinal {

    static int[][] labyrinth = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
            { 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
            { 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };

    static void cleanConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static int[] vampSpotX = { 10, 6, 4 }, vampSpotY = { 22, 4, 14 };

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean walk = true;
        String accion;

        int spotX = 0, limitInferiorX = 0, limitSuperiorX = labyrinth.length - 1;
        ;
        int spotY = 0, limitInferiorY = 0, limitSuperiorY = labyrinth[0].length - 1;

        printLabyrinth(spotX, spotY);

        while (walk) {
            commands();
            System.out.print("Ingrese comando: ");
            accion = entrada.nextLine();

            for (int v = 0; v < 3; v++) {
                vampSpotX[v] = newSpotX(vampSpotX[v], vampSpotY[v], limitInferiorX, limitSuperiorX);
                vampSpotY[v] = newSpotY(vampSpotX[v], vampSpotY[v], limitInferiorY, limitSuperiorY);
            }

            cleanConsole();

            if (accion.equals("w")) {
                spotX = moverX("norte", spotX, spotY, limitInferiorX, limitSuperiorX);
            } else if (accion.equals("s")) {
                spotX = moverX("sur", spotX, spotY, limitInferiorX, limitSuperiorX);
            } else if (accion.equals("a")) {
                spotY = moverY("este", spotX, spotY, limitInferiorY, limitSuperiorY);
            } else if (accion.equals("d")) {
                spotY = moverY("oeste", spotX, spotY, limitInferiorY, limitSuperiorY);
            } else if (accion.equals("f")) {
                walk = false;
            } else {
                System.out.println("Movimiento no reconocido, intente con un valor valido.");
            }
            printLabyrinth(spotX, spotY);
        }
        printLabyrinth(spotX, spotY);

        entrada.close();
    }

    static int moverX(String directions, int spotX, int spotY, int limitInferiorX, int limitSuperiorX) {
        switch (directions) {
            case "sur":
                if ((spotX < limitSuperiorX) && (labyrinth[spotX + 1][spotY] != 1)) {
                    spotX = spotX + 1;
                } else {
                    System.out.print("Te vas a lastimar si sigues asi. ");
                }
                break;
            case "norte":
                if ((spotX > limitInferiorX) && (labyrinth[spotX - 1][spotY] != 1)) {
                    spotX = spotX - 1;
                } else {
                    System.out.print("Por ahi no es. ");
                }
                break;
            default:
                System.out.print("Dirección no válida");
                break;
        }
        return spotX;
    }

    static int moverY(String directions, int spotX, int spotY, int limitInferiorY, int limitSuperiorY) {
        switch (directions) {
            case "este":
                if ((spotY > limitInferiorY) && (labyrinth[spotX][spotY - 1] != 1)) {
                    spotY = spotY - 1;
                } else {
                    System.out.print("Eso es un muro... ");
                }
                break;
            case "oeste":
                if ((spotY < limitSuperiorY) && (labyrinth[spotX][spotY + 1] != 1)) {
                    spotY = spotY + 1;
                } else {
                    System.out.print("No puedes atravesar paredes... aun. ");
                }
                break;
            default:
                System.out.print("Dirección no válida");
                break;
        }
        return spotY;
    }

    static void commands() {
        System.out.println("Comandos: [w]=Norte,[s]=Sur,[a]=Este,[d]=Oeste,[f]=Finalizar tu viaje");
    }

    static void printLabyrinth(int spotX, int spotY) {
        int torchRange = 3;
        String factor = "";

        System.out.println("");
        System.out.println("+----------------------------------------------------------+");
        for (int i = 0; i < (labyrinth.length); i++) {
            System.out.print("|");
            for (int j = 0; j < (labyrinth[i].length); j++) {
                factor = "  ";
                if ((i == spotX) && (j == spotY)) {
                    factor = "<>";
                } else {

                    if ((spotX + torchRange >= i) && (spotX - torchRange <= i) && (spotY + torchRange >= j)
                            && (spotY - torchRange <= j)) {
                        if (labyrinth[i][j] == 1) {
                            factor = "[]";
                        } else if (labyrinth[i][j] == 2) {
                            factor = "/|";
                        } else if (labyrinth[i][j] == 5) {
                            factor = "/\\";
                        } else if (labyrinth[i][j] == 9) {
                            factor = "O-";
                        } else {
                            factor = "··";
                        }
                        factor = vampire(i, j, factor);
                    } else {
                        factor = "  ";
                    }

                }
                System.out.print(factor);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("+----------------------------------------------------------+");
    }

    static String vampire(int i, int j, String vamp) {
        for (int v = 0; v < 3; v++) {
            if ((i == vampSpotX[v]) && (j == vampSpotY[v])) {
                vamp = "^^";
            }
        }
        return vamp;
    }

    static int movement() {
        double movementChance = Math.random();
        if (movementChance < 0.40) {
            return 1;
        } else if (movementChance < 0.80) {
            return -1;
        } else {
            return 0;
        }
    }

    static int newSpotX(int oldSpotX, int oldSpotY, int limitInferiorX, int limitSuperiorX) {
        int variable = movement();
        int newSpotX = oldSpotX;

        if (variable == 1) {
            if ((oldSpotX != limitInferiorX) && (oldSpotX != limitSuperiorX)) {
                if (labyrinth[oldSpotX + 1][oldSpotY] != 1) {
                    newSpotX = oldSpotX + 1;
                }
            }
        } else if (variable == -1) {
            if ((oldSpotX != limitInferiorX) && (oldSpotX != limitSuperiorX)) {
                if (labyrinth[oldSpotX - 1][oldSpotY] != 1) {
                    newSpotX = oldSpotX - 1;
                }
            }
        }
        return newSpotX;
    }

    static int newSpotY(int oldSpotX, int oldSpotY, int limitInferiorY, int limitSuperiorY) {
        int variable = movement();
        int newSpotY = oldSpotY;

        if (variable == 1) {
            if ((oldSpotY != limitInferiorY) && (oldSpotY != limitSuperiorY)) {
                if (labyrinth[oldSpotX][oldSpotY + 1] != 1) {
                    newSpotY = oldSpotY + 1;
                }
            }
        } else if (variable == -1) {
            if ((oldSpotY != limitInferiorY) && (oldSpotY != limitSuperiorY)) {
                if (labyrinth[oldSpotX][oldSpotY - 1] != 1) {
                    newSpotY = oldSpotY - 1;
                }
            }
        }
        return newSpotY;
    }
}