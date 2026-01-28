package com.wiezienie.fixtures;
import com.wiezienie.logic.*;

public class RejestracjaIncydentuFixture {
    private int idWieznia;
    private int idPracownika;
    private String opis;

    public void setIdWieznia(int id) { this.idWieznia = id; }
    public void setIdPracownika(int id) { this.idPracownika = id; }
    public void setOpis(String opis) { this.opis = opis; }

    public String sprawdzZatwierdzenie() {

        BazaDanych baza = new BazaDanych(null);
        Model model = new Model(baza, null);

        RejestracjaIncydentu fasada = new RejestracjaIncydentu(model, idWieznia, idPracownika, opis);
        return fasada.ZatwierdzDane();
    }
}