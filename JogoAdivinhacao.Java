import javax.swing.*;
import java.util.Random;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Random rand = new Random();
        int numero = rand.nextInt(100) + 1;
        int tentativa = 0;
        boolean acertou = false;

        while(!acertou) {
            String input = JOptionPane.showInputDialog("Adivinhe o número (1-100):");
            if(input == null) break;
            tentativa++;
            try {
                int palpite = Integer.parseInt(input);
                if(palpite == numero) {
                    JOptionPane.showMessageDialog(null, "Parabéns! Você acertou em " + tentativa + " tentativas.");
                    acertou = true;
                } else if(palpite < numero) {
                    JOptionPane.showMessageDialog(null, "Tente um número maior!");
                } else {
                    JOptionPane.showMessageDialog(null, "Tente um número menor!");
                }
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        }
    }
}
