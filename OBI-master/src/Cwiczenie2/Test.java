package Cwiczenie2;

import Cwiczenie2.Klamka;
import Cwiczenie2.Okno;

// deklaracja klasy: nazwa klasy jest taka sama jak nazwa pliku
public class Test {

    // metoda statyczna main wywoływana w trakcie uruchomienia tego pliku
    public static void main(String[] args) {

        // utworzenie bezargumentowego obiektu
        Okno okno1 = new Okno();

        // utworzenie obiektu z trzema argumentami i zainicjowanie ich poprzez przypisanie im początkowych wartości
        Okno okno2 = new Okno(1800,1800,3);

        // wykorzystanie metody "otworz" z klasy "Okno" w celu ustawienia wartości obiektu "okno1" na "true"
        okno1.otworz();

        // wykorzystanie metody "otworz" z klasy "Okno" w celu ustawienia wartości konkretnych
        // argumentów tablicy "lSkrzydel" obiektu "okno2" na "true"
        okno2.otworz(0);
        okno2.otworz(2);

        // wykorzystanie metody "wypiszStan" w celu wypisania na konsoli wartości obu obiektów
        okno1.wypiszStan();
        okno2.wypiszStan();

        // ustawienie wartości obiektu "okno1" na "false"
        okno1.zamknij();

        // przypisanie nowej wartości dla pierwszego argumentu obiektu "okno2"
        okno2.setDlugosc(2100);

        // ustawienie wartości pierwszego elementu tablicy "lSkrzydel" na false
        okno2.zamknij(0);

        // utworzenie nowego, bezargumentowego obiektu
        Klamka kl = new Klamka();

        // ustawienie wartości obiektu "kl" na "true" przy pomocy metody "setCzyKluczyk"
        kl.setCzyKluczyk(true);
        okno2.getSkrzydla()[1].setKlamka(kl);
        okno2.getSkrzydla()[2].setKlamka(null);

        // wykorzystanie metody "wypiszStan" w celu wypisania na konsoli wartości obu obiektów
        okno1.wypiszStan();
        okno2.wypiszStan();

    }
}
