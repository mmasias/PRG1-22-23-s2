public class Reto21 {

    public static void main(String[] args) {
        int dimension;
        dimension = 21;

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                (i == 11 && j == 6 || i == 10 && j == 7 || i == 12 && j == 7 ||
                i == 9 && j == 8 || i == 13 && j == 8 || i == 9 && j == 9 ||
                i == 13 && j == 9 || i == 10 && j == 10 || i == 12 && j == 10 || i == 11 && j == 11)
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}