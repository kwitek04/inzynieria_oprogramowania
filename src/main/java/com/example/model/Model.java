package com.example.model;

public class Model {
    private IDAO dao;

    public Model(IDAO dao) {
        this.dao = dao;
    }

    public boolean zapiszRekord(String tabela, Object dane) {
        if ("Wiezienie".equals(tabela)) {
            Wiezienie w = (Wiezienie) dane;
            return dao.dodajWiezienie(w);
        }
        return false;
    }
}