package Cwiczenie3;

public class Samolot {

    private String nazwa;
    private int liczbaMiejsc;

    public Samolot(String nazwa, int liczbaMiejsc) {
        this.nazwa = nazwa;
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    @Override
    public String toString() {
        return nazwa + liczbaMiejsc;
    }
}
