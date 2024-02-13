import java.util.Scanner;

public class Pubblicazione { 
    private String nome;
    private int ricevute, vendute, aggio; 
    private double prezzo;
    double guadagno;

    Scanner inputNumeri = new Scanner(System.in);
    Scanner inputTesti = new Scanner(System.in);

    public void setNome(String nome){
        
        boolean ancora=true;

        do {
            if (nome.length()>3 && nome.length()<50) { // regola lunghezza nome 
                this.nome=nome;

                ancora=false;
            } else {
                System.out.println("Il nome della pubblicazione deve essere di almeno 4 e massimo 50 caratteri, reinseriscilo");
                nome= inputTesti.nextLine().toUpperCase().trim();
            }   
        } while (ancora);
    }
    
    public String getNome(){
        return nome;
    }


    public void setRicevute(int ricevute){
        boolean ancora = true;

        do {
            if (ricevute >= getVendute() && ricevute < 101){ // regola: massimo 100 copie per pubblicazione
                this.ricevute=ricevute;
                ancora=false;
            } else {
                System.out.println("Valore non ammesso. Sono ammessi solo valori compresi tra 0 e 100, e mai inferiori al numero delle copie vendute, se già impostato. Reinseriscilo");
                ricevute = inputNumeri.nextInt();
            }
        } while (ancora);
    }

    public int getRicevute(){
        return ricevute;
    }


    public void setVendute(int vendute){
        boolean ancora = true;

        do {
            if (vendute >= 0 && vendute <= getRicevute()){ // vendute massimo quante ricevute
                this.vendute=vendute;
                ancora=false;
            } else {
                System.out.println("Il numero di copie vendute deve essere positivo e minore delle copie presenti in magazzino. Reinseriscilo");
                vendute = inputNumeri.nextInt();
            }
        } while (ancora);
    }

    public int getVendute(){
        return vendute;
    }


    public void setAggio(int aggio){
        boolean ancora = true;

        do {
            if (aggio > 4 && aggio < 21){ // Regola: aggio nel range standard
                this.aggio=aggio;
                ancora=false;
            } else {
                System.out.println("Il valore dell 'aggio deve essere compreso tra 5 e 20. Reinseriscilo");
                aggio = inputNumeri.nextInt();
            }
        } while (ancora);
    }

    public int getAggio(){
        return aggio;
    }

    public int rese(){
        return getRicevute() - getVendute(); // impossibile minore di zero
    }

    public void setPrezzo(double prezzo){
        boolean ancora = true;
        do {
            if (prezzo > 0 && prezzo < 31) { // Regola: prezzo ipotetico max 30 euro
                this.prezzo = prezzo;
                ancora = false;
            } else {
                System.out.println("Il prezzo deve essere positivo ed inferiore a 30,00 euro, reinseriscilo");
                prezzo = inputNumeri.nextDouble();                
            }
        } while (ancora);
    }

    public double getPrezzo(){
        return prezzo;
    }


    public double guadagno(){ // calcolo del guadagno per tipo di pubblicazione
        guadagno = ((getPrezzo() * getAggio())/100)* getVendute();
        return guadagno;
    }

}
