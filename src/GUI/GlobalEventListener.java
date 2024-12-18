package GUI;

import java.awt.event.*;

public class GlobalEventListener implements WindowListener, MouseListener, ActionListener {
    @Override
    public void windowOpened(WindowEvent e) {
        // Ereignis: Fenster geöffnet
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // Ereignis: Fenster geschlossen
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // Ereignis: Fenster geschlossen
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // Ereignis: Fenster minimiert
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // Ereignis: Fenster maximiert
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // Ereignis: Fenster aktiviert
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // Ereignis: Fenster deaktiviert
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Ereignis: Mausklick
        System.out.println("Mausklick auf " + e.getComponent());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Ereignis: Maustaste gedrückt
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Ereignis: Maustaste losgelassen
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Ereignis: Maus über Komponente
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Ereignis: Maus verlässt Komponente
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}