package projekt1;

import Miniprojekt.Person;

import java.io.IOException;
import java.util.ArrayList;

import static projekt1.DzialPracownikow.createDzial;
import static projekt1.Pracownik.getList;


public class Main {
    public static void main(String[] args) throws DzialPracownikow.NotUniqueNameException, IOException {
        createDzial("IT");
        createDzial("Budowlanka");
        Specjalista slawek = new Specjalista("Slawek","Wenek","IT","IT");
        Specjalista slawek4 = new Specjalista("Slawek","Wenecjusz","IT","IT");
        Specjalista slawek2 = new Specjalista("Slawek","janus","IT","IT");
        Specjalista slawek3 = new Specjalista("Slawek","januszzz","IT","IT");
        Specjalista damian = new Specjalista("damian","katolik","Budowlanka","Budowlanka");
        Specjalista damian2 = new Specjalista("damian","grzeczny","Budowlanka","Budowlanka");
        Użytkownik admin = new Użytkownik("admin","glowny","IT","admin","admin");
        Brygadzista wladek = new Brygadzista("Władek","Polak","Budowlanka","wladek","haslo");
        Brygada Budowlancy = new Brygada("Budowlancy",wladek);
        Brygada SwiryIT = new Brygada("SwiryIT",wladek);

        ArrayList<Pracownik> pracowniks = new ArrayList<>();
        pracowniks.add(slawek4);
        pracowniks.add(slawek2);
        pracowniks.add(slawek3);
        pracowniks.add(slawek);
        Budowlancy.dodajpracownikow(damian);
        Budowlancy.dodajpracownikow(pracowniks);
        Budowlancy.Wypiszpracownikow();

        DzialPracownikow.wypisz("Budowlanka");
        System.out.println(slawek.compareTo(slawek4));
        getList();
        System.out.println(admin.inicjaly);
        wladek.WypiszBrygady();

        ArrayList<Praca> prace = new ArrayList<>();
        Zlecenie zlecenie1 = new Zlecenie(true);
        zlecenie1.dodajbrygade(Budowlancy);
        zlecenie1.getstanzlecenia();
        Praca praca1 = new Praca(Praca.Rodzajpracy.Ogolna,2,"kopanie bezdomnych");
        Praca praca2 = new Praca(Praca.Rodzajpracy.Ogolna,3,"kopanie bezdomnych kotów",prace);
        Praca praca3 = new Praca(Praca.Rodzajpracy.Ogolna,1,"kopanie dzieci");
        Praca praca4 = new Praca(Praca.Rodzajpracy.Ogolna,1,"kopanie psów");
        Praca praca5 = new Praca(Praca.Rodzajpracy.Ogolna,1,"kopanie przystanków");
        Praca praca6 = new Praca(Praca.Rodzajpracy.Ogolna,3,"kopanie szpitali");
        Praca praca7 = new Praca(Praca.Rodzajpracy.Ogolna,3,"kopanie pojazdow policijnych");
        prace.add(praca3);
        prace.add(praca4);
        prace.add(praca5);
        zlecenie1.dodajprace(praca1);
        praca1.dodajprace(praca2);
        praca3.dodajprace(praca6);
        praca6.dodajprace(praca7);
        praca4.dodajprace(praca7);
        praca5.dodajprace(praca7);

        System.out.println();
        zlecenie1.getZlecenia();
        Thread watek1 = new Thread(zlecenie1);
        watek1.start();
        wladek.getzlecenia();



    }
}
