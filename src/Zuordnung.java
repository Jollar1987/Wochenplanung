import java.util.Calendar;

public class Zuordnung {
    private int id;
    private Teilnehmer teilnehmer;
    private Ausbilder ausbilder;
    private Wochentage wochentag;
    private Aktivitaeten aktivitaet;
    private int jahr;
    private int kalenderwoche;

    public Zuordnung(int id, Teilnehmer teilnehmer, Ausbilder ausbilder, Wochentage wochentag, Aktivitaeten aktivitaet, int jahr, int kalenderwoche) {
        this.id = id;
        this.teilnehmer = teilnehmer;
        this.ausbilder = ausbilder;
        this.wochentag = wochentag;
        this.aktivitaet = aktivitaet;
        this.jahr = jahr;
        this.kalenderwoche = kalenderwoche;
    }

    public Zuordnung(int id, Teilnehmer teilnehmer, Ausbilder ausbilder, Wochentage wochentag, Aktivitaeten aktivitaet) {
        this.id = id;
        this.teilnehmer = teilnehmer;
        this.ausbilder = ausbilder;
        this.wochentag = wochentag;
        this.aktivitaet = aktivitaet;
        this.jahr = Calendar.getInstance().get(Calendar.YEAR);
        this.kalenderwoche = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    }
}
