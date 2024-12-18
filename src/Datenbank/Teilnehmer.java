package Datenbank;

public class Teilnehmer {
    private int id;
    private String name;
    private String vorname;
    private String ausbildungsberuf;
    private String gruppe;

    public Teilnehmer(int id, String name, String vorname, String ausbildungsberuf, String gruppe) {
        this.id = id;
        this.name = name;
        this.vorname = vorname;
        this.ausbildungsberuf = ausbildungsberuf;
        this.gruppe = gruppe;
    }
}
