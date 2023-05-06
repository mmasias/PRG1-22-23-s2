import java.util.Random;

public class retoCaracolJC {
    public static void main(String[] args) {
        int totalDepth = 20;
        int climbMorning;
        int fallNight;
        int position = (int) ((Math.random() * (20 - 10 + 1) + 10));
        int day = 0;

        String upperBorder = "[][]            [][]";
        String wall = "  [].:.:.:.:.:.:[]  ";
        String snailWall = "  []   _@)_/’   []  ";
        String waterWall = "  []~~~~~~~~~~~~[]  ";
        String lowerBorder = "  [][][][][][][][]  ";

        while (position >= 0) {

            day++;
            climbMorning = (int) (Math.random() * (5 - 1) + 1);
            fallNight = (int) (Math.random() * (2 - 0) + 1);

            if (day >= 0) {
                position = position - climbMorning + fallNight;
            }
            if (position < 0) {
                System.out.println("Saliste!");
            }
            System.out.println("Posición del caracol: " + position);

            if (day >= 10 && position < totalDepth) {
                int newPosition;
                int climbLimit = (int) (Math.random() * (3 - 1) + 1);
                newPosition = position - climbLimit;
              ;
            }

            System.out.println(" Dia: [" + day + "] /  Distancia subida: [" + climbMorning + "] / Distancia Bajada: [" + fallNight
                    + "] / Altura al final del dia: [" + position + "]");

            System.out.println(upperBorder);
            for (int depth = 0; depth <= totalDepth; depth++) {
                if (position == depth) {
                    System.out.println(snailWall + " __ " + depth);
                } else {
                    System.out.println(wall + " __ " + depth);
                }

            }
            System.out.println(lowerBorder);

        }
    }

}