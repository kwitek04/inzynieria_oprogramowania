package com.wiezienie.logic;
import java.util.*;

// Interfejsy bez 'public' mogą być w jednym pliku
interface IPracownik { int getid(); String opisz(); }
interface IWiezien { int getid(); String opisz(); }
interface IIncydent { String getOpis(); String opisz(); }
interface IFabrykaIncydentu { IIncydent utworzIncydent(String opis); }
interface IDAO {
    String znalezienieWieznia(int idWieznia);
    String znalezieniePracownika(int idPracownika);
    String dodajIncydent(IIncydent incydent);
}
interface IModel {
    String znalezienieWieznia(int idWieznia);
    String znalezieniePracownika(int idPracownika);
    boolean zarejestrowanieIncydentu(RejestracjaIncydentu Kontroler);
}

// Klasy pomocnicze
class Pracownik implements IPracownik {
    private int id;
    public Pracownik(int id) { this.id = id; }
    public int getid() { return id; }
    public String opisz() { return "Pracownik o ID: " + id; }
}

class Wiezien implements IWiezien {
    private int id;
    public Wiezien(int id) { this.id = id; }
    public int getid() { return id; }
    public String opisz() { return "Wiezien o ID: " + id; }
}

class Incydent implements IIncydent {
    private String opis;
    public Incydent(String opis) { this.opis = opis; }
    public String getOpis() { return opis; }
    public String opisz() { return "Incydent: " + opis; }
}

// Główna klasa publiczna
public class RejestracjaIncydentu {
    private IModel model;
    private int idWieznia, idPracownika;
    private String opis;

    public RejestracjaIncydentu(IModel model, int idW, int idP, String opis) {
        this.model = model;
        this.idWieznia = idW;
        this.idPracownika = idP;
        this.opis = opis;
    }

    public String ZatwierdzDane() {
        String wiezien = model.znalezienieWieznia(idWieznia);
        String pracownik = model.znalezieniePracownika(idPracownika);

        if (wiezien.length() > 0 && pracownik.length() > 0) {
            model.zarejestrowanieIncydentu(this);
            return "SUKCES";
        } else {
            return "BLAD_WALIDACJI";
        }
    }
}