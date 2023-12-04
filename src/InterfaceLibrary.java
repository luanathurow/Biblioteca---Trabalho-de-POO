import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceLibrary {

    private static BibliotecaApp bibliotecaApp = new BibliotecaApp();

        public InterfaceLibrary() {
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Sistema de Biblioteca");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 5, 5, 5);

            // Boas-vindas
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            JLabel welcomeLabel = new JLabel("Hi! Welcome to the bilbrary =)");
            panel.add(welcomeLabel, gbc);

            // Executar Button
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            JButton executeButton = new JButton("click to run");
            panel.add(executeButton, gbc);

            executeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bibliotecaApp.executa();
                }
            });

            frame.add(panel);
            frame.pack();
            frame.setVisible(true);
        }
    }


