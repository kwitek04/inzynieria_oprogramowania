package com.system.tests;

import fit.ColumnFixture;
import com.wiezienie.logic.*;

public class RejestracjaIncydentuFixture extends ColumnFixture {

    public int idWieznia;
    public int idPracownika;
    public String opis;

    public String sprawdzZatwierdzenie() {
        BazaDanych baza = new BazaDanych(null);
        Model model = new Model(baza, null);

        RejestracjaIncydentu fasada = new RejestracjaIncydentu(model, idWieznia, idPracownika, opis);
        return fasada.ZatwierdzDane();
    }
}