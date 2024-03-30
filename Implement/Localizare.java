package Implement;

import Service.LocalizareService;

import java.util.List;

public class Localizare implements LocalizareService {
    private String oras;
    private String strada;
    private int nr;

    public Localizare(String auxOras, String auxStrada, int auxNr) {
        oras = auxOras;
        strada = auxStrada;
        nr = auxNr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNr() {
        return nr;
    }

    public String getOras() {
        return oras;
    }

    public String getStrada() {
        return strada;
    }
}
