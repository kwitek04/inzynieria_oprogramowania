package com.example.model;

public class BazaDanych implements IDAO {

    private ZarzadzanieWiezieniami wiezienia;

    public BazaDanych(ZarzadzanieWiezieniami wiezienia) {
        this.wiezienia = wiezienia;
    }

    @Override
    public boolean dodajWiezienie(Wiezienie w) {
        return wiezienia.dodajWiezienie(w);
    }

    @Override
    public boolean usuniecieWiezienia(int id) {
        return wiezienia.usuniecieWiezienia(id);
    }

    @Override
    public Wiezienie znajdzWiezienie(int id) {
        return wiezienia.znajdzWiezienie(id);
    }
}