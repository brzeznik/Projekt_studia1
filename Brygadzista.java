package projekt1;

import java.util.ArrayList;

public class Brygadzista extends Użytkownik{
    private ArrayList<Brygada> lista = new ArrayList<>();
    private ArrayList<Zlecenie> zlecenia = new ArrayList<>();


    public Brygadzista(String imie, String nazwisko, String dzialpracownikow, String login, String haslo){
        super(imie, nazwisko, dzialpracownikow, login, haslo);
    }


    public void dodajbrygadedobrydadzisty(Brygada brygada){
        lista.add(brygada);
    }
    public void WypiszBrygady(){
        System.out.print("Lista Brygad, w których jest "+getImie()+": ");
        for (Brygada g : lista){
            System.out.print(g +", ");
        }
    }

    public void getzlecenia(){
        for (Zlecenie z : Zlecenie.getzlecenia()){
                for (Brygada b: lista){
                    if (z.getbrygada().getbrygadzista() == b.getbrygadzista()){
                        zlecenia.add(z);
                    }
                }
        }
        System.out.println("Lista zlecen w ktorych uczestniczy "+getImie()+": " + zlecenia);
        System.out.println();
    }
}
