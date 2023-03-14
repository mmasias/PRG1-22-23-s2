public class retoArteJoseCabrera{

    public static void main(String[] args){
        String Points = "**********";
        for (int i = 0; i < 5; i++) {
            System.out.println(Points);
        }
        
        System.out.println(" ");
        
        String dash = "  ";
        String Points2 = "**";

        for (int i = 0; i < 2; i++) {
            System.out.println(dash + Points2 + dash + Points2 + dash + Points2);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(dash + Points2 + dash + Points2 + dash);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(dash + Points2 + dash + Points2 + dash + Points2);
        }
        
        System.out.println(" ");

        String lines = "+---------------+";
        String dash2 = "| ** ** ** ** **|";
        String flip = "|** ** ** ** ** |";

        System.out.println(lines);
        for (int i = 0; i < 4; i++) {
            System.out.println(dash2);
            System.out.println(flip);
        }
        System.out.println(dash2);
        System.out.println(lines);

        System.out.println(" ");

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





    




