package entregas;

class retoForIf {
    public static void main(String[] args) {
        int dimension;
        dimension = 21;

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                    ( i + j  == 4 || i + j  == 8 ||  i + j  == 12 ||  i + j  == 16 ||  i + j  == 20
                                    || i + j  == 24 || i + j  == 28 || i + j  == 32 || i + j  == 36 || i + j  == 39 )
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
            System.out.println();
        }
    }
