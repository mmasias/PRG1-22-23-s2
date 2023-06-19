public class Reto2 {
    public static void main(String[] args) {
        String espacio = "  ";
        String asteriscos = "**";

        for (int i = 0; i < 2; i++) {
            System.out.println(espacio + asteriscos + espacio + asteriscos + espacio + asteriscos);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(espacio + espacio + asteriscos + espacio + asteriscos);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(espacio + asteriscos + espacio + asteriscos + espacio + asteriscos);
        }
    }
}
