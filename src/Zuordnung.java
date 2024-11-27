public class Zuordnung {
    private Teilnehmer teilnehmer;
    private Ausbilder ausbilder;
    private Wochentage wochentag;
    private Aktivitaeten aktivitaet;

    public Zuordnung(Teilnehmer teilnehmer, Aktivitaeten aktivitaet, Wochentage wochentag, Ausbilder ausbilder) {
        this.teilnehmer = teilnehmer;
        this.aktivitaet = aktivitaet;
        this.wochentag = wochentag;
        this.ausbilder = ausbilder;
    }
}
