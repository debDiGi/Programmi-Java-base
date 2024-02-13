import java.util.Scanner;

public class CinemaTest {
    public static void main(String[] args) {
        Cinema myCinema = new Cinema();
        Scanner input = new Scanner(System.in);
        System.out.println("Inserire campienza massima della sala (min 50, max 300): ");
        myCinema.setPostiDisponibili(input.nextInt());
        boolean ancora = true;
        do {
            if (myCinema.getPostiDisponibili()==0) { //se finiscono i biglietti
                ancora = false;                
            } else {
                System.out.println();
                System.out.println("Il cinema dispone di "+ myCinema.getPostiDisponibili() + " posti. Quanti biglietti vuoi acquistare?");
                System.out.println("Per concludere l'acquisto digita 0.");
                int biglietti = input.nextInt();
                if (biglietti==0) { // termino gli acquisti inserendo 0
                    ancora=false; 
                } else{ 
                    myCinema.vendi(biglietti);
                }
            }
        } while (ancora);

        System.out.println();
        System.out.println("Distribuzione dei posti:");
        System.out.print("Zona sinistra:");
        myCinema.sinistra();
        System.out.println();
        System.out.print("Zona centrale:");
        myCinema.centro();
        System.out.println();
        System.out.print("Zona destra:  ");
        myCinema.destra();
        System.out.println();
        myCinema.stampa();
        System.out.println("Acquisto Terminato.");

        input.close();
        System.exit(0);
    }
}

