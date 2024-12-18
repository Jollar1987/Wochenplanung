import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UI {
    private final JFrame mainFrame;
    private final JButton button;

    public UI(){
        this.mainFrame = new JFrame("Mein UI");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.button = new JButton("Klick mich!");
    }
    public void createUI() {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button wurde geklickt!");
            }
        });

        mainFrame.getContentPane().add(button, BorderLayout.CENTER);
        mainFrame.setSize(300, 250);
        mainFrame.setVisible(true);
    }
}
