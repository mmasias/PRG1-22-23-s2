import java.util.Scanner;

public class retoPacManFinal {
    public static void main(String[] args) {
        char[][] mapa = {
                { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
                { '1', '0', '0', '0', '0', '0', '0', '0', '0', '1' },
                { '1', '0', '1', '1', '1', '1', '1', '1', '0', '1' },
                { '1', '0', '1', '0', '0', '0', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1', '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1', '1', '0', '1', '0', '1' },
                { '1', '0', '0', '0', '0', '0', '0', '0', '0', '1' },
                { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' }
        };

        int pacmanX = 5;
        int pacmanY = 3;

        boolean terminado = false;
        Scanner scanner = new Scanner(System.in);

        while (!terminado) {

            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (i == pacmanY && j == pacmanX) {
                        System.out.print('C');
                    } else {
                        char c = mapa[i][j] == '0' ? '-' : '*';
                        System.out.print(c);
                    }
                }
                System.out.println();
            }

            System.out.print("Ingrese un movimiento (W/A/S/D): ");
            String movimiento = scanner.nextLine();

            char direccion = parsearMovimiento(movimiento);

            switch (direccion) {
                case 'W':
                    if (mapa[pacmanY - 1][pacmanX] != '1') {
                        mapa[pacmanY][pacmanX] = '0';
                        pacmanY--;
                    }
                    break;
                case 'A':
                    if (mapa[pacmanY][pacmanX - 1] != '1') {
                        mapa[pacmanY][pacmanX] = '0';
                        pacmanX--;
                    }
                    break;
                case 'S':
                    if (mapa[pacmanY + 1][pacmanX] != '1') {
                        mapa[pacmanY][pacmanX] = '0';
                        pacmanY++;
                    }
                    break;
                case 'D':
                    if (mapa[pacmanY][pacmanX + 1] != '1') {
                        mapa[pacmanY][pacmanX] = '0';
                        pacmanX++;
                    }
                    break;
                default:
                    System.out.println("Movimiento inválido.");
            }

            int movimientosRestantes = 10;
            movimientosRestantes--;
            if (movimientosRestantes <= 0) {
                terminado = true;
            }
        }

        System.out.println("Juego terminado.");
        scanner.close();
    }

    private static char parsearMovimiento(String movimiento) {
        if (movimiento.length() == 1) {
            char direccion = Character.toUpperCase(movimiento.charAt(0));
            if (direccion == 'W' || direccion == 'A' || direccion == 'S' || direccion == 'D') {
                return direccion;
            }
        }
        return ' ';
    }
}
