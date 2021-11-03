package Cwiczenie3;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

public class Pasazer {

    private final Long id;
    private final String imie;
    private final String nazwisko;
    private final List<Bilet> bilet;

    public Pasazer(Long id, String imie, String nazwisko, List<Bilet> bilet) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.bilet = bilet;
    }

    public Long getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public List<Bilet> getBilet() {
        return bilet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasazer pasazer = (Pasazer) o;
        return Objects.equals(id, pasazer.id) &&
                Objects.equals(imie, pasazer.imie) &&
                Objects.equals(nazwisko, pasazer.nazwisko) &&
                Objects.equals(bilet, pasazer.bilet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imie, nazwisko, bilet);
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " ";
    }
}
