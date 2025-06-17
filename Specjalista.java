package projekt1;


import java.util.Date;

public class Specjalista extends Pracownik {
    private String specjalizacja;

    public Specjalista(String imie, String nazwisko, String dzialpracownikow, String specjalizacja) {
        super(imie, nazwisko, dzialpracownikow);
        this.specjalizacja = specjalizacja;
    }



}
