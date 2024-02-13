import java.util.Scanner;

public class SocioClub implements Certificato{
    private String nome;
    private String cognome;
    private int annoRilascio;
    private String medico;

    Scanner inputNumeri = new Scanner(System.in);
    Scanner inputTesti = new Scanner(System.in);

    public void setNome(String nome){
        boolean ancora=true;

        do {
            if (nome.length()> 1 && nome.length()<=35) {
                this.nome=nome;
                ancora=false;
            } else {
                System.out.println("Massimo 35 caratteri, reinserisci il nome");
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
                System.out.println("Massimo 35 caratteri, reinserisci il cognome");
                cognome= inputTesti.nextLine().toUpperCase();
            }   
        } while (ancora);
    }

    public String getCognome(){
        return cognome;
    }

    public void setAnnoRilascio(int annoRilascio){
        boolean ancora = true;

        do {
            //coerenza del dato
            if (annoRilascio > 2021 && annoRilascio < 2024) {
                this.annoRilascio=annoRilascio;
                ancora = false;
            } else {
                System.out.println("Il certificato ha valenza un anno. Inserisci un anno valido(2022/2023):");
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
                System.out.println("Massimo 35 caratteri, reinserisci il cognome del medico");
                medico= inputTesti.nextLine().toUpperCase();
            }   
        } while (ancora);
    }

    public String getMedico(){
        return medico;
    }

    public void display(){
        
        System.out.println("Nome e cognome: " + getNome() + " " + getCognome());
        System.out.println("Anno di rilascio del certificato: " + getAnnoRilascio());
        System.out.println("Medico che ha rilasciato il certificato: " + getMedico());
        System.out.println();
    }
}
