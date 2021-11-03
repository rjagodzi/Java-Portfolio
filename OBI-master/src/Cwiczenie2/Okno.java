package Cwiczenie2;

// deklaracja klasy: nazwa klasy jest taka sama jak nazwa pliku
public class Okno {

    // pole prywatne "dlugosc" typu int
    private int dlugosc;

    // pole prywatne "wysokosc" typu int
    private int wysokosc;

    // pole prywatne "liczbaSkrzydel" typu int
    private int liczbaSkrzydel;

    // pole prywatne z tablicą "skrzydla"
    private Skrzydlo[] skrzydla;

    // konstruktor "Okno" z trzema argumentami

    // jeśli pole "i" typu int nie ma większej wartości od pola "lSkrzydel", to do tablicy "skrzydla" dopisywany
    // będzie kolejny obiekt "Skrzydlo" o trzech argumentach, gdzie pierwszy argument podzieli wartość pola "d"
    // przez wartość pola "lSkrzydel"
    public Okno(int d, int w, int lSkrzydel){
        dlugosc = d;                           // ustawienie pola "dlugosc" przy pomocy pierwszego argumentu
        wysokosc = w;                          // ustawienie pola "wysokosc" przy pomocy drugiego argumentu
        liczbaSkrzydel = lSkrzydel;            // ustawienie pola "liczbaSkrzydel" przy pomocy trzeciego argumentu
        skrzydla = new Skrzydlo[lSkrzydel];    // ustawienie liczby skrzydeł nowym obiektem reprezentującym liczbę skrzydeł
        for(int i=0;i<lSkrzydel;i++){
            skrzydla[i] = new Skrzydlo(d/lSkrzydel,w, new Klamka());
        }
    }

    // przeciążony konstruktor "Okno" z trzema argumentami. Pole "liczbaSkrzydel" równa jest długości tablicy "sk"
    public Okno(int d, int w, Skrzydlo[] sk){
        dlugosc = d;                            // ustawienie pola "dlugosc" przy pomocy pierwszego argumentu
        wysokosc = w;                           // ustawienie pola "wysokosc" przy pomocy drugiego argumentu
        liczbaSkrzydel = sk.length;             // pole "liczbaSkrzydel" rowne jest liczbie elementów tablicy "Skrzydlo"
        skrzydla = sk;                          // ustawienie pola skrzydła przy pomocy trzeciego argumentu
    }
    public Okno(int d, int w){
        this(d,w,1);
    }
    public Okno(){
        this(1200,1500,1);
    }

    // metoda dostępowa (getter) czytająca wartość pola
    public int getDlugosc() {
        return dlugosc;
    }

    // metoda dostępowa (setter) ustawiająca wartość pola. Jeśli wartość pola "i" nie jest większa od pola
    // "liczbaSkrzydel", to wykonana zostanie metoda "setDlugosc", gdzie argumentem jest
    // iloraz pól "długość" i "liczbaSkrzydel"
    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
        for(int i=0;i<liczbaSkrzydel;i++){
            skrzydla[i].setDlugosc(dlugosc/liczbaSkrzydel);
        }
    }

    // metoda dostępowa (getter) czytająca wartość pola
    public int getWysokosc() {
        return wysokosc;
    }

    // metoda dostępowa (setter) ustawiająca wartość pola. Ustawiana jest wysokość dla każdego elementu tablicy "skrzydla"
    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
        for(int i=0;i<liczbaSkrzydel;i++){
            skrzydla[i].setWysokosc(wysokosc);
        }
    }

    // metoda dostępowa (getter) czytająca wartość pola
    public int getLiczbaSkrzydel() {
        return liczbaSkrzydel;
    }

    // metoda dostępowa (getter) czytająca wartość pola
    public Skrzydlo[] getSkrzydla() {
        return skrzydla;
    }

    // metoda publiczna, nie zwracająca niczego, ustawiająca dla każdego obiektu tablicy "skrzydla" wartość boolean "true"
    public void otworz(){
        for(int i=0;i<liczbaSkrzydel;i++){
            skrzydla[i].setOtwarte(true);
        }
    }

    // metoda publiczna, nie zwracająca niczego, przerywająca działanie, jeśli pierwszy argument osiągnie wartość większą
    // niż długość tablicy "skrzydla"
    public void otworz(int nrSkrzydla){
        if(nrSkrzydla > skrzydla.length) return;

        skrzydla[nrSkrzydla].setOtwarte(true);

    }

    // metoda publiczna, nie zwracająca niczego, ustawiająca dla każdego obiektu tablicy "skrzydla" wartość boolean "false"
    public void zamknij(){
        for(int i=0;i<liczbaSkrzydel;i++){
            skrzydla[i].setOtwarte(false);
        }
    }

    // metoda publiczna, nie zwracająca niczego, przerywająca działanie, jeśli pierwszy argument osiągnie wartość większą
    // niż długość tablicy "skrzydla"
    public void zamknij(int nrSkrzydla){
        if(nrSkrzydla > skrzydla.length) return;

        skrzydla[nrSkrzydla].setOtwarte(false);

    }

    // metoda publiczna wypisująca na konsoli wartość każdego elementu tablicy "skrzydla"
    public void wypiszStan() {
        String tekst = "";
        for(int i=0;i<liczbaSkrzydel;i++){
            tekst += "["+skrzydla[i].stan()+"]";
        }
        System.out.println(tekst);

    }

}
