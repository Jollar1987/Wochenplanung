import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatenbankManager {
    private Connection connection;
    private static final String DB_URL = "jdbc:sqlite:teilnehmer.db";
    private static final String USER = "";
    private static final String PASS = "";

    public DatenbankManager(){
        if (connection == null) {
            erstelleDatenbank();
            connectToDataBase();
        }
    }
    public List<Teilnehmer> getTeilnehmer() {
        List<Teilnehmer> teilnehmerListe = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            String sql = "SELECT * FROM Teilnehmer";
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

    public Connection connectToDataBase() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            return connection;
        } catch (SQLException e) {
            System.out.println("Fehler bei der Verbindung zur Datenbank: " + e.getMessage());
            return null;
        }
    }
    public void erstelleDatenbank() {
        try {
            Connection conn = this.connectToDataBase();
            Statement stmt = conn.createStatement();

            // Erstelle Tabelle Teilnehmer
            stmt.execute("CREATE TABLE IF NOT EXISTS teilnehmer (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT, " +
                    "vorname TEXT, " +
                    "ausbildungsberuf TEXT, " +
                    "gruppe TEXT)");

            // Erstelle Tabelle Ausbildungsberufe
            stmt.execute("CREATE TABLE IF NOT EXISTS ausbildungsberufe (" +
                    "id INTEGER PRIMARY KEY, " +
                    "bezeichnung TEXT, " +
                    "volleBezeichnung TEXT)");

            // Erstelle Tabelle Ausbilder
            stmt.execute("CREATE TABLE IF NOT EXISTS ausbilder (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT, " +
                    "vorname TEXT)");

            // Erstelle Tabelle Aktivitäten/Aufgaben
            stmt.execute("CREATE TABLE IF NOT EXISTS aktivitaeten (" +
                    "id INTEGER PRIMARY KEY, " +
                    "bezeichnung TEXT, " +
                    "volleBezeichnung TEXT)");

            // Erstelle Tabelle Wochentage
            stmt.execute("CREATE TABLE IF NOT EXISTS wochentage (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT)");

            // Erstelle Tabelle Zuordnung von Aktivitäten/Aufgaben zu Teilnehmern und Wochentagen
            stmt.execute("CREATE TABLE IF NOT EXISTS zuordnung (" +
                    "id INTEGER PRIMARY KEY, " +
                    "teilnehmer_id INTEGER, " +
                    "ausbilder_id INTEGER, " +
                    "wochentag_id INTEGER, " +
                    "aktivitaet_id INTEGER, " +
                    "jahr INTEGER, " +
                    "kalenderwoche INTEGER, " +
                    "FOREIGN KEY (teilnehmer_id) REFERENCES teilnehmer(id), " +
                    "FOREIGN KEY (aktivitaet_id) REFERENCES aktivitaeten(id), " +
                    "FOREIGN KEY (wochentag_id) REFERENCES wochentage(id), " +
                    "FOREIGN KEY (ausbilder_id) REFERENCES ausbilder(id)");

            // Befülle wochentage mit Daten
            stmt.execute("INSERT INTO wochentage (id, name) VALUES " +
                    "(1, 'Montag'), " +
                    "(2, 'Dienstag'), " +
                    "(3, 'Mittwoch'), " +
                    "(4, 'Donnerstag'), " +
                    "(5, 'Freitag'), " +
                    "(6, 'Samstag'), " +
                    "(7, 'Sonntag')");

            System.out.println("Datenbank erstellt!");
        } catch (SQLException e) {
            System.out.println("Fehler bei der Erstellung der Datenbank: " + e.getMessage());
        }
    }
}