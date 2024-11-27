import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Hauptbildschirm extends JFrame {
    private DatenbankManager db;
    private JComboBox<String> teilnehmerComboBox;
    private JButton ausbildungsberufeButton;
    private JButton ausbilderButton;
    private JButton teilnehmerButton;
    private JButton aktivitaetenButton;
    private JButton exportButton;
    private JButton speichernButton;
    private JTable wochenuebersichtTable;
    private DefaultTableModel wochenuebersichtTableModel;

    public Hauptbildschirm() {
        db = new DatenbankManager();
        createGUI();
    }

    private void createGUI() {
        // Oberer Bereich mit Buttons
        JPanel obererBereich = new JPanel();
        obererBereich.setLayout(new FlowLayout());

        ausbildungsberufeButton = new JButton("Ausbildungsberufe");
        ausbildungsberufeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Öffne Ausbildungsberufe-Untermenü
            }
        });
        obererBereich.add(ausbildungsberufeButton);

        ausbilderButton = new JButton("Ausbilder");
        ausbilderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Öffne Ausbilder-Untermenü
            }
        });
        obererBereich.add(ausbilderButton);

        teilnehmerButton = new JButton("Teilnehmer");
        teilnehmerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Öffne Teilnehmer-Untermenü
            }
        });
        obererBereich.add(teilnehmerButton);

        aktivitaetenButton = new JButton("Aktivitäten/Aufgaben");
        aktivitaetenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Öffne Aktivitäten/Aufgaben-Untermenü
            }
        });
        obererBereich.add(aktivitaetenButton);

        exportButton = new JButton("Export nach Excel");
        exportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exportiere Daten nach Excel
            }
        });
        obererBereich.add(exportButton);

        speichernButton = new JButton("Speichern");
        speichernButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Speichere Daten in Datenbank
            }
        });
        obererBereich.add(speichernButton);

        // Dropdown-Menü für Teilnehmer
        teilnehmerComboBox = new JComboBox<String>();
        teilnehmerComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Wenn ein anderer Teilnehmer ausgewählt wird, speichere Daten für aktuellen Teilnehmer
            }
        });

        // Wochenübersicht-Tabelle
        wochenuebersichtTableModel = new DefaultTableModel();
        wochenuebersichtTableModel.addColumn("Montag");
        wochenuebersichtTableModel.addColumn("Dienstag");
        wochenuebersichtTableModel.addColumn("Mittwoch");
        wochenuebersichtTableModel.addColumn("Donnerstag");
        wochenuebersichtTableModel.addColumn("Freitag");
        wochenuebersichtTableModel.addColumn("Samstag");
        wochenuebersichtTableModel.addColumn("Sonntag");
        wochenuebersichtTable = new JTable(wochenuebersichtTableModel);

        // Jede Zelle soll ein Textfeld und ein ComboBox enthalten
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                JTextField textField = new JTextField();
                JComboBox<String> comboBox = new JComboBox<String>();
                // Füge ComboBox und Textfeld zu Zelle hinzu
            }
        }

        // Füge alle Komponenten zum Hauptbildschirm hinzu
        add(obererBereich, BorderLayout.NORTH);
        add(teilnehmerComboBox, BorderLayout.CENTER);
        add(wochenuebersichtTable, BorderLayout.SOUTH);
    }
}