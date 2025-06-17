package projekt1;

import java.util.ArrayList;

public class Brygada {
    private String nazwa;
    private Brygadzista brygadzista;
    private ArrayList<Pracownik> pracownicy = new ArrayList<>();
    private final int IDbrygady;
    private int nastepneIDbrygady = 1;

    public Brygada(String nazwa, Brygadzista brygadzista) {
        this.nazwa = nazwa;
        this.brygadzista = brygadzista;
        this.IDbrygady = nastepneIDbrygady;
        nastepneIDbrygady++;
        brygadzista.dodajbrygadedobrydadzisty(this);
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public void dodajpracownikow(Pracownik p) {
        pracownicy.add(p);
    }

    public void dodajpracownikow(ArrayList<Pracownik> p) {
        for (Pracownik i : p) {
            pracownicy.add(i);
        }
    }

    public void Wypiszpracownikow() {
        System.out.println("Pracownicy brygady " + nazwa + ":");
        for (Pracownik p : pracownicy) {
            System.out.print(p);
        }
    }

    public Brygadzista getbrygadzista() {
        return this.brygadzista;
    }

}