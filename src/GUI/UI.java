package GUI;

import javax.swing.*;
import java.util.ArrayList;


public class UI extends JFrame {
    private JFrame mainFrame;
    private JTabbedPane tabbedPane;
    private ArrayList<JButton> panel1Buttons = new ArrayList<>();
    private ArrayList<JButton> panel2Buttons = new ArrayList<>();
    private JPanel panel1;
    private JPanel panel2;

    public UI(){
        createUI();
        addUI();
    }

    /**
     * Adds the UI elements to the frame. This method should only be called
     * after createUI() has been called.
     */
    private void addUI() {
        addButtons();
        addPanels();
        addTabbedPanes();
        setFrame();
    }
    public void createUI() {
        createButtonsTab1();
        createButtonsTab2();
        createPanels();
        createTabbedPane();
        createFrame();
    }
    private void setFrame() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(tabbedPane);
        mainFrame.setSize(300, 250);
        mainFrame.setVisible(true);
    }

    private void addTabbedPanes() {
        mainFrame.add(tabbedPane);
    }

    private void addPanels() {
        tabbedPane.add("Panel 1", panel1);
        tabbedPane.add("Panel 2", panel2);
    }

    private void addButtons() {
        for (JButton button : panel1Buttons) {
            panel1.add(button);
        }
        for (JButton button : panel2Buttons) {
            panel2.add(button);
        }
    }

    private void createPanels() {
        panel1 = new JPanel();
        panel2 = new JPanel();
    }

    private void createTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.add("Panel 1", panel1);
        tabbedPane.add("Panel 2", panel2);
    }

    private void createFrame() {
        this.mainFrame = new JFrame("Mein GUI.UI");
    }

    private void createButtonsTab1() {
        this.panel1Buttons.add(new JButton("Button 1"));
        this.panel1Buttons.add(new JButton("Button 2"));
    }

    private void createButtonsTab2() {
        this.panel2Buttons.add(new JButton("Button 3"));
        this.panel2Buttons.add(new JButton("Button 4"));
    }


}
