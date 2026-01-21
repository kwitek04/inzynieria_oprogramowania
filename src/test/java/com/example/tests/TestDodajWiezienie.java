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
@DisplayName("Zadanie 2: Testy Kontrolera (DodajWiezienie) z Mockami")
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
        // JEŚLI (Given): Ustawiamy poprawne dane
        kontroler.ustawDane("Alcatraz", "USA", 1000, "High", "Active");
        // Uczymy model, że zapis się uda
        when(mockModel.zapiszRekord(eq("Wiezienie"), any())).thenReturn(true);

        // GDY (When): Klikamy zatwierdź
        kontroler.zatwierdzDodanieWiezienia();

        // WTEDY (Then):
        // 1. Sprawdzamy, czy kontroler kazał modelowi zapisać
        verify(mockModel, times(1)).zapiszRekord(eq("Wiezienie"), any());
        // 2. Sprawdzamy, czy widok wyświetlił sukces
        verify(mockWidok).przekazanieInformacji(contains("Sukces"));
    }

    @Test
    @DisplayName("Scenariusz Negatywny: Pusta nazwa -> Walidacja -> Pokaż Błąd")
    void testDodanieBledneDane() {
        // JEŚLI: Pusta nazwa, 0 cel (błędne dane)
        kontroler.ustawDane("", "Polska", 0, "Low", "Active");

        // GDY
        kontroler.zatwierdzDodanieWiezienia();

        // WTEDY:
        // 1. Model NIE powinien być wołany (walidacja zatrzymała proces)
        verify(mockModel, never()).zapiszRekord(anyString(), any());
        // 2. Widok powinien pokazać błąd walidacji
        verify(mockWidok).przekazanieInformacji(contains("Błąd walidacji"));
    }
}