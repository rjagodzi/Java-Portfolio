package Cwiczenie3;

import java.time.*;

public class Bilet {

    private Pasazer pasazer;
    private double cena;
    private Lot lot;
    private String bagaz;

    public Bilet(Pasazer pasazer, double cena, Lot lot, String bagaz){
        this.pasazer = pasazer;
        this.cena = cena;
        this.lot = lot;
        this.bagaz = bagaz;
    }

    public double getCena() {
        return cena;
    }

    public Lot getLot() {
        return lot;
    }

    public Pasazer getPasazer() {
        return pasazer;
    }

    public String getBagaz() {
        return bagaz;
    }

    @Override
    public String toString() {
        return "kupił bilet w cenie " + cena + " zł" +
                " na lot " + lot;
    }
}
