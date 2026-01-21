package com.example.model;

public class Wiezienie {
    private int id;
    private String nazwa;
    private String lokalizacja;
    private int liczbaCel;
    private String poziomBezpieczenstwa;
    private String status;

    public Wiezienie(int id, String nazwa, String lokalizacja, int liczbaCel, String poziomBezpieczenstwa, String status) {
        this.id = id;
        this.nazwa = nazwa;
        this.lokalizacja = lokalizacja;
        this.liczbaCel = liczbaCel;
        this.poziomBezpieczenstwa = poziomBezpieczenstwa;
        this.status = status;
    }

    public Wiezienie(String nazwa, String lokalizacja, int liczbaCel) {
        this.nazwa = nazwa;
        this.lokalizacja = lokalizacja;
        this.liczbaCel = liczbaCel;
    }

    public Wiezienie() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNazwa() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }

    public String getLokalizacja() { return lokalizacja; }
    public void setLokalizacja(String lokalizacja) { this.lokalizacja = lokalizacja; }

    public int getLiczbaCel() { return liczbaCel; }
    public void setLiczbaCel(int liczbaCel) { this.liczbaCel = liczbaCel; }

    public String getPoziomBezpieczenstwa() { return poziomBezpieczenstwa; }
    public void setPoziomBezpieczenstwa(String poziomBezpieczenstwa) { this.poziomBezpieczenstwa = poziomBezpieczenstwa; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}