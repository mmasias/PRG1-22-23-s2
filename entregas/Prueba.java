class Prueba {
    public static void main(String[] args) {

        int miLongitud = 10;
        int LONGITUD = miLongitud*3;

        String lineaPorImprimir;

        for (int i = 0; i < LONGITUD; i++) {
            lineaPorImprimir = "  ".repeat(LONGITUD - i) +  "[]".repeat(i * 2);
            System.out.println(lineaPorImprimir);
        }

        for (int i = 0; i < LONGITUD; i++) {
            if (i < LONGITUD / 2) {
                lineaPorImprimir ="[]".repeat(LONGITUD * 2);
            } else {
                lineaPorImprimir = "[]".repeat(LONGITUD/3*2) + "  ".repeat(LONGITUD/3*2) + "[]".repeat(LONGITUD/3*2);
            }
            System.out.println(lineaPorImprimir);
        }
        System.out.println("[]".repeat(LONGITUD * 2));
    }
}