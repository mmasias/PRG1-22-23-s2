<<<<<<< HEAD
=======
import java.util.Scanner;

public class laberintoFinal {

    static int[][] labyrinth = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
        {0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
        {0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    static int spotX, spotY;
    static int limIX, limIY, limSX, limSY;
    static int torchRange = 3;
    static int[] vampSpotX = { 10, 6, 4 }, vampSpotY = { 22, 4, 14 };

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        spotX = 0;
        spotY = 0;

        limIX = 0;
        limIY = 0;
        limSX = labyrinth.length - 1;
        limSY = labyrinth[0].length - 1;

        boolean walk = true;
        String accion;
        impLab();

        while (walk) {
            commands();
            System.out.print("Ingrese comando: ");
            accion = entrada.nextLine();

            for (int v = 0; v < 3; v++) {
                vampSpotX[v] = newSpotX(vampSpotX[v], vampSpotY[v]);
                vampSpotY[v] = newSpotY(vampSpotX[v], vampSpotY[v]);
            }

            if (accion.equals("w")) {
                mover("north");
            } else if (accion.equals("s")) {
                mover("south");
            } else if (accion.equals("a")) {
                mover("west");
            } else if (accion.equals("d")) {
                mover("east");
            } else if (accion.equals("f")) {
                walk = false;
            } else {
                System.out.println(
                        "Movimiento no reconocido, intente con un valor valido.");
            }
            impLab();
        }
    }


    static void mover(String directions) {
        switch (directions) {
            case "east":
                if ((spotY > limIY) && (labyrinth[spotX][spotY - 1] != 1)) {
                    spotY = spotY - 1;
                } else {
                    System.out.print("Eso es un muro... ");
                }
                break;
            case "west":

                if ((spotY < limSY) && (labyrinth[spotX][spotY + 1] != 1)) {
                    spotY = spotY + 1;
                } else {
                    System.out.print("No puedes atravesar paredes... aun. ");
                }
                break;
            case "south":
                if ((spotX < limSX) && (labyrinth[spotX + 1][spotY] != 1)) {
                    spotX = spotX + 1;
                } else {
                    System.out.print("Te vas a lastimar si sigues asi. ");
                }
                break;
            case "north":
                if ((spotX > limIX) && (labyrinth[spotX - 1][spotY] != 1)) {
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

    static void impLab() {

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
                        

                }
                System.out.print(factor);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("+----------------------------------------------------------+");
    }

    static void vampire(){
        for (int v = 0; v < 3; v = v + 1) {
            if ((i == vampSpotX[v]) && (j == vampSpotY[v])) {
                factor = "^^";
            }
        }
             } else {
                factor = "  ";
          }
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
            if ((oldSpotX != limIX) && (oldSpotX != limSX)) {
                if (labyrinth[oldSpotX + 1][oldSpotY] != 1) {
                    newSpotX = oldSpotX + 1;
                }
            }
        } else if (variable == -1) {
            if ((oldSpotX != limIX) && (oldSpotX != limSX)) {
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
            if ((oldSpotY != limIY) && (oldSpotY != limSY)) {
                if (labyrinth[oldSpotX][oldSpotY + 1] != 1) {
                    newSpotY = oldSpotY + 1;
                }
            }
        } else if (variable == -1) {
            if ((oldSpotY != limIY) && (oldSpotY != limSY)) {
                if (labyrinth[oldSpotX][oldSpotY - 1] != 1) {
                    newSpotY = oldSpotY - 1;
                }
            }
        }

        return newSpotY;
    }

}
>>>>>>> e914956d44f52271ed7bad890efa4046c4b15a4b
