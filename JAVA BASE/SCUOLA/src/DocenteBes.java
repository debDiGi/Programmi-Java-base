import java.util.ArrayList;
import java.util.Scanner;

public class DocenteBes extends Persona {
Scanner input = new Scanner(System.in);
ArrayList<String> studentiAssegnati;
String materia;

    public void setAnnoNascita(int annoNascita){ // qui abstract
        //coerenza del dato
        if (annoNascita > 1962 && annoNascita < 1994) {
            this.annoNascita=annoNascita;
        } else {
            System.out.println("Inserimento fallito.Ammessi solo docenti nati tra il 1963 ed il 1993.");
            
        }
    }


    public int getAnnoNascita(){
    return annoNascita;
    }


    public void setMateria(int indexMateria){
        boolean ancora=true;
        
        do {
            switch (indexMateria) {
                case 1:
                    materia = "Italiano";
                    ancora=false;
                    break;
                case 2:
                    materia = "Matematica e Fisica";
                    ancora=false;
                    break;
                case 3:
                    materia = "Inglese";
                    ancora=false;
                    break;
                case 4:
                    materia = "Storia e Filosofia";
                    ancora=false;
                    break;
                case 5:
                    materia = "Scienze";
                    ancora=false;
                    break;
                case 6:
                    materia = "Arte";
                    ancora=false;
                    break;
                case 7:
                    materia = "Educazione Fisica";
                    ancora=false;
                    break;
                default: System.out.println("Input inesistente. Inserisci l'indice dell'elenco corrispondente alla materia di insegnamento:");
                    indexMateria=input.nextInt();
                    break;
            }
            
        } while (ancora);
    }


    public String getMateria(){
        return materia;
    }


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
                System.out.println("Massimo 70 caratteri, reinserisci nome e cognome(per terminare l'inserimento digitare 'STOP'):");
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

