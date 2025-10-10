import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizPerguntas extends JFrame {
    String[][] perguntas = {
        {"Capital do Brasil?", "Brasília", "Rio", "São Paulo", "Brasília"},
        {"5 + 7 = ?", "10", "12", "11", "12"},
        {"Cor do céu?", "Verde", "Azul", "Amarelo", "Azul"}
    };
    int index = 0;
    int pontuacao = 0;

    JLabel perguntaLabel;
    JRadioButton[] opcoes;
    JButton proximoBtn;
    ButtonGroup bg;

    public QuizPerguntas() {
        setTitle("Quiz de Perguntas 💡");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        perguntaLabel = new JLabel();
        perguntaLabel.setBounds(20, 20, 350, 30);
        add(perguntaLabel);

        opcoes = new JRadioButton[3];
        bg = new ButtonGroup();
        for(int i=0; i<3; i++) {
            opcoes[i] = new JRadioButton();
            opcoes[i].setBounds(20, 60+40*i, 200, 30);
            bg.add(opcoes[i]);
            add(opcoes[i]);
        }

        proximoBtn = new JButton("Próxima");
        proximoBtn.setBounds(250, 200, 100, 30);
        add(proximoBtn);

        proximoBtn.addActionListener(e -> proximaPergunta());

        setPergunta();
        setLocationRelativeTo(null);
    }

    void setPergunta() {
        if(index >= perguntas.length) {
            JOptionPane.showMessageDialog(this, "Fim do Quiz! Pontuação: " + pontuacao);
            System.exit(0);
        }
        perguntaLabel.setText(perguntas[index][0]);
        for(int i=0; i<3; i++) {
            opcoes[i].setText(perguntas[index][i+1]);
        }
        bg.clearSelection();
    }

    void proximaPergunta() {
        for(int i=0; i<3; i++) {
            if(opcoes[i].isSelected() && opcoes[i].getText().equals(perguntas[index][4])) {
                pontuacao++;
            }
        }
        index++;
        setPergunta();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuizPerguntas().setVisible(true));
    }
}
