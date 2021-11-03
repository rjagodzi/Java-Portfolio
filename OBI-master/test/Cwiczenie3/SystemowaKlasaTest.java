package Cwiczenie3;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SystemowaKlasaTest {

   private SystemowaKlasa systemowaKlasa;
    Grafik grafik = stworzGrafik(new Lotnisko("ZRH", "Zurych"), new Lotnisko("WAW", "Wa"));
    Grafik grafik1 = stworzGrafik(new Lotnisko("POZ", "Poznan"), new Lotnisko("WAW", "Warszawa"));
    Grafik grafik2 = stworzGrafik(new Lotnisko("WRO", "Wroclaw"), new Lotnisko("ZRH", "Zurych"));

    @Before
    public void before() {
        systemowaKlasa = new SystemowaKlasa();

        Queue<Pasazer> kolejkaPasazerow = new LinkedList<>();

        Samolot samolot = new Samolot("Airbus", 130);
        Pasazer pasazer1 = stworzPasazera(1L, "Jan", "Kowalski");
        Pasazer pasazer2 = stworzPasazera(2L, "Adam", "Nowak");

        Lot lot1 = new Lot(LocalDateTime.of(2019, 9, 29, 11, 10), LocalDateTime.of(2019, 12, 12, 12, 12), grafik2, Arrays.asList(pasazer1, pasazer2), kolejkaPasazerow);
        Lot lot2 = new Lot(LocalDateTime.of(2019, 9, 30, 20, 10), LocalDateTime.of(2019, 12, 15, 23, 12), grafik, Arrays.asList(pasazer1, pasazer2), kolejkaPasazerow);
        Lot lot3 = new Lot(LocalDateTime.of(2019, 7, 12, 20, 55), LocalDateTime.of(2019, 12, 19, 22, 12), grafik, Arrays.asList(pasazer1, pasazer2), kolejkaPasazerow);

        systemowaKlasa.dodajLot(lot1);
        systemowaKlasa.dodajLot(lot2);
        systemowaKlasa.dodajLot(lot3);
        systemowaKlasa.dodajGrafik(grafik);
        systemowaKlasa.dodajGrafik(grafik1);
        systemowaKlasa.dodajGrafik(grafik2);
        systemowaKlasa.dodajPasazera(pasazer1);
        systemowaKlasa.dodajSamolot(samolot);
    }

    @Test
    public void znajdzNajblizszyLotDoWybranegoLotniskaOdOkreslonejDaty() {
        //given
        LocalDateTime odKiedy = LocalDateTime.of(2019, 9, 10, 23, 30);

        //when
        Lot rezultat = systemowaKlasa.znajdzNajblizszyLot(grafik.getMiejsceOdlotu(), odKiedy);

        //then
        assertEquals(rezultat.getGrafik().getMiejscePrzylotu(), systemowaKlasa.znajdzGrafik(grafik.getMiejsceOdlotu()));
        assertTrue(rezultat.getOdlot().isAfter(odKiedy));
        systemowaKlasa.getListaLotow().forEach(lot -> {
            if (!lot.getId().equals(rezultat.getId()) && lot.getOdlot().isAfter(odKiedy)) {
                assertTrue(lot.getOdlot().isAfter(rezultat.getOdlot()));
            }
        });
    }

    //TODO: dopisywanie pasazerow do lotu a nie do klasy systemowej
    @Test
    public void dodawaniePasazera() {
        //given
        Pasazer pasazer = new Pasazer(1L, "Jan", "Kowalski", Arrays.asList());
        List<Pasazer> list = new ArrayList<>(1);
        list.add(pasazer);
        Lot lot = new Lot(
                LocalDateTime.now(),
                LocalDateTime.now(),
                Grafik.of(new Lotnisko("ZRH", "Zurych"), new Lotnisko("WAW", "Warszawa")),
                list,
                new LinkedList<>());
        SystemowaKlasa systemowaKlasaDlaPasazera = new SystemowaKlasa();
        Samolot samolot = new Samolot("Airbus", 1);
        systemowaKlasaDlaPasazera.dodajLot(lot);

        //when
        systemowaKlasaDlaPasazera.dodajPasazeraDoLotu(samolot, pasazer, lot.getId());

        //then
        assertEquals(1, lot.getPasazerowie().size());
    }


    @Test
    public void dodawaniePasazeraDoPelnegoSamolotu() {
        //given
        Pasazer pasazer = new Pasazer(1L, "Jan", "Kowalski", Arrays.asList());
        List<Pasazer> list = new ArrayList<>(1);
        list.add(pasazer);
        Lot lot = new Lot(
                LocalDateTime.now(),
                LocalDateTime.now(),
                Grafik.of(new Lotnisko("ZRH", "Zurych"), new Lotnisko("WAW", "Warszawa")),
                list,
                new LinkedList<>());
        SystemowaKlasa systemowaKlasaDlaPasazera = new SystemowaKlasa();
        Samolot samolot = new Samolot("Airbus", 1);
        systemowaKlasaDlaPasazera.dodajLot(lot);

        //when
        systemowaKlasaDlaPasazera.dodajPasazeraDoLotu(samolot, pasazer, lot.getId());

        //then
        assertEquals(1, lot.getPasazerowie().size());
    }

    @Test
    public void przesunieciePasazeraZKolejkiJesliZwolniSieMiejsce() {
        //given
        Pasazer pasazer = new Pasazer(1L, "Jan", "Kowalski", Arrays.asList());
        Pasazer pasazer2 = new Pasazer(2L, "Adam", "Nowak", Arrays.asList());
        List<Pasazer> list = new ArrayList<>(1);
        list.add(pasazer);
        Queue<Pasazer> kolejkaPasazerow = new LinkedList<>(Arrays.asList(pasazer2));
        Lot lot = new Lot(
                LocalDateTime.now(),
                LocalDateTime.now(),
                Grafik.of(new Lotnisko("ZRH", "Zurych"), new Lotnisko("WAW", "Warszawa")),
                list,
                kolejkaPasazerow);
        SystemowaKlasa systemowaKlasaDlaPasazera = new SystemowaKlasa();
        systemowaKlasaDlaPasazera.dodajLot(lot);

        //when
        Lot lotPoPrzesunieciuPasazera = systemowaKlasaDlaPasazera.przesunPasazera(pasazer, lot);

        //then
        assertEquals(0, lotPoPrzesunieciuPasazera.getKolejkaOczekujacych().size());
        assertEquals(1, lotPoPrzesunieciuPasazera.getPasazerowie().size());
        assertEquals(pasazer2, lotPoPrzesunieciuPasazera.getPasazerowie().get(0));
    }

    private Pasazer stworzPasazera(Long id, String imie, String nazwisko) {
        return new Pasazer(id, imie, nazwisko, Arrays.asList());
    }

    private Grafik stworzGrafik(Lotnisko od, Lotnisko cel) {
        return Grafik.of(od, cel);
    }
}

