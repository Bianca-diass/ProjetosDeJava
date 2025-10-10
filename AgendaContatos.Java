import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Contato {
    String nome, telefone, email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
}

public class AgendaContatos extends JFrame {
    private JTextField nomeField, telefoneField, emailField;
    private JButton adicionarBtn, removerBtn;
    private JTable tabela;
    private DefaultTableModel model;
    private ArrayList<Contato> contatos;

    public AgendaContatos() {
        setTitle("Agenda de Contatos 📇");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 182, 193));

        contatos = new ArrayList<>();

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 50, 25);
        add(nomeLabel);
        nomeField = new JTextField();
        nomeField.setBounds(80, 20, 150, 25);
        add(nomeField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(20, 60, 70, 25);
        add(telefoneLabel);
        telefoneField = new JTextField();
        telefoneField.setBounds(80, 60, 150, 25);
        add(telefoneField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 100, 50, 25);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(80, 100, 150, 25);
        add(emailField);

        adicionarBtn = new JButton("Adicionar");
        adicionarBtn.setBounds(250, 20, 120, 25);
        adicionarBtn.setBackground(new Color(255, 105, 180));
        adicionarBtn.setForeground(Color.WHITE);
        add(adicionarBtn);

        removerBtn = new JButton("Remover");
        removerBtn.setBounds(250, 60, 120, 25);
        removerBtn.setBackground(new Color(255, 20, 147));
        removerBtn.setForeground(Color.WHITE);
        add(removerBtn);

        model = new DefaultTableModel(new Object[]{"Nome","Telefone","Email"},0);
        tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 150, 440, 200);
        add(scroll);

        adicionarBtn.addActionListener(e -> adicionarContato());
        removerBtn.addActionListener(e -> removerContato());

        setLocationRelativeTo(null);
    }

    private void adicionarContato() {
        String nome = nomeField.getText().trim();
        String telefone = telefoneField.getText().trim();
        String email = emailField.getText().trim();

        if(nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        Contato c = new Contato(nome, telefone, email);
        contatos.add(c);
        model.addRow(new Object[]{c.nome, c.telefone, c.email});

        nomeField.setText(""); telefoneField.setText(""); emailField.setText("");
    }

    private void removerContato() {
        int selected = tabela.getSelectedRow();
        if(selected != -1) {
            contatos.remove(selected);
            model.removeRow(selected);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaContatos().setVisible(true));
    }
}
