package org.Formatieren;

public class Person {
    private String vorname;
    private String name;
    private String geschlecht;
    private String geburtsdatum;
    private String ahvNummer;
    private String region;
    private int kinder;

    public Person(String vorname, String name, String geschlecht, String geburtsdatum, String ahvNummer, String region, int kinder) {
        this.vorname = vorname;
        this.name = name;
        this.geschlecht = geschlecht;
        this.geburtsdatum = geburtsdatum;
        this.ahvNummer = ahvNummer;
        this.region = region;
        this.kinder = kinder;
    }


    // Getter und Setter für alle Felder


    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getAhvNummer() {
        return ahvNummer;
    }

    public void setAhvNummer(String ahvNummer) {
        this.ahvNummer = ahvNummer;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getKinder() {
        return kinder;
    }

    public void setKinder(int kinder) {
        this.kinder = kinder;
    }
}
