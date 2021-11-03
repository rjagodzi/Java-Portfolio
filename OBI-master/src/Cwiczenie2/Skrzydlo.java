package Cwiczenie2;

// deklaracja klasy: nazwa klasy jest taka sama jak nazwa pliku
public class Skrzydlo {

    // prywatne pole "dlugosc" typu int
    private int dlugosc;

    // prywatne pole "wysokosc" typu int
    private int wysokosc;

    // prywatne pole "klamka" typu Klamka
    private Klamka klamka;

    // utworzenie prywatnego pola "otwarte" typu boolean i ustawienie jego wartości na "false"
    private boolean otwarte = false;

    // utworzenie konstruktora z dwoma argumentami "dlugosc" i "wysokosc" typu int
    public Skrzydlo(int dlugosc, int wysokosc) {
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
    }

    // utworzenie konstruktora z trzema argumentami "dlugosc", "wysokosc" i "klamka" typu int i Klamka
    public Skrzydlo(int dlugosc, int wysokosc, Klamka klamka) {
        this(dlugosc,wysokosc);
        this.klamka = klamka;
    }
    // metoda dostepowa getter czytająca wartość pola
    public int getDlugosc() {
        return dlugosc;
    }

    // metoda dostepowa getter czytająca wartość pola
    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    // metoda dostepowa getter czytająca wartość pola
    public int getWysokosc() {
        return wysokosc;
    }

    // metoda dostepowa setter ustawiająca wartość pola
    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    // metoda dostepowa getter czytająca wartość pola
    public Klamka getKlamka() {
        return klamka;
    }

    // metoda dostepowa setter ustawiająca wartość pola
    public void setKlamka(Klamka klamka) {
        this.klamka = klamka;
    }

    // metoda zwracająca wartość boolean "otwarte"
    public boolean isOtwarte() {
        return otwarte;
    }

    // metoda dostepowa setter ustawiająca wartość pola
    public void setOtwarte(boolean otwarte) {
        this.otwarte = otwarte;
    }

    // metoda wypisująca stan konsoli zwraca wymiary skrzydła. W operatorze trójargumentowym sprawdza, czy skrzydło
    // jest otwarte, czy zamknięte. Następnie w operatorze trójargumentowym sprawdza, czy klamka jest nullem.
    // Jeśli tak, to zwraca wynik "bez klamki". W przeciwnym wypadku sprawdza stan klamki i obecność klucza
    public String stan() {
        String wymiary = dlugosc+"x"+wysokosc;
        String otwarcie = otwarte ? "otwarte" : "zamkniete";
        String stanKlamki = klamka!= null ? klamka.stan() : "bez klamki";
        return wymiary  +" "+ otwarcie +" "+ stanKlamki;
    }
}
