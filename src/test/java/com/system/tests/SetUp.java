package com.system.tests;

import fit.Fixture;
import com.example.model.ZarzadzanieWiezieniami;
import com.example.model.BazaDanych;
import com.example.model.Model;
import com.example.controller.DodajWiezienie;
import com.example.view.PrzekazanieInformacji;

public class SetUp extends Fixture {
    public static ZarzadzanieWiezieniami prisonManager;
    public static DodajWiezienie prisonController;

    public SetUp() {
        prisonManager = new ZarzadzanieWiezieniami();
        BazaDanych database = new BazaDanych(prisonManager);
        Model model = new Model(database);
        PrzekazanieInformacji view = new PrzekazanieInformacji();

        prisonController = new DodajWiezienie(model, view);
    }
}