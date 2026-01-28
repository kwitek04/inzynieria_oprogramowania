package com.system.tests;

import com.example.testyfitnesse.SetUp;
import fit.ColumnFixture;

public class TestDodaniaWiezienia extends ColumnFixture {
    // Pola publiczne odpowiadające kolumnom w tabeli FitNesse (DANE WEJŚCIOWE)
    public String nazwa;
    public String lokalizacja;
    public int liczbaCel;
    // Te pola musza byc publiczne i nazwane tak jak naglowki w tabeli!

    // Metoda wykonująca test (odpalana dla każdego wiersza)
    public boolean dodajWiezienie() {
        // 1. Sprawdzamy stan przed
        int stanPrzed = SetUp.manager.pobierzLiczbeWiezien();

        // 2. Wywołujemy kontroler (symulujemy wpisanie danych i kliknięcie)
        SetUp.kontroler.ustawDane(nazwa, lokalizacja, liczbaCel, "Standard", "Active");
        SetUp.kontroler.zatwierdzDodanieWiezienia();

        // 3. Sprawdzamy stan po
        int stanPo = SetUp.manager.pobierzLiczbeWiezien();

        // 4. Test przechodzi, jeśli liczba więzień wzrosła o 1
        return stanPo == stanPrzed + 1;
    }

    // Metoda zwracająca aktualny stan (DANE WYJŚCIOWE)
    public int liczbaWiezien() {
        return SetUp.manager.pobierzLiczbeWiezien();
    }
}