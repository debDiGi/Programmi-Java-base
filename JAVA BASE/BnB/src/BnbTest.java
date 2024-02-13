
import java.util.Scanner;

public class BnbTest {
    
    public static void main(String[] args) {
        Bnb myBnb = new Bnb();
        Scanner input = new Scanner(System.in);
        
        boolean ancora = true;
        while (ancora) {
            System.out.println("Per inserire una prenotazione digita 'P', per cercare una prenotazione digita 'C'. Per terminare il programma digita 'X'.");
            char scelta = input.nextLine().toUpperCase().charAt(0);
            switch (scelta) {
                case 'P':
                    myBnb.prenota();
                    break;
                case 'C':
                    myBnb.cerca();
                    break;
                case 'X':
                    System.out.println("***Programma terminato***");
                    ancora=false;
                    break;
                default: System.out.println("Scelta sconosciuta.");
            }
        }
        
        input.close();
        System.exit(0);
    }
}
