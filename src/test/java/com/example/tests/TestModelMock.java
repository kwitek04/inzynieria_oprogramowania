package com.example.tests;

import com.example.model.IDAO;
import com.example.model.Model;
import com.example.model.Wiezienie;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Zadanie 2: Testy Modelu z Mockowaniem IDAO")
@Tag("Integration")
public class TestModelMock {

    @Mock
    private IDAO mockDao;

    @InjectMocks
    private Model model;

    @Test
    @DisplayName("zapiszRekord: Powinien wywołać dao.dodajWiezienie, gdy tabela to 'Wiezienie'")
    void testZapiszRekordWiezienie() {
        Wiezienie w = new Wiezienie(1, "Testowe", "Miasto", 100, "High", "Active");

        when(mockDao.dodajWiezienie(any(Wiezienie.class))).thenReturn(true);

        boolean wynik = model.zapiszRekord("Wiezienie", w);

        assertTrue(wynik, "Model powinien zwrócić wynik z DAO");

        verify(mockDao, times(1)).dodajWiezienie(w);
    }

    @Test
    @DisplayName("zapiszRekord: Nie powinien nic robić dla nieznanej tabeli")
    void testZapiszRekordNieznanaTabela() {

        Wiezienie w = new Wiezienie();

        boolean wynik = model.zapiszRekord("NieznanaTabela", w);

        assertFalse(wynik);

        verify(mockDao, never()).dodajWiezienie(any());
    }
}