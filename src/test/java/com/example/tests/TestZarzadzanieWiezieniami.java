package com.example.tests;

import com.example.model.Wiezienie;
import com.example.model.ZarzadzanieWiezieniami;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Zadanie 1: Testy operacji niezależnych (Manager)")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("Unit")
public class TestZarzadzanieWiezieniami {

    private ZarzadzanieWiezieniami manager;

    @BeforeEach
    void setUp() {
        manager = new ZarzadzanieWiezieniami();
    }

    @Test
    @Order(1)
    @DisplayName("1. Dodanie poprawnego więzienia powinno zwrócić true")
    void testDodajWiezienie() {
        Wiezienie w = new Wiezienie("Sztum", "Sztum", 500);

        boolean wynik = manager.dodajWiezienie(w);

        assertTrue(wynik, "Metoda dodajWiezienie powinna zwrócić true");
        assertNotNull(manager.znajdzWiezienie(w.getId()), "Powinno dać się znaleźć dodane więzienie");
    }

    @ParameterizedTest
    @Order(2)
    @DisplayName("2. Dodawanie wielu więzień (Parametryzacja)")
    @CsvSource({
            "1, Wronki, Wronki, 1000",
            "2, Rakowiecka, Warszawa, 600",
            "3, Białołęka, Warszawa, 300"
    })
    void testDodajWieleWiezien(int id, String nazwa, String lok, int cel) {
        Wiezienie w = new Wiezienie(id, nazwa, lok, cel, "High", "Active");

        boolean wynik = manager.dodajWiezienie(w);

        assertTrue(wynik);
        assertEquals(nazwa, manager.znajdzWiezienie(id).getNazwa());
    }

    @Test
    @Order(3)
    @DisplayName("3. Usuwanie istniejącego więzienia")
    void testUsunWiezienie() {
        Wiezienie w = new Wiezienie(10, "DoUsuniecia", "X", 100, "Low", "Active");
        manager.dodajWiezienie(w);

        boolean usunieto = manager.usuniecieWiezienia(10);

        assertTrue(usunieto, "Usuwanie powinno zwrócić true");
        assertNull(manager.znajdzWiezienie(10), "Po usunięciu więzienie nie powinno istnieć");
    }
}