package com.system.tests;

import fit.Fixture;
// Importy Twoje
import com.example.model.ZarzadzanieWiezieniami;
import com.example.model.BazaDanych;
import com.example.model.Model;
import com.example.controller.DodajWiezienie;
import com.example.view.PrzekazanieInformacji;
// Importy Kolegi
import com.wiezienie.fixtures.RejestracjaIncydentuFixture;

public class SetUp extends Fixture {

    // --- CZĘŚĆ 1: TWÓJ MODUŁ ---
    public static ZarzadzanieWiezieniami twojManager;
    public static DodajWiezienie twojKontroler;

    // --- CZĘŚĆ 2: MODUŁ KOLEGI ---
    // Tutaj udostępniamy fixturę kolegi jako obiekt statyczny
    public static RejestracjaIncydentuFixture fixtureKolegi;

    public SetUp() {
        // A. Inicjalizacja Twojego modułu
        twojManager = new ZarzadzanieWiezieniami();
        BazaDanych twojaBaza = new BazaDanych(twojManager);
        Model twojModel = new Model(twojaBaza);
        PrzekazanieInformacji twojWidok = new PrzekazanieInformacji();
        twojKontroler = new DodajWiezienie(twojModel, twojWidok);

        // B. Inicjalizacja modułu Kolegi
        // Tworzymy instancję, żeby była gotowa do użycia w testach
        fixtureKolegi = new RejestracjaIncydentuFixture();
    }
}