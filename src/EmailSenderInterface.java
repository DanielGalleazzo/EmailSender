import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EmailSenderInterface extends JFrame {

    private JTextField RemetenteField, DestinatarioField, ProdutoField;
    private JTextArea Quantidadee;


    public EmailSenderInterface() {
        setTitle("Email Sender");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        RemetenteField = new JTextField();
        DestinatarioField = new JTextField();
        ProdutoField = new JTextField();
        Quantidadee = new JTextArea(5, 20);

        panel.add(new JLabel("Remetente: "));
        panel.add(RemetenteField);

        panel.add(new JLabel("Destinatário: "));
        panel.add(DestinatarioField);
        panel.add(new JLabel("Produto:"));
        panel.add(ProdutoField);
        panel.add(new JLabel("Quantidade:"));
        panel.add(new JScrollPane(Quantidadee));

        JButton sendButton = new JButton("Enviar Email");
        sendButton.addActionListener(this::sendEmail);

        add(panel, BorderLayout.CENTER);
        add(sendButton, BorderLayout.SOUTH);
    }

    private void sendEmail(ActionEvent event) {
        String from = RemetenteField.getText();

        String Remetente = RemetenteField.getText();
        String Destinatario = DestinatarioField.getText();
        String Produto = ProdutoField.getText();
        String Quantidade = Quantidadee.getText();
        Main.sendEmail(Remetente,  Destinatario, Produto, Quantidade );
        JOptionPane.showMessageDialog(this, "Email enviado com sucesso!");

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmailSenderInterface().setVisible(true);
        });
    }
}
