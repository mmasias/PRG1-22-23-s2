import java.util.Scanner;

public class pacman {
    public static void main(String[] args) {
        char[][] map = {
                { '1', '1', '1', '1', '1', '1', '1', '1', '1' },
                { '1', '0', '0', '0', '0', '0', '0', '0', '1' },
                { '1', '0', '1', '0', '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1', '0', '1', '0', '1' },
                { '1', '0', '0', '0', '0', '0', '0', '0', '1' },
                { '1', '1', '1', '1', '1', '1', '1', '1', '1' }
        };

        int pacmanX = 5;
        int pacmanY = 3;

        boolean finished = false;
        Scanner scanner = new Scanner(System.in);

        while (!finished) {

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (i == pacmanY && j == pacmanX) {
                        System.out.print('C');
                    } else {
                        char parser = map[i][j] == '0' ? ' ' : '#';
                        System.out.print(parser);
                    }
                }
                System.out.println();
            }

            String movement = scanner.nextLine();

            char direction = parser(movement);

            switch (direction) {
                case 'W':
                    if (map[pacmanY - 1][pacmanX] != '1') {
                        pacmanY--;
                    }
                    break;
                case 'A':
                    if (map[pacmanY][pacmanX - 1] != '1') {
                        pacmanX--;
                    }
                    break;
                case 'S':
                    if (map[pacmanY + 1][pacmanX] != '1') {
                        pacmanY++;
                    }
                    break;
                case 'D':
                    if (map[pacmanY][pacmanX + 1] != '1') {
                        pacmanX++;
                    }
                    break;
                default:
                    System.out.println("This movement is not possible.");
            }
        }

        System.out.println("Game closed.");
        scanner.close();
    }

    private static char parser(String pacman_move) {
        if (pacman_move.length() == 1) {
            char direction = Character.toUpperCase(pacman_move.charAt(0));
            if (direction == 'W' || direction == 'A' || direction == 'S' || direction == 'D') {
                return direction;
            }
        }
        return ' ';
    }
}