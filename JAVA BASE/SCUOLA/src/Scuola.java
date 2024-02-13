import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scuola {
Scanner inputNum = new Scanner(System.in);
Scanner inputTesti = new Scanner(System.in);
ArrayList<Docente> docente = new ArrayList<>(); 
ArrayList<DocenteBes> docenteBes = new ArrayList<>(); 
ArrayList<Studente> studente = new ArrayList<>();
ArrayList<StudenteBes> studenteBes = new ArrayList<>();
ArrayList<SocioClub> socioClub = new ArrayList<>();
int prog=1;
int scelta;



    public void creaProfilo(){
        boolean ancora = true;
        
        System.out.println("Vuoi inserire un nuovo profilo?");
        System.out.println("1) Profilo Docente");
        System.out.println("2) Profilo Docente BES");
        System.out.println("3) Profilo Studente");
        System.out.println("4) Profilo Studente BES");
        System.out.println("5) Profilo Socio Club Pallavolo");
        System.out.println("0) Termina inserimento");
        boolean ripeti = true;
        do {
            try {
                scelta = inputNum.nextInt();
                ripeti=false;
            } catch (InputMismatchException e) {
                    System.out.println("Ammessi solo input numerici. Reinseriscilo");
                    inputNum.nextInt();
            } catch (Exception exc) {
                    System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
            }                            
        } while (ripeti);
        
        
        int i=0, j=0, k=0, l=0, n=0; // counter per le 3 ArrayList
        while (ancora) {  
      
                switch (scelta) {
                    case 1: docente.add(new Docente());
                        System.out.println("Inserisci il nome del docente:");
                        docente.get(i).setNome(inputTesti.nextLine().toUpperCase());
                        System.out.println("Inserisci il cognome del docente:");
                        docente.get(i).setCognome(inputTesti.nextLine().toUpperCase());
                        System.out.println("Inserisci l'anno di nascita del docente:");
                        ripeti = true;
                                do {
                                    try {
                                        docente.get(i).setAnnoNascita(inputNum.nextInt()); 
                                        ripeti=false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ammessi solo input numerici. Reinseriscilo:");
                                        inputNum.nextInt();
                                    } catch (Exception exc) {
                                        System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                                    }
                                    
                                } while (ripeti);
                        
                        
                        if (docente.get(i).getAnnoNascita()==0) {
                            docente.remove(i);
                        } else{ 
                            System.out.println("Quale materia insegna?");
                            System.out.println("1) Italiano");
                            System.out.println("2) Matematica e Fisica");
                            System.out.println("3) Inglese");
                            System.out.println("4) Storia e Filosofia");
                            System.out.println("5) Scienze");
                            System.out.println("6) Arte");
                            System.out.println("7) Educazione Fisica");

                            ripeti = true;
                                do {
                                    try {
                                        docente.get(i).setMateria(inputNum.nextInt()); 
                                        ripeti=false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ammessi solo input numerici. Reinseriscilo:");
                                        inputNum.nextLine();
                                    } catch (Exception exc) {
                                        System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                                    }
                                    
                                } while (ripeti);
                            

                            i++;// incremento docenti
                        }
                        break;
                    case 2: docenteBes.add(new DocenteBes());
                        System.out.println("Inserisci il nome del docente:");
                        docenteBes.get(l).setNome(inputTesti.nextLine().toUpperCase());
                        System.out.println("Inserisci il cognome del docente:");
                        docenteBes.get(l).setCognome(inputTesti.nextLine().toUpperCase());
                        System.out.println("Inserisci l'anno di nascita del docente:");
                        ripeti = true;
                        do {
                            try {
                                docenteBes.get(l).setAnnoNascita(inputNum.nextInt()); 
                                ripeti=false;
                            } catch (InputMismatchException e) {
                                System.out.println("Ammessi solo input numerici. Reinseriscilo:");
                                inputNum.nextLine();
                            } catch (Exception exc) {
                                System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                            }
                                    
                        } while (ripeti);
                        
                        
                        if (docenteBes.get(l).getAnnoNascita()==0) {
                            docenteBes.remove(l);
                        } else{ 
                            System.out.println("Quale materia insegna?");
                            System.out.println("1) Italiano");
                            System.out.println("2) Matematica e Fisica");
                            System.out.println("3) Inglese");
                            System.out.println("4) Storia e Filosofia");
                            System.out.println("5) Scienze");
                            System.out.println("6) Arte");
                            System.out.println("7) Educazione Fisica");

                            ripeti = true;
                                do {
                                    try {
                                        docenteBes.get(l).setMateria(inputNum.nextInt()); 
                                        ripeti=false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ammessi solo input numerici. Reinseriscilo:");
                                        inputNum.nextLine();
                                    } catch (Exception exc) {
                                        System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                                    }
                                    
                                } while (ripeti);

                            System.out.println("Inserisci nome e cognome dello studente BES assegnatogli(da 1 a 3 studenti BES per docente BES, per terminare l'inserimento digitare 'STOP'):");
                            docenteBes.get(l).setLista();
                            docenteBes.get(l).aggiungiStudenti(inputTesti.nextLine().toUpperCase());
                            for (int m = 0; m < 2; m++) {
                            System.out.println("Inserisci nome e cognome dello studente BES assegnatogli(da 1 a 3 studenti BES per docente BES, per terminare l'inserimento digitare 'STOP'):");
                            String aggiungiStudente = inputTesti.nextLine().toUpperCase();
                                if (aggiungiStudente.equals("STOP")) {
                                    break;
                                } else {
                                    docenteBes.get(l).aggiungiStudenti(aggiungiStudente);
                                }
                            
                            }
                            

                        l++;// incremento docentiBes
                        }
                        break;
                    case 3: 
                        if(studente.size()+ studenteBes.size()<1000){//gestisco il limite di studenti
                            studente.add(new Studente());
                            System.out.println("Inserisci il nome dello studente:");
                            studente.get(j).setNome(inputTesti.nextLine().toUpperCase());
                            System.out.println("Inserisci il cognome dello studente:");
                            studente.get(j).setCognome(inputTesti.nextLine().toUpperCase());
                            System.out.println("Inserisci l'anno di nascita dello studente:");
                            ripeti = true;
                                do {
                                    try {
                                        studente.get(j).setAnnoNascita(inputNum.nextInt()); 
                                        ripeti=false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ammessi solo input numerici. Reinseriscilo:");
                                        inputNum.nextLine();
                                    } catch (Exception exc) {
                                        System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                                    }
                                    
                                } while (ripeti);
                            
                            if (studente.get(j).getAnnoNascita()==0) {
                                studente.remove(j);
                            } else{ 
                            System.out.println("Inserisci la classe(classi disponibili da 1 a 5):");
                            ripeti = true;
                                do {
                                    try {
                                        studente.get(j).setClasse(inputNum.nextInt());
                                        ripeti=false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("La classe va indicata con un numero da 1 a 5. Reinseriscila:");
                                        inputNum.nextLine();
                                    } catch (Exception exc) {
                                        System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                                    }
                                    
                                } while (ripeti); 
                            
                            System.out.println("Inserisci la sezione(A-P):");
                            studente.get(j).setSezione(inputTesti.nextLine().toUpperCase().charAt(0));
                            System.out.println("Inserisci l'anno di rilascio del certificato medico(2022/2023):");
                            
                            ripeti = true;
                                do {
                                    try {
                                        studente.get(j).setAnnoRilascio(inputNum.nextInt());
                                        ripeti=false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ammessi solo input numerici. Reinseriscilo:");
                                        inputNum.nextLine();
                                    } catch (Exception exc) {
                                        System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                                    }
                                    
                                } while (ripeti);

                            System.out.println("Inserisci il cognome del medico che ha rilasciato il certificato:");
                            studente.get(j).setMedico(inputTesti.nextLine().toUpperCase());               
                            // incremento il progressivo della matricola
                            studente.get(j).setProg(prog++);
                            
                            j++;// incremento studenti
                            }
                        } else{
                            System.out.println("Non è possibile inserire altri studenti.Capienza massima raggiunta."); // GESTISCI NUM MAX STUDENTI
                            ancora=false;
                        }
                        break;
                    case 4: 
                        if(studente.size()+ studenteBes.size()<1000){//gestisco il limite di studenti
                            studenteBes.add(new StudenteBes());
                            System.out.println("Inserisci il nome del studente:");
                            studenteBes.get(n).setNome(inputTesti.nextLine().toUpperCase());
                            System.out.println("Inserisci il cognome del studente:");
                            studenteBes.get(n).setCognome(inputTesti.nextLine().toUpperCase());
                            System.out.println("Inserisci l'anno di nascita del studente:");
                            ripeti = true;
                                do {
                                    try {
                                        studenteBes.get(n).setAnnoNascita(inputNum.nextInt()); 
                                        ripeti=false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ammessi solo input numerici. Reinseriscilo:");
                                        inputNum.nextLine();
                                    } catch (Exception exc) {
                                        System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                                    }
                                    
                                } while (ripeti);
                            
                            if (studenteBes.get(n).getAnnoNascita()==0) {
                                studenteBes.remove(n);
                            } else{ 
                            System.out.println("Inserisci la classe(classi disponibili da 1 a 5):");
                            ripeti = true;
                                do {
                                    try {
                                        studenteBes.get(n).setClasse(inputNum.nextInt());
                                        ripeti=false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("La classe va indicata con un numero da 1 a 5. Reinseriscila:");
                                        inputNum.nextLine();
                                    } catch (Exception exc) {
                                        System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                                    }
                                    
                                } while (ripeti); 
                            
                            System.out.println("Inserisci la sezione(A-P):");
                            studenteBes.get(n).setSezione(inputTesti.nextLine().toUpperCase().charAt(0));
                            System.out.println("Inserisci l'anno di rilascio del certificato medico(2022/2023):");
                            
                            ripeti = true;
                                do {
                                    try {
                                        studenteBes.get(n).setAnnoRilascio(inputNum.nextInt());
                                        ripeti=false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ammessi solo input numerici. Reinseriscilo:");
                                        inputNum.nextLine();
                                    } catch (Exception exc) {
                                        System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                                    }
                                    
                                } while (ripeti);

                            System.out.println("Inserisci il cognome del medico che ha rilasciato il certificato:");
                            studenteBes.get(n).setMedico(inputTesti.nextLine().toUpperCase());  
                            System.out.println("Inserire nome e cognome del docente BES al quale è assegnato(Max 70 caratteri):");
                            studenteBes.get(n).setDocente(inputTesti.nextLine().toUpperCase());

                            // campo per inserire
                            // incremento il progressivo della matricola
                            studenteBes.get(n).setProg(prog++);
                            
                            n++;// incremento studenti
                            }
                        } else{
                            System.out.println("Non è possibile inserire altri studenti.Capienza massima raggiunta."); // GESTISCI NUM MAX STUDENTI
                            ancora=false;
                        }
                        break;
                    case 5: socioClub.add(new SocioClub());
                        System.out.println("Inserisci il nome del socio del club di Pallavolo:");
                        socioClub.get(k).setNome(inputTesti.nextLine().toUpperCase());
                        System.out.println("Inserisci il cognome del socio del club di Pallavolo:");
                        socioClub.get(k).setCognome(inputTesti.nextLine().toUpperCase());
                        System.out.println("Inserisci l'anno di rilascio del certificato medico(2022/2023):");
                        ripeti = true;
                                do {
                                    try {
                                        socioClub.get(k).setAnnoRilascio(inputNum.nextInt());
                                        ripeti=false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ammessi solo input numerici. Reinseriscilo:");
                                        inputNum.nextLine();
                                    } catch (Exception exc) {
                                        System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                                    }
                                    
                                } while (ripeti);
                        
                        System.out.println("Inserisci il cognome del medico che ha rilasciato il certificato:");
                        socioClub.get(k).setMedico(inputTesti.nextLine().toUpperCase());
                        k++; // incremento socioClub
                        break;
                    case 0: ancora=false;
                        break;                   
                    default: System.out.println("Richiesta sconosciuta.");
                        break;
                } 
                System.out.println("Vuoi inserire un nuovo profilo?");
                System.out.println("1) Profilo Docente");
                System.out.println("2) Profilo Docente BES");
                System.out.println("3) Profilo Studente");
                System.out.println("4) Profilo Studente BES");
                System.out.println("5) Profilo Socio Club Pallavolo");
                System.out.println("0) Termina inserimento");
                ripeti = true;
                do {
                    try {
                        scelta = inputNum.nextInt();
                        ripeti=false;
                    } catch (InputMismatchException e) {
                            System.out.println("Ammessi solo input numerici. Reinseriscilo:");
                            inputNum.nextLine();
                    } catch (Exception exc) {
                            System.out.println("Problema generico(main). Segnalare allo sviluppatore.");
                    }                            
                } while (ripeti);  
                if (scelta==0){ ancora=false;}
            }
    }
    
    
    public void display(){ // uso lambda per stampare
        System.out.println("Quale elenco vuoi visualizzare? - Docenti(D) - Studenti(S) - Soci Club Pallavolo(C) - Termina programma(X)");
        char scelta = inputTesti.nextLine().toUpperCase().charAt(0);
        boolean ancora = true;
        while (ancora) {
            switch (scelta) {   
                case 'D': 
                    System.out.println("***Docenti***");
                    if(docente.size() > 0 &&  docenteBes.size() > 0 ){
                        docente.forEach((docente) -> docente.display());
                        docenteBes.forEach((docenteBes) -> docenteBes.display());
                    }else if (docente.size() > 0) {
                        docente.forEach((docente) -> docente.display());
                    } else if ( docenteBes.size() > 0 ){
                        docenteBes.forEach((docenteBes) -> docenteBes.display());
                    } else {
                        System.out.println("Non ci sono docenti in elenco da mostrare.");
                    }
                    break;
                case 'S': 
                    System.out.println("***Studenti***");
                    if (studente.size()>0 && studenteBes.size()>0) {
                        studente.forEach((studente) -> studente.display());
                        studenteBes.forEach((studenteBes) -> studenteBes.display());

                    } else if (studente.size()>0){
                        studente.forEach((studente) -> studente.display());
                    } else if (studenteBes.size()>0 ){
                        studenteBes.forEach((studenteBes) -> studenteBes.display());
                    } else {
                        System.out.println("Non ci sono studenti in elenco da mostrare.");
                    }
                    break;
                case 'C':
                    if (socioClub.size()==0) {
                        System.out.println("Non ci sono soci del Club di Pallavolo in elenco da mostrare.");
                    }else {
                        System.out.println("***Soci Club Pallavolo***");
                        socioClub.forEach((socioClub) -> socioClub.display());
                    }
                       
                    break;
                case 'X':
                    ancora=false;
                default: System.out.println("Richiesta sconosciuta");
                    break;
        }
        System.out.println("Quale elenco vuoi visualizzare?- Docenti(D) - Studenti(S) - Soci Club Pallavolo(C) - Termina programma(X)");
        scelta = inputTesti.nextLine().toUpperCase().charAt(0);
        if (scelta=='X'){ancora = false;}
        }
        
        System.out.println("***Programma Terminato***");
        
    }
}

//vedo se posso non ripetere anno


