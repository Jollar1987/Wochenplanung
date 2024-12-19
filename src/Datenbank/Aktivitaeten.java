package Datenbank;

public class Aktivitaeten {
    private int id;
    private String bezeichnung;
    private String volleBezeichnung;
    private int aktivitaetsNummer;

    public Aktivitaeten(int id, int aktivitaetsNummer, String bezeichnung, String volleBezeichnung) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.volleBezeichnung = volleBezeichnung;
        this.aktivitaetsNummer = aktivitaetsNummer;
    }
}
