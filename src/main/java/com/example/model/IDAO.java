package com.example.model;

public interface IDAO {
    boolean dodajWiezienie(Wiezienie w);
    boolean usuniecieWiezienia(int id);
    Wiezienie znajdzWiezienie(int id);
}