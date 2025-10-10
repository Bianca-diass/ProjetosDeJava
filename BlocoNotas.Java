import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BlocoDeNotasRosa extends JFrame {
    private JTextArea areaTexto;
    private JButton salvarBtn, abrirBtn, limparBtn;

    public BlocoDeNotasRosa() {
        setTitle("Bloco de Notas Rosa 💗");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 182, 193));

        areaTexto = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setBounds(20, 20, 440, 350);
        add(scroll);

        salvarBtn = new JButton("Salvar");
        salvarBtn.setBounds(20, 400, 100, 30);
        salvarBtn.setBackground(new Color(255, 105, 180));
        salvarBtn.setForeground(Color.WHITE);
        salvarBtn.setFocusPainted(false);
        add(salvarBtn);

        abrirBtn = new JButton("Abrir");
        abrirBtn.setBounds(140, 400, 100, 30);
        abrirBtn.setBackground(new Color(255, 105, 180));
        abrirBtn.setForeground(Color.WHITE);
        abrirBtn.setFocusPainted(false);
        add(abrirBtn);

        limparBtn = new JButton("Limpar");
        limparBtn.setBounds(260, 400, 100, 30);
        limparBtn.setBackground(new Color(255, 105, 180));
        limparBtn.setForeground(Color.WHITE);
        limparBtn.setFocusPainted(false);
        add(limparBtn);

        salvarBtn.addActionListener(e -> salvarArquivo());
        abrirBtn.addActionListener(e -> abrirArquivo());
        limparBtn.addActionListener(e -> areaTexto.setText(""));

        setLocationRelativeTo(null);
    }

    private void salvarArquivo() {
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fc.getSelectedFile()))) {
                bw.write(areaTexto.getText());
            } catch(IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar arquivo");
            }
        }
    }

    private void abrirArquivo() {
        JFileChooser fc = new JFileChooser();
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()))) {
                areaTexto.setText("");
                String linha;
                while((linha = br.readLine()) != null) {
                    areaTexto.append(linha + "\n");
                }
            } catch(IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao abrir arquivo");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BlocoDeNotasRosa().setVisible(true));
    }
}
