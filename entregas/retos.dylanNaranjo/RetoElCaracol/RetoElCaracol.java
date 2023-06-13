public class RetoElCaracol {

    public static void main(String[] args) {
        boolean vidaCaracol = true;
        int contador = 0;
        double caida = (Math.random() * 10) + 10;
        int subida = 0;
        int bajada = 0;
        double alturaTotal = -(int) caida;
        double probabilidaddeChoche;

        for (int j = 1; j >= -20; j = j - 1) {
            if (j == (int) alturaTotal) {
                System.out.println("[]    _@)_/’    []" + j);
            } else if (j == 1) {
                System.out.println("[__]           [__]");

            } else if (j > alturaTotal) {
                System.out.println("[]:. :. :. :. :.[]" + j);

            } else if (j < alturaTotal) {
                System.out.println("[]~~~~~~~~~~~~~~[]" + j);

            }
        }
        while (vidaCaracol == true) {
            contador = contador + 1;
            probabilidaddeChoche = Math.random();
            if (contador <= 10) {
                subida = (int) (Math.random() * 3) + 1;
                bajada = (int) (Math.random() * 2);
                alturaTotal = alturaTotal + (int) subida - (int) bajada;
            } else if (contador > 10 && contador <= 20) {
                subida = (int) (Math.random() * 3);
                bajada = (int) (Math.random() * 2);
                alturaTotal = alturaTotal + (int) subida - (int) bajada;
            } else if (contador > 20 && contador < 50) {
                subida = (int) (Math.random() * 2);
                bajada = (int) (Math.random() * 2);
                alturaTotal = alturaTotal + (int) subida - (int) bajada;
            }
            System.out.println("Día " + contador + " El caracol subió " + subida + "m y bajó " + bajada + "m");
            if (probabilidaddeChoche <= 0.35) {
                alturaTotal = alturaTotal - 2;
            }

            for (int i = 1; i >= -20; i = i - 1) {
                if (probabilidaddeChoche <= 0.35 && i == 1) {
                    System.out.println("|      O-=-O     |");
                }
                if (i == (int) alturaTotal) {
                    System.out.println("[]    _@)_/’    []" + i);
                } else if (i == 1 && probabilidaddeChoche >= 0.35) {
                    System.out.println("[__]           [__]");

                } else if (i > alturaTotal) {
                    System.out.println("[]:. :. :. :. :.[]" + i);

                } else if (i < alturaTotal) {
                    System.out.println("[]~~~~~~~~~~~~~~[]" + i);

                }

            }
            System.out.println("[][][][][][][][][]");

            if (alturaTotal >= 0) {
                vidaCaracol = false;
                System.out.println("El caracol conisguió salir del pozo!");

            } else if (contador >= 50) {
                vidaCaracol = false;
                System.out.println("El caracol murió ¡GAME OVER!");
            }

        }

    }

}
