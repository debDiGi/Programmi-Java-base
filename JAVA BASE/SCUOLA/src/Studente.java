import java.util.Scanner;

public class Studente extends Persona implements Certificato {
    Scanner inputNum = new Scanner(System.in);
    Scanner inputTesti = new Scanner(System.in);
    private int classe;
    private char sezione;
    String matricola;
    private int prog;
    String m1, m2;
    private int annoRilascio;
    private String medico;
    

    
    public void setAnnoNascita(int annoNascita){ 
        
        //coerenza del dato
        if (annoNascita > 1993 && annoNascita < 2017) {
            this.annoNascita=annoNascita;
        } else {
            System.out.println("Inserimento fallito.Ammessi solo studenti nati prima del 2017.");

        }

    }

    public int getAnnoNascita(){
    return annoNascita;
    }


    public void setClasse(int classe){
        boolean ancora = true;
        do {
            //coerenza del dato
            if (classe > 0 && classe < 6) {
                this.classe=classe;
                ancora = false;
            } else {
                System.out.println("Inserisci un numero da 1 a 5. Reinseriscila:");
                classe = inputNum.nextInt(); 
            }
        } while (ancora);
    }

    public int getClasse(){
        return classe;
    }
 

    public void setSezione(char sezione){
        boolean ancora = true;
        do {
            this.sezione=sezione;
            
            switch (sezione) {
                case 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P':
                    ancora=false;
                    break;
            
                default:System.out.println("Sezione inesistente. Inserisci un carattere da A a P:");
                    sezione = inputTesti.nextLine().toUpperCase().charAt(0);
                    break;
            }
        } while (ancora);
    }

    public char getSezione(){
        return sezione;
    }

    public void setProg(int prog){
        this.prog=prog;
    }

    public int getProg(){
        return prog;
    }
    

    public String genMatricola() {
        // converto l' anno in String per estrapolare le ultime 2 cifre
        String annoString = Integer.toString(getAnnoNascita());
        m1 = annoString.substring(annoString.length()-2, annoString.length());

        // aggiungo gli zeri
            if (getProg() <10){
            m2 = "00" + getProg();
        } else if (getProg() > 9 && getProg() <100){
            m2="0"+getProg();
        } else{
            m2=Integer.toString(getProg());
        }
         return matricola = m1 + m2 + sezione;
    }

    public void setAnnoRilascio(int annoRilascio){
        boolean ancora = true;

        do {
            //coerenza del dato
            if (annoRilascio > 2021 && annoRilascio < 2024) {
                this.annoRilascio=annoRilascio;
                ancora = false;
            } else {
                System.out.println("Il certificato ha valenza un anno. Inserisci una anno valido(2022/2023):");
                annoRilascio = inputNumeri.nextInt(); // sto salvando nella variabile locale non quella fuori infatti non c'è this.
            }
        } while (ancora);
    }

    public int getAnnoRilascio(){
        return annoRilascio;
    }

    public void setMedico(String medico){
        boolean ancora=true;

        do {
            if (medico.length()> 1 && medico.length()<=35) {
                this.medico=medico;
                ancora=false;
            } else {
                System.out.println("Massimo 35 caratteri, reinserisci il cognome del medico:");
                medico= inputTesti.nextLine().toUpperCase();
            }   
        } while (ancora);
    }

    public String getMedico(){
        return medico;
    }


    public void display(){
        
        System.out.println("Nome: " + getNome());
        System.out.println("Cognome: " + getCognome());
        System.out.println("Anno di nascita: " + getAnnoNascita());
        System.out.println("Classe: " + getClasse());
        System.out.println("Sezione: " + getSezione());
        System.out.println("Matricola: " + genMatricola());
        if (getAnnoRilascio()!= 0) {
        System.out.println("Anno di rilascio del certificato: " + getAnnoRilascio());
        System.out.println("Medico che ha rilasciato il certificato: " + getMedico());
        }
        System.out.println();
        
    }

}
