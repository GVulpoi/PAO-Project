package Restaurante;

import Localizare.Localizare;
import Meniu.Meniu;

public class Restaurant {
    private String nume;
    private Localizare localizare;
    private Meniu meniu;

    public Restaurant() {
    }

    public Restaurant(String auxNume, Localizare auxLocalizare, Meniu auxMeniu) {
        nume = auxNume;
        localizare = auxLocalizare;
        meniu = auxMeniu;
    }

    public Localizare getLocalizare() {
        return localizare;
    }

    public String getNume() {
        return nume;
    }

    public Meniu getMeniu() {
        return meniu;
    }

    public void setLocalizare(Localizare localizare) {
        this.localizare = localizare;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setMeniu(Meniu meniu) {
        this.meniu = meniu;
    }
}
