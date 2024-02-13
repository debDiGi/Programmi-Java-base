public class StudenteBes extends Studente implements Certificato {
    private String docenteB;
    
    public void setDocente(String docenteB){
        boolean ancora=true;

        do {
            if (docenteB.length()> 3 && docenteB.length()<=70) {
                this.docenteB=docenteB;
                ancora=false;
            } else {
                System.out.println("Massimo 70 caratteri, reinserisci il nome del docente:");
                docenteB= inputTesti.nextLine().toUpperCase();
            }   
        } while (ancora);
    }

    public String getDocenteB(){
        return docenteB;
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
        System.out.println("Assegnato al docente BES: " + docenteB);
        }
        System.out.println();
        
    }

}
