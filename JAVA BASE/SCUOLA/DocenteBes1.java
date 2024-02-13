import java.util.ArrayList;

public class DocenteBes extends Docente {
 // list di list di string
ArrayList<String> studentiAssegnati;

    public void setLista(){
        studentiAssegnati = new ArrayList<>();
    }

    public void aggiungiStudenti(String nuovoAssegnato){
        boolean ancora=true;        
        
        do {
            if (nuovoAssegnato.length()> 3 && nuovoAssegnato.length()<=70) {
                if (nuovoAssegnato.equals("STOP")) { 
                    studentiAssegnati.remove("STOP");
                 }else{ studentiAssegnati.add(nuovoAssegnato);
                }
                ancora=false;
            }else {
                System.out.println("Massimo 70 caratteri, reinserisci nome e cognome:");
                nuovoAssegnato= inputTesti.nextLine().toUpperCase();
            } 
        } while (ancora);
    }
 
    public ArrayList<String> getListaStudenti(){     
        
        return studentiAssegnati;
    }


    public void display(){
        System.out.println("Nome: " + getNome());
        System.out.println("Cognome: " + getCognome());
        System.out.println("Anno di nascita: " + getAnnoNascita());
        System.out.println("Materia: " + getMateria());
        System.out.println("Docente BES dei seguenti Studenti BES: ");
        for (String studente : studentiAssegnati) {
            System.out.println("- " + studente);
        };
        System.out.println();
        
    } 

}

