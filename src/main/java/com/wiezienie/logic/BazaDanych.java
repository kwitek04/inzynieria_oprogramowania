package com.wiezienie.logic;

public class BazaDanych {
    private IDAO dao;
    public BazaDanych(IDAO dao) { this.dao = dao; }
    public IPracownik zwrocPracownika(int id) { return (id > 0) ? new Pracownik(id) : null; }
    public IWiezien zwrocWieznia(int id) { return (id > 0) ? new Wiezien(id) : null; }
}