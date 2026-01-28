package com.system.tests;

import com.wiezienie.logic.BazaDanych;
import com.wiezienie.logic.Model;
import com.wiezienie.logic.RejestracjaIncydentu;

public class RejestracjaIncydentuFixture {
    private int idWieznia;
    private int idPracownika;
    private String opis;

    public void setIdWieznia(int id) { this.idWieznia = id; }
    public void setIdPracownika(int id) { this.idPracownika = id; }
    public void setOpis(String opis) { this.opis = opis; }

    public String sprawdzZatwierdzenie() {
        // Inicjalizacja zależności
        BazaDanych baza = new BazaDanych(null);
        Model model = new Model(baza, null);
        
        // Wywołanie Fasady
        RejestracjaIncydentu fasada = new RejestracjaIncydentu(model, idWieznia, idPracownika, opis);
        return fasada.ZatwierdzDane();
    }
}