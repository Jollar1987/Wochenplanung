import Datenbank.*;
import GUI.*;

class Main {

    public static void main(String[] args) {

        DatenbankManager dbm = new DatenbankManager();
        dbm.dbInfo();

        UI gui = new UI();

    }

    public static void loesche(DatenbankManager dbm) {
        dbm.loescheDatenbank();
        dbm.entferneInhaltAusTabelle("wochentage");
        dbm.dbInfo();
        dbm.loescheTabelle("teilnehmer");
        dbm.dbInfo();
        dbm.loescheDatenbank();
        dbm.dbInfo();
    }
}