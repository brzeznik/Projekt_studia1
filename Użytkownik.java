package projekt1;

public class Użytkownik extends Pracownik{
    private String login;
    private String haslo;
    private final int IDuzytkownika;
    private int nastepneIDuzytkownika = 1;
    public Użytkownik(String imie, String nazwisko, String dzialpracownikow, String login, String haslo){
        super(imie,nazwisko,dzialpracownikow);
        this.login = login;
        this.haslo = haslo;
        this.IDuzytkownika = nastepneIDuzytkownika;
        nastepneIDuzytkownika++;
    }

    public String inicjaly = ""+getImie().charAt(0) +""+ getNazwisko().charAt(0);

    @Override
    public String toString() {
        return "Użytkownik{" +
                "login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", IDuzytkownika=" + IDuzytkownika +
                ", inicjaly='" + inicjaly + '\'' +
                '}';
    }
}
