package com.wiezienie.logic;

public class Model implements IModel {
    private BazaDanych baza;
    private IDAO dao;

    public Model(BazaDanych baza, IDAO dao) {
        this.baza = baza;
        this.dao = dao;
    }

    public String znalezieniePracownika(int id) {
        IPracownik p = baza.zwrocPracownika(id);
        return (p != null) ? p.opisz() : "";
    }

    public String znalezienieWieznia(int id) {
        IWiezien w = baza.zwrocWieznia(id);
        return (w != null) ? w.opisz() : "";
    }

    public boolean zarejestrowanieIncydentu(RejestracjaIncydentu Kontroler) {
        return true; 
    }
}