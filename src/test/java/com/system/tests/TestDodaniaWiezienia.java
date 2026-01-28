package com.system.tests;

import fit.ColumnFixture;

public class TestDodaniaWiezienia extends ColumnFixture {
    public String nazwa;
    public String lokalizacja;
    public int liczbaCel;

    public boolean dodajWiezienie() {

        int initialCount = SetUp.prisonManager.pobierzLiczbeWiezien();

        SetUp.prisonController.ustawDane(nazwa, lokalizacja, liczbaCel, "Standard", "Active");
        SetUp.prisonController.zatwierdzDodanieWiezienia();

        int afterCount = SetUp.prisonManager.pobierzLiczbeWiezien();
        return afterCount == initialCount + 1;
    }

    public int liczbaWiezien() {
        return SetUp.prisonManager.pobierzLiczbeWiezien();
    }
}