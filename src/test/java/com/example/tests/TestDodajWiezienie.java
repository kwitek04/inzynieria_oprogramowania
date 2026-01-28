package com.example.tests;

import com.example.controller.DodajWiezienie;
import com.example.model.Model;
import com.example.view.PrzekazanieInformacji;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testy Kontrolera (DodajWiezienie) z Mockami")
public class TestDodajWiezienie {

    @Mock
    private Model mockModel;

    @Mock
    private PrzekazanieInformacji mockWidok;

    @InjectMocks
    private DodajWiezienie kontroler;

    @Test
    @DisplayName("Scenariusz Pozytywny: Dane poprawne -> Zapisz w Modelu -> Pokaż Sukces")
    void testDodaniePoprawne() {
        // Poprawne dane
        kontroler.ustawDane("Alcatraz", "USA", 1000, "High", "Active");
        when(mockModel.zapiszRekord(eq("Wiezienie"), any())).thenReturn(true);

        kontroler.zatwierdzDodanieWiezienia();

        // 1. Sprawdzamy, czy kontroler kazał modelowi zapisać
        verify(mockModel, times(1)).zapiszRekord(eq("Wiezienie"), any());
        // 2. Sprawdzamy, czy widok wyświetlił sukces
        verify(mockWidok).przekazanieInformacji(contains("Sukces"));
    }

    @Test
    @DisplayName("Scenariusz Negatywny: Pusta nazwa -> Walidacja -> Pokaż Błąd")
    void testDodanieBledneDane() {
        // Błędne dane: Pusta nazwa, 0 cel
        kontroler.ustawDane("", "Polska", 0, "Low", "Active");

        kontroler.zatwierdzDodanieWiezienia();

        // 1. Model nie powinien być wywołany
        verify(mockModel, never()).zapiszRekord(anyString(), any());
        // 2. Widok powinien pokazać błąd walidacji
        verify(mockWidok).przekazanieInformacji(contains("Błąd walidacji"));
    }
}