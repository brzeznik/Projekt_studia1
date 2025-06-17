package projekt1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Praca extends Thread {
    enum Rodzajpracy {
        Ogolna,
        Montaz,
        Demontaz,
        Wymiana
    }
    private static HashMap<Integer,Praca> prace = new HashMap<>();
    private Rodzajpracy rodzajpracy;
    private int czaspracy;
    private Boolean Czyzrealizowane = false;
    private String opis;
    private ArrayList<Praca> Dozrobienia = new ArrayList<>();
    private ArrayList<Praca> Pozrobieniu = new ArrayList<>();
    private static int nastepneIDpracy = 1;
    private final int IDpracy;
    private volatile Boolean aktywny = false;
    private PrintWriter zapis;
    private final Object synchronizator = new Object();

    public Praca(Rodzajpracy rodzajpracy, int czaspracy, String opis, ArrayList<Praca> dozrobienia){
        this.rodzajpracy = rodzajpracy;
        this.czaspracy = czaspracy;
        this.opis = opis;
        this.Dozrobienia = dozrobienia;
        this.IDpracy = nastepneIDpracy;
        nastepneIDpracy++;
        prace.put(this.IDpracy,this);
    }

    public Praca(Rodzajpracy rodzajpracy, int czaspracy, String opis){
        this.rodzajpracy = rodzajpracy;
        this.czaspracy = czaspracy;
        this.opis = opis;
        this.IDpracy = nastepneIDpracy;
        nastepneIDpracy++;
        prace.put(this.IDpracy,this);
    }

    public void ustawzapis(PrintWriter p){
        this.zapis = p;
    }

    public int getIDpracy() {
        return IDpracy;
    }

    public Praca znajdzPrace(int i){
        return prace.get(i);
    }


    public void dodajprace(Praca k){
        this.Dozrobienia.add(k);
    }

    public void wypiszprace(){
        for (Praca p : Dozrobienia){
            System.out.println(p);
        }
    }

    public void wykonajpo(Praca k){
        Pozrobieniu.add(k);
    }
    public ArrayList<Praca> wezprace(){
        return Pozrobieniu;
    }


    @Override
    public synchronized void start(){
        if (!aktywny){
            aktywny = true;
            super.start();
        }
    }

    @Override
    public void run() {
        this.ustawzapis(zapis);
        Date data = new Date();
        try {
            synchronized (synchronizator) {
                zapis.println("Praca: " + IDpracy + " została rozpoczęta " + data);
                zapis.println(this);

                System.out.println("Praca: " + IDpracy + " została rozpoczęta " + data);
                System.out.println(this);
            }
            Thread.sleep(czaspracy * 1000);
            System.out.println();

            ArrayList<Thread> podprace = new ArrayList<>();

            if (this.wezprace() != null){
                for (Praca p : Pozrobieniu){
                    p.ustawzapis(zapis);
                    p.start();
                    podprace.add(p);
                }
            }

            if(this.Dozrobienia != null){
                for (Praca p : Dozrobienia){
                    p.ustawzapis(zapis);
                    p.start();
                    podprace.add(p);
                }
            }

            for (Thread t : podprace){
                t.join();
            }

        } catch (InterruptedException e) {
            synchronized (synchronizator){
                zapis.println("Praca: "+IDpracy+" została zatrzymana");
            }
            System.err.println("Praca: "+IDpracy+" została zatrzymana");
            Thread.currentThread().interrupt();
        }
        this.Czyzrealizowane = true;


    }


    @Override
    public String toString() {
        return "Praca{" +
                "rodzajpracy=" + rodzajpracy +
                ", czaspracy=" + czaspracy +
                ", Czyzrealizowane=" + Czyzrealizowane +
                ", opis='" + opis + '\'' +
                ", IDpracy=" + IDpracy +
                ", aktywny=" + aktywny +
                '}';
    }
}
