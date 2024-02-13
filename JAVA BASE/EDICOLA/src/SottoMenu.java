public class SottoMenu extends Edicola{
    public void sottoMenu(int indice){
            this.indice=indice;
            System.out.println("Digita 'M' per modificare, 'C' per cancellare");
            char scelta = inputTesti.nextLine().toUpperCase().charAt(0);
            switch (scelta) {

                case 'M': boolean ancora=true;
                        while (ancora) { 
                        System.out.println("Seleziona l'indice del campo da modificare");
                        System.out.println("1) Nome Pubblicazione");
                        System.out.println("2) Copie ricevute dal fornitore");
                        System.out.println("3) Copie vendute");
                        System.out.println("4) Prezzo per copia");
                        System.out.println("5) Aggio per copia");
                        System.out.println("0) Torna all'elenco delle pubblicazioni" );
                        int indiceMenu = inputNum.nextInt();
                        
                            switch (indiceMenu) {
                                case 1: System.out.println("Inserisci il nome della pubblicazione:");
                                    pubblicazioni.get(indice).setNome(inputTesti.nextLine().toUpperCase().trim());
                                    break;
                                case 2: System.out.println("Quante copie hai ricevuto dal fornitore?");
                                    pubblicazioni.get(indice).setRicevute(inputNum.nextInt());
                                    break;
                                case 0: ancora=false;
                                    break;
                                default: System.out.println("Comando non riconosciuto.");
                            }
                        }                        
                    break;
                
                case 'C': pubblicazioni.remove(indice);
                        System.out.println("Pubblicazione n. " + indice + " cancellata.");
                    break;
                default: System.out.println("Comando non riconosciuto.");
                    System.out.println("Digita 'M' per modificare, 'C' per cancellare");
                    scelta = inputNum.nextLine().toUpperCase().charAt(0);
            }
    }
}

// TAGLIATO DA EDICOLA

                /* SottoMenu mySottoMenu = new SottoMenu();
                mySottoMenu.sottoMenu(indice); */

                
    /* public void sottoMenu(int indice){
        this.indice=indice;
            System.out.println("Digita 'M' per modificare, 'C' per cancellare");
            char scelta = inputTesti.nextLine().toUpperCase().charAt(0);
            switch (scelta) {

                case 'M': boolean ancora=true;
                        while (ancora) { 
                        System.out.println("Seleziona l'indice del campo da modificare");
                        System.out.println("1) Nome Pubblicazione");
                        System.out.println("2) Copie ricevute dal fornitore");
                        System.out.println("3) Copie vendute");
                        System.out.println("4) Prezzo per copia");
                        System.out.println("5) Aggio per copia");
                        System.out.println("0) Torna all'elenco delle pubblicazioni" );
                        int indiceMenu = inputNum.nextInt();
                        
                            switch (indiceMenu) {
                                case 1: System.out.println("Inserisci il nome della pubblicazione:");
                                    pubblicazioni.get(indice).setNome(inputTesti.nextLine().toUpperCase().trim());
                                    break;
                                case 2: System.out.println("Quante copie hai ricevuto dal fornitore?");
                                    pubblicazioni.get(indice).setRicevute(inputNum.nextInt());
                                    break;
                                case 0: ancora=false;
                                    break;
                                default: System.out.println("Comando non riconosciuto.");
                            }
                        }                        
                    break;
                
                case 'C': pubblicazioni.remove(indice);
                        System.out.println("Pubblicazione n. " + indice + " cancellata.");
                    break;
                default: System.out.println("Comando non riconosciuto.");
                    System.out.println("Digita 'M' per modificare, 'C' per cancellare");
                    scelta = inputNum.nextLine().toUpperCase().charAt(0);
            }
    } */