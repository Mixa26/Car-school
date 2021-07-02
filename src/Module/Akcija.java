package Module;

import java.util.Date;
import java.util.Objects;

import Module.TipAkcije;

public class Akcija implements Comparable<Akcija>{
    private String ime;
    private String prezime;
    private String datum;
    private Double cena;
    private TipAkcije tipAkcije;

    public Akcija(String ime, String prezime, String datum, TipAkcije tipAkcije) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum = datum;
        this.tipAkcije = tipAkcije;
    }

    public Akcija(String ime, String prezime, String datum, Double cena, TipAkcije tipAkcije) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum = datum;
        this.cena = cena;
        this.tipAkcije = tipAkcije;
    }

    @Override
    public String toString() {
        return prezime + " " + ime;
    }

    @Override
    public int compareTo(Akcija o) {
        if (this.prezime.compareTo(o.prezime) == 0)
        {
            return this.ime.compareTo(o.ime);
        }
        return (this.prezime.compareTo(o.prezime));
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getDatum() {
        return datum;
    }

    public Double getCena() {
        return cena;
    }

    public TipAkcije getTipAkcije() {
        return tipAkcije;
    }

}
