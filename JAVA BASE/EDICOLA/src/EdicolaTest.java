public class EdicolaTest {
    public static void main(String[] args) {
        Edicola myEdicola = new Edicola();
        myEdicola.insPubblicazione();
        myEdicola.display();
        myEdicola.menu();
        myEdicola.display();

        System.out.println("***Programma terminato***");
        System.exit(0);
    }
}
