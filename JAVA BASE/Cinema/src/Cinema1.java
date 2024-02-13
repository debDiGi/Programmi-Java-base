
import java.util.ArrayList;
import java.util.Scanner;

public class Cinema1 {
    //creo l'array dei postioccupati
    ArrayList<Integer> venduti = new ArrayList<>(); // uso un'array list in vista della seconda parte dell'esercizio.
    Scanner input = new Scanner(System.in);
    int postiDisponibili;
    int centroTot, dxTot, sxTot; // totale posti per zona
    int n; // parametro per controllare unicità degli elementi dell'ArryList, essendo popolato grazie a molteplici input.
    ArrayList<Integer> occupati = new ArrayList<>();
    ArrayList<String> liberi = new ArrayList<>();
    int postiperstampa;
    

    public void setPostiDisponibili(int postiDisponibili){
        
        boolean ancora = true;
        do {
            if (postiDisponibili > 49 && postiDisponibili <= 300){
                this.postiDisponibili=postiDisponibili;
                postiperstampa = postiDisponibili; // assegno a postiperstampa il valore dei posti disponibili inseriti prima che vengano decrementati nel ciclo per ogni acquisto.
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
            occupati.add(venduti.get(i));
        }
    } 

    public void sinistra(){
        for (int i = 1; i < venduti.size(); i= i+3) {  // potrei usare questi per l'array
            System.out.print("    " + venduti.get(i));
            sxTot++;
            occupati.add(venduti.get(i));
        }
    }

    public void destra(){
        for (int i = 2; i < venduti.size(); i= i+3) { 
            System.out.print("    " + venduti.get(i));
            dxTot++;
            occupati.add(venduti.get(i));
        }
    }

    public void stampa(){ // stampa dei totali
        System.out.println();
        System.out.println("Assegnati " + sxTot + " posti a sinistra, " +  centroTot + " posti al centro, "+ dxTot + " posti a destra; totale " + venduti.size() + " spettatori.");
    }

    
    public void stampaSala(){
        /* for (int i = 0; i < 100; i++) { //mi creo un ArrayList di tante "L" quanti sono i posti della sala
        liberi.add("L"); 
        } */
        int count = 0;
        int nFilePiene = venduti.size()/30;
        int scartoSx = sxTot%10;
        int scartoCentro = centroTot%10;
        int scartoDx = dxTot%10; 

        for (int i = 0; i < 10; i++) { //mi creo un ArrayList di tante "L" quanti sono i posti della sala
        liberi.add("L"); 
        }

        if(nFilePiene>0){
            for ( int h =0;h < nFilePiene ;h++){ // quante volte le 3 file (sx,centro e dx) sono completamente occupate(10 "O" ripetuto 3 volte)
            for (int i = 0; i < liberi.size(); i++) {
                    liberi.set(i, "O");               
                }
                for (int z = 0; z < 3; z++) {
                    for (int i = 0; i < liberi.size(); i++) {
                    System.out.print(liberi.get(i));    
                    }
                    System.err.print("  "); //spazio tra le zone
                }
                System.out.println();
                count++;   
           }

            // rimetto tutte "L"
            for (int i = 0; i < 10; i++) { // metti in un metodo
                liberi.set(i,"L"); 
            }
        }
        
        //se ci sono, stampo file parzialmente occupate

        //SINISTRA
        if (scartoSx > 0) { //   
            for ( int h = 0; h < scartoSx; h++){
                liberi.set(h, "O");               
            }

            for (int i = 0; i < liberi.size(); i++) {
                    System.out.print(liberi.get(i));
                    liberi.set(i,"L");                
                }
                System.out.print("  ");
        } else {
            for (int i = 0; i < liberi.size(); i++) {
                    System.out.print(liberi.get(i));                
                }
                
                System.out.println();
        }

        //CENTRO
        if (scartoCentro > 0) {    
            for ( int h =0;h<scartoCentro;h++){
                liberi.set(h, "O");               
                
            }
            for (int i = 0; i < liberi.size(); i++) {
                    System.out.print(liberi.get(i));
                    liberi.set(i,"L");                
                }
                count++;
                System.out.print("  ");
        }


        //DESTRA
        if (scartoDx > 0) {  
            for ( int h = 0; h < scartoDx; h++){ // perchè stampa lo stesso numero di "O" della fila centrale e sinistra?
                liberi.set(h, "O");                  
            }
            for (int i = 0; i < liberi.size(); i++) {
                    System.out.print(liberi.get(i));                
                }
                
                System.out.println();
        } else {
            for (int i = 0; i < liberi.size(); i++) {
                    System.out.print(liberi.get(i));                
                }
                
                System.out.println();
        }


        for (int i = 0; i < 10; i++) {  // resetto array alla condizione di partenza(con tutte "L") 
                liberi.set(i,"L"); 
        }

        
        for (int i = 0; i < (10-count); i++) { // stampo le file che restano interamente libere
            for (int z = 0; z < 3; z++) {
               for (int j = 0 ; j<10; j++){
                System.out.print(liberi.get(j));
                }
                System.out.print("  "); // spazio tra le zone
            }
            System.out.println();
            
        }

        


        // faccio metodi separati per ogni step e posso differenziare le zone usando metodi parametrici generics vedi Generics.java



        
        /* while (sxTot>0 && dxTot >0 && centroTot>0) {

            for (int i = 0; i < sxTot; i++) {
                    liberi.set(i, "O");               
                }
                

            for (int i = 0; i < 10; i++) {
                System.out.print(liberi.get(i));
            }
            System.out.print("  ");
            /* System.out.println();
            sxTot = sxTot-10;
            for (int i = 0; i < 10; i++) {
                liberi.set(i,"L");
            } */
            
            
           /* for (int i = 0; i < centroTot; i++) {
                    liberi.set(i, "O");               
                }
                

            for (int i = 0; i < 10; i++) {
                System.out.print(liberi.get(i));
            }
            System.out.print("  ");           
            


            for (int i = 0; i < dxTot; i++) {
                    liberi.set(i, "O"); 
                System.out.print(dxTot);                  
                }
                dxTot=dxTot-11;

            for (int i = 0; i < 10; i++) {
                System.out.print(liberi.get(i));
            }
            System.out.print("  "); 

            System.out.println();
            sxTot = sxTot-10;
            for (int i = 0; i < 10; i++) {
                liberi.set(i,"L");
            }
            
            centroTot = centroTot-10;
            for (int i = 0; i < 10; i++) {
                liberi.set(i,"L");
            }
            
            //dxTot = dxTot-10;
            for (int i = 0; i < 10; i++) {
                liberi.set(i,"L");
            }
                
        }     */
                       
                //System.out.println();                
                
            
        }





        

        
    }
        
        
        
