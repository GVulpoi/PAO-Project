package Restaurante;
import Localizare.Localizare;

public class Restaurant {
    public String nume;
    public Localizare localizare;

    public Restaurant() {
    }

    public Restaurant(String auxNume, Localizare auxLocalizare) {
        nume = auxNume;
        localizare = auxLocalizare;
    }

    public Localizare getLocalizare() {
        return localizare;
    }

    public String getNume() {
        return nume;
    }

    public void setLocalizare(Localizare localizare) {
        this.localizare = localizare;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
