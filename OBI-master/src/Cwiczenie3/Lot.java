package Cwiczenie3;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Lot {

    private UUID id;
    private LocalDateTime odlot;
    private LocalDateTime przylot;
    private Samolot samolot;
    private Grafik grafik;
    private List<Pasazer> pasazerowie;
    private Queue<Pasazer> kolejkaOczekujacych;

    public Lot(LocalDateTime odlot, LocalDateTime przylot, Grafik grafik, List<Pasazer> pasazerowie, Queue<Pasazer> kolejkaOczekujacych) {
        this.id = UUID.randomUUID();
        this.odlot = odlot;
        this.przylot = przylot;
        this.grafik = grafik;
        this.pasazerowie = pasazerowie;
        this.kolejkaOczekujacych = kolejkaOczekujacych;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getOdlot() {
        return odlot;
    }

    public LocalDateTime getPrzylot() {
        return przylot;
    }

    public Grafik getGrafik() {
        return grafik;
    }

    public List<Pasazer> getPasazerowie() {
        return pasazerowie;
    }

    public  Queue<Pasazer> getKolejkaOczekujacych() {
        return kolejkaOczekujacych;
    }

    void dodajPasazera(Pasazer pasazer) {
        pasazerowie.add(pasazer);
    }

}
