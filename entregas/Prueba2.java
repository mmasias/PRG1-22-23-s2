package entregas;

class Prueba2 {
    public static void main(String[] args){

        String PATRON_X = "X".repeat(2);
        String PATRON_O = "_".repeat(2);

        String lineaPorImprimir;

        for (int i=0;i<10;i++) {
            if (i%2==0) {
                lineaPorImprimir = PATRON_X + PATRON_O;
            } else {
                lineaPorImprimir = PATRON_O + PATRON_X;
            }
            lineaPorImprimir = lineaPorImprimir.repeat(5);
            System.out.println(lineaPorImprimir);
        }

        

    }    
}
