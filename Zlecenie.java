package projekt1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

public class Zlecenie implements Runnable{
    public enum Rodzajzlecenia {
        Planowane(true),
        Nieplanowane(false);

        private final Boolean planowane;
        Rodzajzlecenia(boolean planowane) {
            this.planowane = planowane;
        }

        public Boolean czyplanowane(){
            return planowane;
        }

    }
    public enum Stanzlecenia {
        Utworzone,
        Rozpoczete,
        Zakonczone;

    }
    private static HashMap<Integer,Zlecenie> zlecenia = new HashMap<>();
    private Stanzlecenia Stan = Stanzlecenia.Utworzone;
    private static int nastepneIDzlecenia = 1;
    private final int IDzlecenia;
    private Rodzajzlecenia rodzajzlecenia;
    private ArrayList<Praca> prace = new ArrayList<>();
    private Brygada brygada;
    private final Date datautworzenia;
    private Date datarozpoczecia;
    private Date datazakonczenia;
    private final String nazwapliku;
    private File plik;
    private PrintWriter zapis;


    public Zlecenie(Boolean planowane) throws IOException {
        this.rodzajzlecenia = planowane ? Rodzajzlecenia.Planowane : Rodzajzlecenia.Nieplanowane;
        this.IDzlecenia = nastepneIDzlecenia;
        nastepneIDzlecenia++;
        zlecenia.put(this.IDzlecenia,this);
        datautworzenia = new Date();
        nazwapliku = String.valueOf(IDzlecenia);
        plik = new File("Zlecenie"+IDzlecenia+".txt");
        plik.createNewFile();
        try {
            zapis = new PrintWriter(plik);
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        }
    }

    public Zlecenie(Boolean planowane, Brygada brygada) throws IOException {
        this.rodzajzlecenia = planowane ? Rodzajzlecenia.Planowane : Rodzajzlecenia.Nieplanowane;
        this.brygada = brygada;
        this.IDzlecenia = nastepneIDzlecenia++;
        zlecenia.put(this.IDzlecenia,this);
        datautworzenia = new Date();
        nazwapliku = String.valueOf(IDzlecenia);
        plik = new File("Zlecenie"+IDzlecenia+".txt");
        plik.createNewFile();
        try {
            zapis = new PrintWriter(plik);
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        }
    }
    public Zlecenie(Boolean planowane, ArrayList<Praca> prace) throws IOException {
        this(planowane, prace, null);

    }
    public Zlecenie(Boolean planowane, ArrayList<Praca> prace, Brygada brygada) throws IOException {
        this.rodzajzlecenia = planowane ? Rodzajzlecenia.Planowane : Rodzajzlecenia.Nieplanowane;
        this.prace = prace;
        this.brygada = brygada;
        this.IDzlecenia = nastepneIDzlecenia++;
        zlecenia.put(this.IDzlecenia,this);
        datautworzenia = new Date();
        nazwapliku = String.valueOf(IDzlecenia);
        plik = new File("Zlecenie"+IDzlecenia+".txt");
        plik.createNewFile();
        try {
            zapis = new PrintWriter(plik);
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        }
    }


    public PrintWriter getzapis(){
        return zapis;
    }

    public static Zlecenie znajdzlecenie(int i){
        return zlecenia.get(i);
    }


    public void dodajprace(Praca p){
        this.prace.add(p);
    }

    public Boolean dodajbrygade(Brygada b){
        if (this.brygada == null){
            this.brygada = b;
            return true;
        }else {
            return false;
        }
    }
    public void getPrace() {
        System.out.println();
        for (Praca p : prace){
            System.out.println(p);
        }
    }

    public void getZlecenia() {
        System.out.println();
        for (Zlecenie z: zlecenia.values()){
            System.out.println(z);
        }
    }
    public static ArrayList<Zlecenie> getzlecenia(){
        return (ArrayList<Zlecenie>) zlecenia.values();
    }

    public int getIDzlecenia() {
        return IDzlecenia;
    }

    public void getdaterozpoczecia(){
        System.out.println(datarozpoczecia);
    }
    public void getdatezakonczenia(){
        System.out.println(datarozpoczecia);
    }
    public void getdateutworzenia(){
        System.out.println(datarozpoczecia);
    }
    public void getstanzlecenia(){
        System.out.println(Stan);
    }
    public Brygada getbrygada(){
        return brygada;
    }


    @Override
    public void run() {
        Stan = Stanzlecenia.Rozpoczete;
        datarozpoczecia = new Date();
        zapis.println("Rozpoczęcie zlecenia "+IDzlecenia+" "+datarozpoczecia);
        this.getdaterozpoczecia();

        if (this.brygada != null && this.prace != null){
            for(Praca p : prace){
                try {
                    p.ustawzapis(zapis);
                    p.start();
                    p.join();
                } catch (Exception e) {
                    System.err.println("Wystąpił błąd przy uruchomieniu pracy: "+p.getIDpracy());
                }
            }
        }

        datazakonczenia = new Date();
        Stan = Stanzlecenia.Zakonczone;
        zapis.println("Zakończenie zlecenia "+IDzlecenia+" "+datazakonczenia);
        zapis.close();
    }

    @Override
    public String toString() {
        return "Zlecenie{" +
                "Stan=" + Stan +
                ", IDzlecenia=" + IDzlecenia +
                ", rodzajzlecenia=" + rodzajzlecenia +
                ", brygada=" + brygada +
                ", prace=" + prace +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (this == null || getClass() != o.getClass()) return false;
        Zlecenie z = (Zlecenie) o;
        if (this.IDzlecenia == z.IDzlecenia) return true;
        return false;
    }
}


    
