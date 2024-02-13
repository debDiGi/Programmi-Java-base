import java.util.ArrayList;
import java.util.Scanner;

public class Edicola {
    Scanner inputTesti = new Scanner(System.in);
    Scanner inputNum = new Scanner(System.in);
    ArrayList<Pubblicazione> pubblicazioni = new ArrayList<>(); 
    double guadagnoTotale;
    protected int indice;

    public void insPubblicazione(){
        System.out.println("***Programma gestione vendite avviato***");
        boolean ancora = true;
        pubblicazioni.add(new Pubblicazione());
        int i=0;
        
        while (ancora) {
            
                    System.out.println("Inserisci il nome della pubblicazione:");
                    pubblicazioni.get(i).setNome(inputTesti.nextLine().toUpperCase().trim());
                    System.out.println("Quante copie hai ricevuto dal fornitore?");
                    pubblicazioni.get(i).setRicevute(inputNum.nextInt());
                    System.out.println("Quante copie hai venduto?");
                    pubblicazioni.get(i).setVendute(inputNum.nextInt());
                    System.out.println("Quanto costa una singola copia?");
                    pubblicazioni.get(i).setPrezzo(inputNum.nextDouble());
                    System.out.println("Quant'è l'aggio su questa pubblicazione?");
                    pubblicazioni.get(i).setAggio(inputNum.nextInt());
                    guadagnoTotale += pubblicazioni.get(i).guadagno(); // aggiungo al TOT il guadagno netto di un tipo di pubblicazione ad ogni ciclo
                    System.out.println("Vuoi inserire un'altra pubblicazione (S/N)?");
                    char scelta = inputTesti.nextLine().toUpperCase().charAt(0);

                if (scelta=='S') {
                    pubblicazioni.add(new Pubblicazione());
                    i++;
                } else if (scelta=='N'){
                    
                    ancora = false;
                }else {
                    System.out.println("Comando non riconosciuto.");
                    System.out.println("Vuoi inserire un'altra pubblicazione (S/N)?");
                    scelta = inputTesti.nextLine().toUpperCase().charAt(0); // N non sce perchè ricomincia in cima al while
                    if (scelta=='N'){
                        ancora=false;
                    }
                }            
        }
    }

    public void menu(){
        System.out.println("Elenco pubblicazioni creato con successo.");
        System.out.println(); 
        boolean ancoraElenco = true; // per terminare il ciclo
        while (ancoraElenco) {
            
            System.out.println("Per modificare una Pubblicazione digita il numero corrispondente. Oppure termina il programma digitando 0");
            for (int i = 0; i < pubblicazioni.size(); i++) { //elenco pubblicazioni disponibili
                System.out.println((i + 1) + ") " + pubblicazioni.get(i).getNome());
            }
            System.out.println("0) TERMINA IL PROGRAMMA");
            indice = (inputNum.nextInt());
            if (indice > 0 && indice <= pubblicazioni.size()) { // validità input
                
                // SOTTOMENù
                System.out.println("Digita 'M' per modificare, 'C' per cancellare"); 
                char scelta = inputTesti.nextLine().toUpperCase().charAt(0);
                
                boolean ancora=true;
                while (ancora) {
                
                switch (scelta) {
                    // MODIFICA
                    case 'M':  
                            System.out.println("Stai modificando la pubblicazione n."+ indice +" '" + pubblicazioni.get(indice-1).getNome().toUpperCase()+"' ");
                            System.out.println("Seleziona l'indice del campo da modificare");
                            System.out.println("1) Nome Pubblicazione");
                            System.out.println("2) Copie ricevute dal fornitore");
                            System.out.println("3) Copie vendute");
                            System.out.println("4) Prezzo per copia");
                            System.out.println("5) Aggio per copia");
                            System.out.println("0) Torna all'elenco delle pubblicazioni" );
                            int indice2 = inputNum.nextInt();
                            
                                switch (indice2) { // SELEZIONE CAMPO DA MODIFICARE
                                    case 1: System.out.println("Inserisci il nome della pubblicazione:");
                                        pubblicazioni.get(indice-1).setNome(inputTesti.nextLine().toUpperCase().trim());
                                        break;
                                    case 2: System.out.println("Quante copie hai ricevuto dal fornitore?Ricorda di inserire un valore superiore al numero di copie vendute( "+ pubblicazioni.get(indice-1).getVendute() + " copie)");
                                        pubblicazioni.get(indice-1).setRicevute(inputNum.nextInt());
                                        break;
                                    case 3:System.out.println("Quante copie hai venduto?(Disponibili in magazzino: " + pubblicazioni.get(indice-1).getRicevute() + " copie )");
                                        pubblicazioni.get(indice-1).setVendute(inputNum.nextInt());
                                        break;
                                    case 4:
                                        System.out.println("Quanto costa una singola copia?");
                                        pubblicazioni.get(indice-1).setPrezzo(inputNum.nextDouble());
                                        break;
                                    case 5:
                                        System.out.println("Quant'è l'aggio su questa pubblicazione?");
                                        pubblicazioni.get(indice-1).setAggio(inputNum.nextInt());
                                        break;
                                    case 0: ancora=false;
                                        break;
                                    default: System.out.println("Comando non riconosciuto.");

                                }                            
                        break;

                    //CANCELLA
                    case 'C': pubblicazioni.remove(indice-1);
                            System.out.println("Pubblicazione n. " + indice + " cancellata.");
                            if (pubblicazioni.size()==0) {
                                System.out.println("Non ci sono altre Pubblicazione in memoria. Sessione Terminata.");
                                guadagnoTotale = 0;
                                System.exit(0);
                            }
                            ancora=false;
                            
                        break;

                    default: System.out.println("Comando non riconosciuto.");
                        System.out.println("Digita 'M' per modificare, 'C' per cancellare"); 
                        scelta = inputTesti.nextLine().toUpperCase().charAt(0);
                }
            }
            
            }else if (indice==0){ // ESCE DAL CICLO PER TERMINARE IL PROGRAMMA
                ancoraElenco=false;
            } else {
                System.out.println("Comando non riconosciuto.");        
                System.out.println("Digita il numero della Pubblicazione che vuoi selezionare");
            }
        }
    }



    

    public void display(){ // controlla override display se serve in SottoMenu
        System.out.println("Resoconto di oggi: ");
        for (int i = 0; i < pubblicazioni.size(); i++) { 
            System.out.print("Nome della pubblicazione n. " + (i + 1) + ": ");
            System.out.println(pubblicazioni.get(i).getNome()); 
            System.out.println("Copie ricevute dal fornitore: " + pubblicazioni.get(i).getRicevute());
            System.out.println("Copie vendute: " + pubblicazioni.get(i).getVendute());
            System.out.println("Copie rese al venditore: " + ( pubblicazioni.get(i).getRicevute() - pubblicazioni.get(i).getVendute() ) );
            System.out.println();
        }
        System.out.println("Guadagno totale netto: " + Math.round(guadagnoTotale * 100)/100.00 + " euro");    
    }


}
   