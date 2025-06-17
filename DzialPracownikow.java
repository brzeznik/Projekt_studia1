package projekt1;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class DzialPracownikow{
    final private String nazwa;
    private static HashMap<String,ArrayList<Pracownik>> map = new HashMap<String,ArrayList<Pracownik>>();

    public DzialPracownikow(String nazwa) throws NotUniqueNameException{
    if(map.containsKey(nazwa)){
        throw new NotUniqueNameException();
    }else{
        map.put(nazwa,new ArrayList<>());
    }

        this.nazwa = nazwa;

    }
    public static class NotUniqueNameException extends Exception{
        public NotUniqueNameException(){
            super("Nazwy działów nie mogą być takie same!");
        }
    }
    public static DzialPracownikow createDzial(String nazwa) throws NotUniqueNameException{

        return new DzialPracownikow(nazwa);
    }

    @Override
    public String toString() {
        return "Dział: "+this.nazwa;
    }

    public static Collection<Pracownik> wypisz(String dzial){
        if (map.containsKey(dzial)){
            System.out.println("Pracownicy z dzialu "+dzial+":");
            List<Pracownik> pracownicy = map.get(dzial);
            if(pracownicy != null && !pracownicy.isEmpty()){
                for (Pracownik pracownik : pracownicy){
                    System.out.println(pracownik);
                }
            }

        }
        return null;
    }

    public static boolean getkey(String key) {
        return map.containsKey(key);
    }

    public static ArrayList<Pracownik> dodaj(String key, ArrayList<Pracownik> value){
       return map.put(key,value);
    }

    public static void dodaj(String klucz,Pracownik zmienna){
        map.get(klucz).add(zmienna);
    }
}

