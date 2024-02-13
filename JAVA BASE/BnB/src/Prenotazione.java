import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prenotazione {
    Scanner inputTesti = new Scanner(System.in);
    Scanner inputNum = new Scanner(System.in);
    private String nominativo;
    private String telefono;
    /* private int mese;
    private int giorno;
    private int anno; */
    /* private int meseOut;
    private int giornoOut;
    private int annoOut; */
    LocalDate checkInDate;
    LocalDate checkOutDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void setNominativo(String nominativo){
        boolean ancora = true;
        while (ancora) {
            if (nominativo.length() > 3 && nominativo.length() < 71) {
                this.nominativo=nominativo;
                ancora=false;
            } else {
                System.out.println("Per favore inserisci nome e cognome separati da uno spazio. (min 4 - mac 70 caratteri)");
                nominativo = inputTesti.nextLine().toUpperCase();
            }
        }
        
    }

    public String getNominativo(){
        return nominativo;
    }

    public void setCheckIn(int giorno, int mese , int anno){
        boolean ancora = true;

        while (ancora) {
            try {
                // Creazione dell'oggetto LocalDate e controllo della validità
                checkInDate=LocalDate.of(anno, mese, giorno);
                /* this.anno=anno;    
                this.mese=mese;
                this.giorno=giorno; */
                ancora=false;
            } catch (DateTimeException e) {
                         
                System.out.println("La data di check-in inserita non è valida.");
                 
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
                            System.out.println("Errore: è possibile prenotare fino a dicembre 2025.");
                            inputNum.nextLine();
                        }
                        
                    } catch (InputMismatchException exc) {
                        System.out.println("Errore: Inserito un tipo di dato non valido.");
                        inputNum.nextLine();
                    }
                }
            }  
        }        
    }

    public String getCheckIn(){
        return checkInDate.format(formatter);
    }


    public void setCheckOut(int giornoOut, int meseOut , int annoOut){
        boolean ancora = true;

        while (ancora) {
            try {
                // Creazione dell'oggetto LocalDate e controllo della validità
                checkOutDate = LocalDate.of(annoOut, meseOut, giornoOut);
                if (checkOutDate.isAfter(checkInDate)) {
                    /* this.annoOut = annoOut;
                    this.meseOut = meseOut;
                    this.giornoOut = giornoOut; */
                    ancora = false;
                } else {
                    System.out.println("La data di check-out deve essere successiva alla data di check-in.");
                    System.out.println("Inserisci il giorno: ");
                    giornoOut = inputNum.nextInt();
                    System.out.println("Inserisci il mese: ");
                    meseOut = inputNum.nextInt();
                    System.out.println("Inserisci l'anno: ");
                    annoOut = inputNum.nextInt();
                }
            } catch (DateTimeException e) {
                System.out.println("La data di check-out inserita non è valida.");
                boolean ripeti=true;
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
                        annoOut=inputNum.nextInt();
                        if (annoOut>2023&&annoOut<2026) {
                            ripeti=false;
                        } else {
                            System.out.println("Input non valido, è possibile prenotare fino a dicembre 2025.");
                        }
                    } catch (InputMismatchException exc) {
                        System.out.println("Errore: Inserito un tipo di dato non valido.");
                        inputNum.nextLine();
                    }
                }
            }  
        }   
    }

    public String getCheckOut(){ 
        return checkOutDate.format(formatter);
        
    }


    public void setTelefono(String telefono){
        boolean ancora = true;
        while (ancora) {
            String regex = "^[0-9]{10,16}$";
            /* ^ e $ indicano rispettivamente l'inizio e la fine della stringa.
            [0-9] corrisponde a una cifra da 0 a 9.
            {10,16} indica che ci devono essere almeno 10 e al massimo 16 cifre.
            */

            // Crea un oggetto Pattern
            Pattern pattern = Pattern.compile(regex);

            // Crea un oggetto Matcher
            Matcher matcher = pattern.matcher(telefono);

        
            if (matcher.matches()) { // boolean if true il formato è corretto
                this.telefono=telefono;
                ancora=false;
            } else {
                System.out.println("Per favore inserisci un numero di telefono valido.");
                telefono = inputTesti.nextLine();
            }
        }
    }

    public String getTelefono(){
        return telefono;
    } 

    public void display(){
        System.out.println("Nominativo prenotazione: " + getNominativo());
        System.out.println("Telefono: " + getTelefono());
        System.out.println("Check-in: " + getCheckIn());
        System.out.println("Check-Out: " + getCheckOut());
        
    }
}
