package com.example.controller;

import com.example.model.Model;
import com.example.model.Wiezienie;
import com.example.view.PrzekazanieInformacji;

public class DodajWiezienie {

    private Model model;
    private PrzekazanieInformacji widok;

    private String nazwa;
    private String lokalizacja;
    private int liczbaCel;
    private String poziomBezpieczenstwa;
    private String status;

    public DodajWiezienie(Model model, PrzekazanieInformacji widok) {
        this.model = model;
        this.widok = widok;
    }

    public void ustawDane(String nazwa, String lokalizacja, int liczbaCel, String poziom, String status) {
        this.nazwa = nazwa;
        this.lokalizacja = lokalizacja;
        this.liczbaCel = liczbaCel;
        this.poziomBezpieczenstwa = poziom;
        this.status = status;
    }

    public void zatwierdzDodanieWiezienia() {
        boolean czyDanePoprawne = (nazwa != null && nazwa.length() > 0) &&
                (lokalizacja != null && lokalizacja.length() > 0) &&
                (liczbaCel > 0);

        if (czyDanePoprawne) {
            Wiezienie w = new Wiezienie(nazwa, lokalizacja, liczbaCel);
            w.setPoziomBezpieczenstwa(poziomBezpieczenstwa);
            w.setStatus(status);

            boolean wynik = model.zapiszRekord("Wiezienie", w);

            if (wynik) {
                widok.przekazanieInformacji("Sukces: Więzienie dodane.");
            } else {
                widok.przekazanieInformacji("Błąd: Nie udało się zapisać w bazie.");
            }
        } else {
            widok.przekazanieInformacji("Błąd walidacji: Wypełnij wszystkie pola!");
        }
    }
}