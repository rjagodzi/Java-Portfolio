package Cwiczenie3;

import java.util.EnumMap;

public class Lotnisko {

    private final String oznaczenie;
    private final String miejscowosc;

    public Lotnisko(String oznaczenie, String miejscowosc) {
        this.oznaczenie = oznaczenie;
        this.miejscowosc = miejscowosc;
    }

    public String getOznaczenie() {
        return oznaczenie;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }
}
