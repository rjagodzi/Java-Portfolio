package Cwiczenie3;

import java.time.LocalDateTime;
import java.util.*;

public class SystemowaKlasa {

    private final List<Pasazer> listaPasazerow;
    private final List<Lot> listaLotow;
    private final List<Grafik> listaGrafikow;
    private final List<Samolot> listaSamolotow;
    private final List<Lotnisko> lotniska;

    public SystemowaKlasa() {
        this.listaPasazerow = new ArrayList<>();
        this.listaLotow = new ArrayList<>();
        this.listaGrafikow = new ArrayList<>();
        this.listaSamolotow = new ArrayList<>();
        this.lotniska = new ArrayList<>();
    }

    public List<Pasazer> getListaPasazerow() {
        return listaPasazerow;
    }

    public List<Lot> getListaLotow() {
        return listaLotow;
    }

    public List<Grafik> getListaGrafikow() {
        return listaGrafikow;
    }

    public List<Samolot> getListaSamolotow() {
        return listaSamolotow;
    }

    public List<Lotnisko> getLotniska() {
        return lotniska;
    }

    void dodajLot(Lot lot) {
        listaLotow.add(lot);
    }

    void dodajGrafik(Grafik grafik) {
        listaGrafikow.add(grafik);
    }

    void dodajSamolot(Samolot samolot) {
        listaSamolotow.add(samolot);
    }

    void dodajPasazera(Pasazer pasazer) {
        listaPasazerow.add(pasazer);
    }


    public Lotnisko znajdzGrafik(Lotnisko lotnisko) {
        return listaGrafikow.stream()
                .filter(grafik -> grafik.getMiejscePrzylotu().getOznaczenie() == lotnisko.getOznaczenie())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getMiejscePrzylotu();
    }

    public Lot znajdzNajblizszyLot(Lotnisko lotnisko, LocalDateTime odKiedy) {
        return listaLotow.stream()
                .sorted(Comparator.comparing(Lot::getOdlot))
                .filter(lot -> lot.getOdlot().isAfter(odKiedy))
                .filter(lot -> lot.getGrafik().getMiejscePrzylotu().getOznaczenie() == lotnisko.getOznaczenie())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void dodajPasazeraDoLotu(Samolot samolot, Pasazer pasazer, UUID id) {
        znajdzLot(id).ifPresent(lot -> {
            if (samolot.getLiczbaMiejsc() > lot.getPasazerowie().size()) {
                lot.dodajPasazera(pasazer);
            }
        });
    }

    private Optional<Lot> znajdzLot(UUID id) {
        return listaLotow.stream()
                .filter(lot -> lot.getId().equals(id))
                .findFirst();
    }

    public Lot przesunPasazera(Pasazer pasazer, Lot lot) {
        lot.getPasazerowie().remove(pasazer);
        lot.getPasazerowie().add(lot.getKolejkaOczekujacych().poll());
        return lot;
    }
}
