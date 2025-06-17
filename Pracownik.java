package projekt1;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pracownik implements Comparable<Pracownik>{
    private String imie;
    private String nazwisko;
    private Date dataurodzenia;
    private String dzialpracownikow;
    private static List<Pracownik> list = new ArrayList<>();

    public Pracownik(String imie,String nazwisko,String dzialpracownikow){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataurodzenia = new Date();
        DzialPracownikow.dodaj(dzialpracownikow,this);
        this.dzialpracownikow = dzialpracownikow;
        list.add(this);
    }



    @Override
    public String toString() {
        return "Imie: " + imie + " Nazwisko: " + nazwisko + " DataUrodzenia: " + dataurodzenia + " Dział: " + dzialpracownikow;
    }

    @Override
    public int compareTo(Pracownik o) {
        int porownanieNazwiska = this.nazwisko.compareTo(o.nazwisko);
        if (porownanieNazwiska != 0) {
            return porownanieNazwiska;
        } else {
            return this.imie.compareTo(o.imie);
        }
    }

    public static void getList() {
        System.out.println("\n LISTA PRACOWNIKÓW");
            for (Pracownik p : list){
                System.out.println(p);
            }
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
