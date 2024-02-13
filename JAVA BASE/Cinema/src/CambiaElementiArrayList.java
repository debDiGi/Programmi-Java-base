
    import java.util.ArrayList;

public class CambiaElementiArrayList {

    public static void main(String[] args) {
        // Creazione dell'ArrayList di 30 "L"
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            arrayList.add("L");
        }

        // Cambia i primi 10 elementi in "O" spostandoti di 3 posizioni finché non li hai cambiati tutti
        int index = arrayList.indexOf("L");
        int cambiati = 0;

        while (cambiati < 30) {
            arrayList.set(index, "O");
            cambiati++;
            index = (index + 3) % 30;
        }
        System.out.println(cambiati);
        // Stampa dell'ArrayList modificato
        for (String elemento : arrayList) {
            System.out.print(elemento + " ");
        }
    }
}


