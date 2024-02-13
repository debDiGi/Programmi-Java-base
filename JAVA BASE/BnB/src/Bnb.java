import java.lang.IndexOutOfBoundsException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Bnb {
    ArrayList<Prenotazione> prenotazione = new ArrayList<>();
    Scanner inputTesti = new Scanner(System.in);
    Scanner inputNum = new Scanner(System.in);
    int i;
    int mese;
    int giorno;
    int anno;
    int meseOut;
    int giornoOut;
    int annoOut;

    public void prenota(){
        boolean ancora = true;

        while (ancora) {
            prenotazione.add(new Prenotazione());
            System.out.println("Inserisci nome e cognome separati da uno spazio(min 4, max 70 caratteri): ");
            prenotazione.get(i).setNominativo(inputTesti.nextLine().toUpperCase());
            System.out.println("Inserisci un recapito telefonico:");
            prenotazione.get(i).setTelefono(inputTesti.nextLine());
            System.out.println("Inserisci la data del check-in:");
            boolean ripeti=true;
            while (ripeti) {
                try{
                    System.out.println("Inserisci il giorno(gg): ");
                    giorno = inputNum.nextInt();
                    if (giorno>0&&giorno<32) {
                        ripeti=false;
                    } else {
                        System.out.println("Input non valido.");
                    }
                    
                } catch (InputMismatchException exc) {
                    System.out.println("Errore: Inserito un tipo di dato non valido.");
                    inputNum.nextLine();
                }
            }

            ripeti=true;
            while(ripeti) {
                try{
                    
                    System.out.println("Inserisci il mese(mm): ");
                    mese=inputNum.nextInt();
                    if (mese>0&&mese<12) {
                        ripeti=false;
                    } else {
                        System.out.println("Input non valido.");
                    }
                } catch (InputMismatchException exc) {
                System.out.println("Errore: Inserito un tipo di dato non valido.");
                inputNum.nextLine();
                }
            }

            ripeti=true;
            while (ripeti) {
                try {
                    System.out.println("Inserisci l'anno(aaaa): ");
                    anno=inputNum.nextInt();
                    if (anno>2023&&anno<2026) {
                        ripeti=false;
                    } else {
                        System.out.println("Input non valido.");
                    }
                } catch (InputMismatchException exc) {
                    System.out.println("Errore: Inserito un tipo di dato non valido.");
                    inputNum.nextLine();
                }
            }
            
            prenotazione.get(i).setCheckIn(giorno, mese, anno);

            System.out.println("Inserisci la data del check-out:");
            ripeti=true;
            while (ripeti) {
                try{
                    System.out.println("Inserisci il giorno(gg): ");
                    giornoOut = inputNum.nextInt();
                    if (giornoOut>0&&giornoOut<32) {
                        ripeti=false;
                    } else {
                        System.out.println("Input non valido.");
                    }
                } catch (InputMismatchException exc) {
                    System.out.println("Errore: Inserito un tipo di dato non valido.");
                    inputNum.nextLine();
                }
            }

            ripeti=true;
            while(ripeti) {
                try{
                    
                    System.out.println("Inserisci il mese(mm): ");
                    meseOut = inputNum.nextInt();
                    if (meseOut>0&&meseOut<12) {
                        ripeti=false;
                    } else {
                        System.out.println("Input non valido.");
                    }
                } catch (InputMismatchException exc) {
                    System.out.println("Errore: Inserito un tipo di dato non valido.");
                    inputNum.nextLine();
                }
            }

            ripeti=true;
            while (ripeti) {
                try {
                    System.out.println("Inserisci l'anno(aaaa): ");
                    annoOut = inputNum.nextInt();
                    if (annoOut>2023&&annoOut<2026) {
                        ripeti=false;
                    } else {
                        System.out.println("Input non valido.");
                    }
                } catch (InputMismatchException exc) {
                    System.out.println("Errore: Inserito un tipo di dato non valido.");
                    inputNum.nextLine();
                }
            }
        
            prenotazione.get(i).setCheckOut(giornoOut, meseOut, annoOut);
            System.out.println("Operazione completata con successo, la tua prenotazione ha ID: '" + (i+1) + "'"); 
            i++;                                       
            ancora = false;
                       
        }
    }

    
    public void cerca(){
        boolean ancora = true;
        int id=0;
        while (ancora) {
            if (prenotazione.size()>0){ 
                
                System.out.println("Inserisci l'ID per Visualizzare i dettagli di una prenotazione, per tornare al menù principale digita 0.");
                boolean ripeti=true;
                for (int i = 0; i < prenotazione.size(); i++) {
                    System.out.println("Id: " + (i+1) +" - Nominativo: " + prenotazione.get(i).getNominativo());
                }
                while (ripeti) {

                    try {
                        System.out.println("Inserire ID Prenotazione: ");
                        id = inputNum.nextInt();
                        ripeti=false;
                        if (id>0) {
                        try {
                        prenotazione.get(id-1); // per far partire l'eventuale eccezione prima della stampa dell'id inserito
                        System.out.println("ID prenotazione: " + id);
                        prenotazione.get(id-1).display();
                        ripeti=false;
                        } catch (IndexOutOfBoundsException exc) {
                    System.out.println("Prenotazione inesistente.");
                    
                        }
                    } else {
                        ancora=false;
                    }
                    } catch (InputMismatchException exc) {
                        System.out.println("Errore: Inserito un tipo di dato non valido.");
                        inputNum.nextLine();
                    }
                }                
                
            } else {
                System.out.println("Non ci sono prenotazioni.");
                ancora=false;
            }
        }
    }


}

