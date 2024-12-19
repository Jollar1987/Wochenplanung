package Datenbank;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatenbankManager {
    private Connection connection;
    private Statement stmt;
    private static final String DB_URL = "jdbc:sqlite:teilnehmer.db";
    private static final String USER = "";
    private static final String PASS = "";

    public DatenbankManager(){
        connectToDataBase();
        //erstelleDatenbank();
        //updateDatenbank();
    }

    public void updateDatenbank() {
        try {
            stmt.execute("ALTER TABLE aktivitaeten ADD COLUMN aktivitaetsNummer INTEGER");
        }
        catch (SQLException e) {

        }
    }
    public void entferneInhaltAusTabelle(String tableName) {
        try {
            stmt.execute("DELETE FROM " + tableName);
            System.out.println("Inhalt aus Tabelle " + tableName + " entfernt.");
        } catch (SQLException e) {
            System.out.println("Fehler: " + e.getMessage() + "entferneInhaltAusTabelle");
        }
    }
    public void loescheTabelle(String tableName) {
        try {
            stmt.execute("DROP TABLE " + tableName);
            System.out.println("Tabelle " + tableName + " gelöscht.");
        } catch (SQLException e) {
            System.out.println("Fehler: " + e.getMessage() + "loescheTabelle");
        }
    }
    public void loescheDatenbank() {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);
                stmt.execute("DROP TABLE " + tableName);
            }

        } catch (SQLException e) {
            System.out.println("Fehler: " + e.getMessage() + "loescheDatenbank");
        }
    }
    public void dbInfo() {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);
                ResultSet columns = metaData.getColumns(null, null, tableName, null);
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    System.out.println("  " + columnName);
                }
                ResultSet data = stmt.executeQuery("SELECT * FROM " + tableName);
                while (data.next()) {
                    for (int i = 1; i <= data.getMetaData().getColumnCount(); i++) {
                        System.out.print("  " + data.getString(i));
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            System.out.println("Fehler: " + e.getMessage() + " DBinfo JOJO");
        }
    }
    public List<Teilnehmer> getTeilnehmer() {
        List<Teilnehmer> teilnehmerListe = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Datenbank.Teilnehmer";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Teilnehmer teilnehmer = new Teilnehmer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("vorname"),
                        rs.getString("ausbildungsberuf"),
                        rs.getString("ausbilder")
                );
                teilnehmerListe.add(teilnehmer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teilnehmerListe;
    }

    public void connectToDataBase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:teilnehmer.db");
            stmt = connection.createStatement();
            System.out.println("Verbindung zur Datenbank hergestellt");
        } catch (SQLException e) {
            System.out.println("Fehler bei der Verbindung zur Datenbank: " + e.getMessage());
        }
    }

    public void befuelleDatenbankDefaultWerte() {
        try {
            Statement stmt = connection.createStatement();
            // Befülle wochentage mit Daten
            stmt.execute("INSERT INTO wochentage (id, name) VALUES " +
                    "(1, 'Montag'), " +
                    "(2, 'Dienstag'), " +
                    "(3, 'Mittwoch'), " +
                    "(4, 'Donnerstag'), " +
                    "(5, 'Freitag'), " +
                    "(6, 'Samstag'), " +
                    "(7, 'Sonntag');");
        }
        catch(SQLException e) {
            System.out.println("Default Daten existieren schon" + e.getMessage());
        }
    }
    public void erstelleDatenbank() {
        File dbFile = new File("teilnehmer.db");
        if (!dbFile.exists()) {
            try {
                dbFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Fehler bei der Erstellung der Datenbank-Datei: " + e.getMessage());
            }
        }
        try {
            // Erstelle Tabelle Datenbank.Teilnehmer
            stmt.execute("CREATE TABLE IF NOT EXISTS teilnehmer (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT, " +
                    "vorname TEXT, " +
                    "ausbildungsberuf TEXT, " +
                    "gruppe TEXT);");

            // Erstelle Tabelle Datenbank.Ausbildungsberufe
            stmt.execute("CREATE TABLE IF NOT EXISTS ausbildungsberufe (" +
                    "id INTEGER PRIMARY KEY, " +
                    "bezeichnung TEXT, " +
                    "volleBezeichnung TEXT);");

            // Erstelle Tabelle Datenbank.Ausbilder
            stmt.execute("CREATE TABLE IF NOT EXISTS ausbilder (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT, " +
                    "vorname TEXT);");

            // Erstelle Tabelle Aktivitäten/Aufgaben
            stmt.execute("CREATE TABLE IF NOT EXISTS aktivitaeten (" +
                    "id INTEGER PRIMARY KEY, " +
                    "bezeichnung TEXT, " +
                    "volleBezeichnung TEXT);");

            // Erstelle Tabelle Datenbank.Wochentage
            stmt.execute("CREATE TABLE IF NOT EXISTS wochentage (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT);");

            // Erstelle Tabelle Datenbank.Zuordnung von Aktivitäten/Aufgaben zu Teilnehmern und Wochentagen
            stmt.execute("CREATE TABLE IF NOT EXISTS zuordnung (" +
                    "id INTEGER PRIMARY KEY, " +
                    "teilnehmer_id INTEGER, " +
                    "ausbilder_id INTEGER, " +
                    "wochentag_id INTEGER, " +
                    "aktivitaet_id INTEGER, " +
                    "jahr INTEGER, " +
                    "kalenderwoche INTEGER, " +
                    "FOREIGN KEY (teilnehmer_id) REFERENCES teilnehmer(id), " +
                    "FOREIGN KEY (ausbilder_id) REFERENCES ausbilder(id), " +
                    "FOREIGN KEY (wochentag_id) REFERENCES wochentage(id), " +
                    "FOREIGN KEY (aktivitaet_id) REFERENCES aktivitaeten(id));");

            System.out.println("Datenbank erstellt!");
        } catch (SQLException e) {
            System.out.println("Fehler bei der Erstellung der Datenbank: " + e.getMessage());
        }
        befuelleDatenbankDefaultWerte();
    }
}