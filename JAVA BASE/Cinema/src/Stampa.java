import java.util.ArrayList;

public class Stampa {
ArrayList<String> liberi = new ArrayList<>();

ArrayList<String> sinistra = new ArrayList<>();
int totZona;
int righe;
int venduti = 27;

        public void stampaZone(){
        
            
        for (int i=0; i < 10; i++){
            sinistra.add("L");
        }

        System.out.println(sinistra);

        for (int i = 0; i < totZona; i++) {
            sinistra.set(i, "O");
        }

        System.out.println(sinistra);
        
        //mi creo un ArrayList di tante "L" quanti sono i posti della sala
        
        for (int i = 0; i <= 300; i++) {
        liberi.add("L");
        }

        for( int j = 11; j < 330; j = j + 11){
            liberi.add(j,"    ");
        }
             
            for (int i = 0; i <= liberi.size(); i++) {
                if ( i%33 == 0){
                    System.out.println();
                }else {
                    System.out.print(liberi.get(i));
                }
                
            }  
        
    }

//incapsula per la stampa sala

// creo arraylist di 30 L , ogni 10 metto "     "
// stampo l'array 10 volte
// stesso partendo da 1 e così via per 10 volte
}
