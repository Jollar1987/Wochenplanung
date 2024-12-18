import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UI {
    private JFrame frame;
    private JButton button;

    public UI(){
        this.frame = new JFrame("Mein UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.button = new JButton("Klick mich!");
    }
    public void createUI() {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button wurde geklickt!");
            }
        });

        frame.getContentPane().add(button, BorderLayout.CENTER);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}
