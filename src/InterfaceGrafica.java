import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica {

    private static BibliotecaApp bibliotecaApp = new BibliotecaApp();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Título do Livro"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JTextField titleField = new JTextField(20);
        panel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Autor"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JTextField authorField = new JTextField(20);
        panel.add(authorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Gênero"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        String[] genres = {"Ficção", "Não Ficção", "Suspense", "Romance", "Dark Romance", "LGBTQIA", "Enemies To Lovers", "Outro"};
        JComboBox<String> genreCombo = new JComboBox<>(genres);
        panel.add(genreCombo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(new JLabel("Categoria do Livro"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JTextField categoryField = new JTextField(20);
        panel.add(categoryField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(new JLabel("ISBN do Livro"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        JTextField isbnField = new JTextField(20);
        panel.add(isbnField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(new JLabel("Ano de Publicação do Livro"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        JTextField yearField = new JTextField(20);
        panel.add(yearField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JButton addButton = new JButton("Adicionar Livro");
        panel.add(addButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 9;
        JButton exitButton = new JButton("Sair");
        panel.add(exitButton, gbc);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = titleField.getText();
                String autor = authorField.getText();
                String categoria = categoryField.getText();
                String isbn = isbnField.getText();
                int anoPublicacao = Integer.parseInt(yearField.getText());


                //bibliotecaApp.cadastrarLivro(titulo, autor, categoria, isbn, anoPublicacao);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
