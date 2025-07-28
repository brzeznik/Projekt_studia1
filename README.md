    Zapytanie zostało przetworzone

Projekt Systemu Zarządzania Zadaniami (Java)

Ten projekt to prosta aplikacja w języku Java, stworzona w celach edukacyjnych, z głównym naciskiem na praktyczne zastosowanie wielowątkowości. Symuluje system zarządzania zadaniami, pracownikami i zleceniami w firmie.

Główne cechy projektu:

    Zarządzanie Pracownikami i Działami:

        Definiowanie pracowników ( Pracownik ) z imieniem, nazwiskiem, datą urodzenia i przypisanym działem.

        Specjalizacje dla pracowników ( Specjalista ).

        Organizacja pracowników w działy ( DzialPracownikow ) z obsługą unikalności nazw działów.

    Brygady i Brygadziści:

        Tworzenie brygad ( Brygada ) z przypisanym brygadzistą ( Brygadzista ).

        Możliwość dodawania pracowników do brygad.

        Brygadziści mają listę przypisanych im brygad oraz zleceń, w których uczestniczą.

    Zlecenia i Prace:

        Definiowanie zleceń ( Zlecenie ) z różnymi rodzajami (planowane/nieplanowane), stanami (utworzone, rozpoczęte, zakończone) i unikalnym ID.

        Zlecenia są powiązane z brygadami.

        Wewnątrz zleceń definiowane są pojedyncze prace ( Praca ) z rodzajem, czasem trwania i opisem.

        Prace mogą mieć zależności (prace "do zrobienia" przed i "po zrobieniu" danej pracy).

    Wielowątkowość (kluczowy element projektu):

        Klasy Zlecenie i Praca implementują Runnable lub dziedziczą po Thread, co pozwala na ich asynchroniczne wykonywanie.

        Każde Zlecenie działa w osobnym wątku, a w jego ramach każda Praca również może być uruchomiona w osobnym wątku.

        Wykorzystano mechanizmy synchronizacji (np. synchronized) w klasie Praca do zarządzania dostępem do zasobów (np. zapis do pliku logu).

        Symulacja czasu trwania prac za pomocą Thread.sleep().

        Obsługa zależności między pracami (za pomocą join()), zapewniająca, że niektóre prace rozpoczną się dopiero po zakończeniu innych.

    Generowanie logów:

        Zlecenia i prace zapisują informacje o swoim stanie (rozpoczęcie, zakończenie) do plików tekstowych, tworząc prosty system logowania.

Cel projektu:

Głównym celem tego projektu było zrozumienie i praktyczne zastosowanie koncepcji wielowątkowości w Javie. Poprzez symulację realnego systemu zarządzania zadaniami, mogłem zbadać takie aspekty jak:

    Tworzenie i zarządzanie wątkami.

    Synchronizacja wątków i unikanie wyścigów danych.

    Obsługa zależności między zadaniami wykonywanymi równolegle.

    Zapisywanie stanu zadań w kontekście wielowątkowym.

Jak uruchomić projekt:

    Sklonuj repozytorium na swój lokalny komputer.

    Otwórz projekt w swoim ulubionym IDE (np. IntelliJ IDEA, Eclipse).

    Uruchom plik Main.java.

Uwaga: Projekt generuje pliki tekstowe (ZlecenieX.txt) w katalogu, z którego uruchamiany jest program.
