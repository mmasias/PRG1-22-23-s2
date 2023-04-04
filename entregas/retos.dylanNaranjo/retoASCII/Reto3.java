public class Reto3 {
    public static void main(String[] args) {
        String borde = "+---------------+";
        String espacios = "|** ** ** ** ** |";
        String espaciosInvertidos = "| ** ** ** ** **|";

        System.out.println(borde);
        for (int i = 0; i < 4; i++) {
            System.out.println(espacios);
            System.out.println(espaciosInvertidos);
        }
        System.out.println(espacios);
        System.out.println(borde);
    }

}
