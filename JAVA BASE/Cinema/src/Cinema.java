import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
    //creo l'array dei posti occupati
    ArrayList<Integer> venduti = new ArrayList<>(); // uso un'array list in vista della seconda parte dell'esercizio.
    Scanner input = new Scanner(System.in);
    int postiDisponibili;
    int centroTot, dxTot, sxTot; // totale posti per zona
    int n; // parametro per controllare unicità degli elementi dell'ArryList, essendo popolato grazie a molteplici input.
    
    public void setPostiDisponibili(int postiDisponibili){
        
        boolean ancora = true;
        do {
            if (postiDisponibili > 49 && postiDisponibili <= 300){
                this.postiDisponibili=postiDisponibili;
                ancora = false;
            }else{
                System.out.println("Per favore, inserisci un valore compreso tra 50 e 300:");
                postiDisponibili = input.nextInt();
            }
        } while (ancora);
    }
    public int getPostiDisponibili(){ // per stampare i posti disponibili dal main
        return postiDisponibili;
    }

    public void vendi(int biglietti){
        boolean ancora = true;     
            do{
                if(biglietti < 0 ){
                        System.out.println("Per favore, immetti un numero positivo. Per terminare gli acquisti digita 0.");
                        biglietti = input.nextInt();
                }else if (biglietti > 0){
                    for (int i=1; i <= biglietti; i++){ // uso l'input per settare la durata del ciclo
                        venduti.add(n+i);// tengo memoria dell ultimo valore inserito nel ciclo precedente(vedi ln 52.)
                        ancora = false;
                        postiDisponibili--;
                         // decremento i posti disponibili per verificare capienza massima
                        
                        if (postiDisponibili == 0) {
                            System.out.println("Capienza massima raggiunta.");
                            break;
                        } 
                    }
                    n=n+biglietti; // sommo a n il num di biglietti venduti così che con gli input consecutivi non ci siano doppioni di int nell'arraylist 
                }
            } while(ancora);
    }

    // distribuisco i posti sfruttando le posizioni nell'array
    public void centro(){
        for (int i = 0; i < venduti.size(); i= i+3) { 
            System.out.print("    " + venduti.get(i));
            centroTot++;
        }
    } 

    public void sinistra(){
        for (int i = 1; i < venduti.size(); i= i+3) { 
            System.out.print("    " + venduti.get(i));
            sxTot++;
        }
    }

    public void destra(){
        for (int i = 2; i < venduti.size(); i= i+3) { 
            System.out.print("    " + venduti.get(i));
            dxTot++;
        }
    }

    public void stampa(){ // stampa dei totali
        System.out.println();
        System.out.println("Assegnati " + sxTot + " posti a sinistra, " +  centroTot + " posti al centro, "+ dxTot + " posti a destra; totale " + venduti.size() + " spettatori.");
    }

}

// disegna nel terminale le tre zone con i posti occupati 'O' e liberi 'L'
