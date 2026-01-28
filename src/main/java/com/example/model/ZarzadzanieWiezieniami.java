package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class ZarzadzanieWiezieniami {
    private List<Wiezienie> lista = new ArrayList<>();

    public boolean dodajWiezienie(Wiezienie w) {
        if (w != null) {
            return lista.add(w);
        }
        return false;
    }

    public boolean usuniecieWiezienia(int id) {
        return lista.removeIf(w -> w.getId() == id);
    }

    public Wiezienie znajdzWiezienie(int id) {
        return lista.stream()
                .filter(w -> w.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public int pobierzLiczbeWiezien() {
        return lista.size();
    }
}