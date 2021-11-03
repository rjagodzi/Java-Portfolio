package Cwiczenie2;

// deklaracja klasy: nazwa klasy jest taka sama jak nazwa pliku
public class Klamka {

    // pole prywatne "czyKluczyk" typu boolean zainicjowana wartością "false"
    private boolean czyKluczyk = false;

    // metoda dostępowa zwracająca wartość pola "czyKluczyk"
    public boolean isCzyKluczyk() {
        return czyKluczyk;
    }

    // metoda publiczna nie zwracająca niczego i przyjmująca jeden argument typu boolean
    // metoda wykorzystuje operatora "this" w celu przesłonienia nazwy zmiennej lokalnej o takim samym polu
    public void setCzyKluczyk(boolean czyKluczyk) {
        this.czyKluczyk = czyKluczyk;
    }

    // metoda publiczna typu String
    public String stan() {
        return czyKluczyk ? "z kluczem": "bez klucza";
    }
}
