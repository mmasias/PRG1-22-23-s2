import java.util.Random;

public class retoCaracolJC {
    public static void main(String[] args) {
        final int PROFUNDIDAD_MINIMA = -20, PROFUNDIDAD_MAXIMA = -10, ALTURA_MINIMA = 0, ALTURA_MAXIMA = 20; 
        final int MAX_SUBIDA_PRIMEROS_10_DIAS = 4, MAX_SUBIDA_DESPUES_DE_10_DIAS = 3, MAX_SUBIDA_DESPUES_DE_20_DIAS = 2;
        final int DIAS_MAXIMOS_SIN_SALIR = 50;
        final double PROBABILIDAD_COCHES = 0.35, PROBABILIDAD_LLUVIA_FUERTE = 0.05, PROBABILIDAD_LLUVIA_MEDIA = 0.1; 
        final double REDUCCION_PROFUNDIDAD_LLUVIA_FUERTE = 5;
        final int REDUCCION_PROFUNDIDAD_LLUVIA_MEDIA = 2;

        char BORDE = '[', PARED = ']', FONDO = ':';
        String CARACOL = "_@)_/'", AGUA = "~~~~", COCHE = "O-=-O";

        Random random = new Random();

        int dia;
        double profundidad;
        int altura;
        boolean vivo;
        int diasSinSalir;
        int calcularCaida = 0, calcularSubida = 0;

        //Caracol
         {
            dia = 1;
            profundidad = PROFUNDIDAD_MINIMA;
            altura = ALTURA_MINIMA;
            vivo = true;
            diasSinSalir = 0;
        }

        {
            if (!vivo) {
                return;
            }
            
            if (profundidad >= 0) {
                System.out.println("¡El caracol ha salido del pozo el día " + dia + "!");
                return;
            }

            dia++;
                diasSinSalir++;
                
                int subida = calcularSubida;
                int caida = calcularCaida;
                
                altura += subida;
                altura -= caida;
                
                if (altura < 0) {
                    altura = 0;
                } else if (altura > ALTURA_MAXIMA) {
                    altura = ALTURA_MAXIMA;
                }

                if (diasSinSalir >= DIAS_MAXIMOS_SIN_SALIR) {
                    System.out.println("El caracol ha muerto de inanición después de " + diasSinSalir + " días sin salir del pozo.");
                    vivo = false;
                    return;
                }
                
                if (random.nextDouble() < PROBABILIDAD_COCHES) {
                    System.out.println("Un coche ha aparcado cerca del pozo y ha hecho caer al caracol 2 metros el día " + dia + ".");
                    altura -= 2;
                }

        }
    }

}