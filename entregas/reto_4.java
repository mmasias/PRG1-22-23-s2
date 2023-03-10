public class reto_4 {
    public static void main(String[] args) {
        int linecount = 0;
        
        for (int i = 1; i <= 10; i++) {
            if (i < 5) {
                for (int j = 1; j <= 10 - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= 2 * i - 1; k++) {
                    System.out.print("*");
                }
                System.out.println();
                linecount++;

            }

            else {
                for (int x = 0; x <= 5; x++) {

                    for (int j = 1; j <= 10 - i; j++) {
                        System.out.print(" ");
                    }
                    for (int k = 1; k <= 2 * i - 1; k++) {
                        System.out.print("*");
                    }
                    System.out.println();
                    linecount++;
                }

            }

            if (linecount >= 10) {
                break;
            }

        }
    }
}
