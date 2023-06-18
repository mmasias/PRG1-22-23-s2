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

    static int spotX, spotY;
    static int limitInferiorX, limitInferiorY, limitSuperiorX, limitSuperiorY;
    static int torchRange = 3;
    static int[] vampSpotX = { 10, 6, 4 }, vampSpotY = { 22, 4, 14 };

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            spotX = 0;
            spotY = 0;

            limitInferiorX = 0;
            limitInferiorY = 0;
            limitSuperiorX = labyrinth.length - 1;
            limitSuperiorY = labyrinth[0].length - 1;

            boolean walk = true;
            String accion;
            printLab();

            while (walk) {
                commands();
                System.out.print("Ingrese comando: ");
                accion = entrada.nextLine();

                for (int v = 0; v < 3; v++) {
                    vampSpotX[v] = newSpotX(vampSpotX[v], vampSpotY[v]);
                    vampSpotY[v] = newSpotY(vampSpotX[v], vampSpotY[v]);
                }

                cleanConsole();

                if (accion.equals("w")) {
                    mover("north");
                } else if (accion.equals("s")) {
                    mover("south");
                } else if (accion.equals("a")) {
                    mover("east");
                } else if (accion.equals("d")) {
                    mover("west");
                } else if (accion.equals("f")) {
                    walk = false;
                } else {
                    System.out.println(
                            "Movimiento no reconocido, intente con un valor valido.");
                }
                printLab();
            }
        } finally {
            entrada.close();
        }
    }

    static void mover(String directions) {
        switch (directions) {
            case "east":
                if ((spotY > limitInferiorY) && (labyrinth[spotX][spotY - 1] != 1)) {
                    spotY = spotY - 1;
                } else {
                    System.out.print("Eso es un muro... ");
                }
                break;
            case "west":

                if ((spotY < limitSuperiorY) && (labyrinth[spotX][spotY + 1] != 1)) {
                    spotY = spotY + 1;
                } else {
                    System.out.print("No puedes atravesar paredes... aun. ");
                }
                break;
            case "south":
                if ((spotX < limitSuperiorX) && (labyrinth[spotX + 1][spotY] != 1)) {
                    spotX = spotX + 1;
                } else {
                    System.out.print("Te vas a lastimar si sigues asi. ");
                }
                break;
            case "north":
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
    }

    static void commands() {
        System.out.println("Comandos: [w]=Norte,[s]=Sur,[a]=Este,[d]=Oeste,[f]=Finalizar tu viaje");
    }

    static void printLab() {

        String factor = "";
        System.out.println("");
        System.out.println("+----------------------------------------------------------+");
        for (int i = 0; i < (labyrinth.length); i++) {
            System.out.print("|");
            for (int j = 0; j < (labyrinth[i].length); j++) {
                factor = "  ";
                if ((i == spotX) && (j == spotY)) {
                    factor = "HM";
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
            Syste

    
        }       

    Sse.u.pitf    if ((i = 

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

    static int newSpotX(int oldSpotX, int oldSpotY) {
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

    static int newSpotY(int oldSpotX, int oldSpotY) {
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