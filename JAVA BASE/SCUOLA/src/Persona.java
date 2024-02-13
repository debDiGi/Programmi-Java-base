import java.util.Scanner;

public abstract class Persona {
    private String nome;
    private String cognome;
    protected int annoNascita;

    Scanner inputNumeri = new Scanner(System.in);
    Scanner inputTesti = new Scanner(System.in);

    public void setNome(String nome){
        boolean ancora=true;

        do {
            if (nome.length()> 1 && nome.length()<=35) {
                this.nome=nome;
                ancora=false;
            } else {
                System.out.println("Massimo 35 caratteri, reinserisci il nome:");
                nome= inputTesti.nextLine().toUpperCase();
            }   
        } while (ancora);
    }

    public String getNome(){
        return nome;
    }

    public void setCognome(String cognome){
        boolean ancora=true;

        do {
            if (cognome.length()> 1 && cognome.length()<=35) {
                this.cognome=cognome;
                ancora=false;
            } else {
                System.out.println("Massimo 35 caratteri, reinserisci il cognome:");
                cognome= inputTesti.nextLine().toUpperCase();
            }   
        } while (ancora);
    }

    public String getCognome(){
        return cognome;
    }


    public abstract int getAnnoNascita();
    

    public abstract void setAnnoNascita(int annoNascita);
    
}
