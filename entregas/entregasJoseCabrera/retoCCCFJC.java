import java.io.IOException;

class retoCCCFJC {

    public static void main(String[] args) throws IOException{
        
        int totalTime;
        double arrivalChance;
        int line;
        int cash1;
        int cash2;
        int cash3;
        int cash4;
        int emptyLine;
        int totalPacks;
        int totalLine;
        int packs;

        totalTime = 720;
        emptyLine = 0;
        line = 0;
        cash1 = 0;
        cash2 = 0;
        cash3 = 0;
        cash4 = 0;
        totalPacks = 0;
        totalLine = 0;
        packs = 0;

        for (int minuto = 1; minuto <= totalTime; minuto = minuto + 1) {

            System.out.println("Minuto #" + minuto);
            System.out.println(" - ");

            arrivalChance = Math.random();
            if (arrivalChance <= 0.4) {
                System.out.println("Una persona llegó ");
                line = line + 1;
                totalLine = totalLine + 1;
            } else {
                System.out.println("No ha llegado nadie ");
            }
            System.out.println(" - en cola: " + line);
            if (line == 0) {
                emptyLine = emptyLine + 1;
            }

            if (cash1 <= 0 && line > 0) {
                line = line - 1;
                packs = (int) ((Math.random() * (15 - 5)) + 5);
                totalPacks = totalPacks + packs;
                cash1 = packs;
                System.out.println("  -  Llega una persona a la primera caja con [" + cash1 + "] packs");
            }

            if (cash1 > 0) {
                cash1 = cash1 - 1;
                System.out.println("  -  La primera caja fue atendida, ahora quedan: " + cash1);

            }

            if (cash2 <= 0 && line > 0) {
                line = line - 1;
                packs = (int) ((Math.random() * (15 - 5)) + 5);
                totalPacks = totalPacks + packs;
                cash2 = packs;
                System.out.println("  -  Llega una persona a la segunda caja con [" + cash2 + "] packs");
            }

            if (cash2 > 0) {
                cash2 = cash2 - 1;
                System.out.println("  -  La segunda caja fue atendida, ahora quedan: " + cash2);

            }

            if (cash3 <= 0 && line > 0) {
                line = line - 1;
                packs = (int) ((Math.random() * (15 - 5)) + 5);
                totalPacks = totalPacks + packs;
                cash3 = packs;
                System.out.println("  -  Llega una persona a la tercera caja con [" + cash3 + "] packs");
            }

            if (cash3 > 0) {
                cash3 = cash3 - 1;
                System.out.println("  -  La tercera caja fue atendida, ahora quedan: " + cash3);

            }

            if (cash4 <= 0 && line > 0) {
                line = line - 1;
                packs = (int) ((Math.random() * (15 - 5)) + 5);
                totalPacks = totalPacks + packs;
                cash4 = packs;
                System.out.println("  -  Llega una persona a la cuarta caja con [" + cash4 + "] packs");
            }

            if (cash4 > 0) {
                cash4 = cash4 - 1;
                System.out.println("  -  La cuarta caja fue atendida, ahora quedan: " + cash4);
            
                System.out.println("En espera:" + line);
                System.out.println("  Caja #1:[Faltan " + cash1 + " packs]");
                System.out.println("  Caja #2:[Faltan " + cash2 + " packs]");
                System.out.println("  Caja #3:[Faltan " + cash3 + " packs]");
                System.out.println("  Caja #4:[Faltan " + cash4 + " packs]");
                System.out.println("----------------------------------------");
            }
            
    
            

            
        }
        System.out.println("Resumen del dia:");
            System.out.println("========================================");
            System.out.println("Minutos con la fila en 0: " + emptyLine);
            System.out.println("Personas en la fila al cierre: " + line);
            System.out.println("Personas atendidas: " + (totalLine - line));
            System.out.println("Productos vendidos: " + totalPacks);
            System.out.println("Procede a cerrar la tienda, se hace el inventario y se van todos a casa :D");


    }

}