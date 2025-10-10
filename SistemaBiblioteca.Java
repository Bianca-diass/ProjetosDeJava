import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    String titulo, autor;
    boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }
}

public class SistemaBiblioteca {
    static ArrayList<Livro> livros = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opc;
        do {
            System.out.println("\n=== Sistema de Biblioteca ===");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Emprestar livro");
            System.out.println("4. Devolver livro");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch(opc) {
                case 1: cadastrarLivro(); break;
                case 2: listarLivros(); break;
                case 3: emprestarLivro(); break;
                case 4: devolverLivro(); break;
            }
        } while(opc != 0);
    }

    static void cadastrarLivro() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        livros.add(new Livro(titulo, autor));
        System.out.println("Livro cadastrado!");
    }

    static void listarLivros() {
        System.out.println("\nLivros cadastrados:");
        for(int i=0; i<livros.size(); i++) {
            Livro l = livros.get(i);
            System.out.printf("%d - %s (%s) - %s\n", i+1, l.titulo, l.autor, l.emprestado ? "Emprestado" : "Disponível");
        }
    }

    static void emprestarLivro() {
        listarLivros();
        System.out.print("Escolha o número do livro: ");
        int i = sc.nextInt()-1;
        if(i>=0 && i<livros.size() && !livros.get(i).emprestado) {
            livros.get(i).emprestado = true;
            System.out.println("Livro emprestado!");
        } else {
            System.out.println("Livro indisponível!");
        }
    }

    static void devolverLivro() {
        listarLivros();
        System.out.print("Escolha o número do livro: ");
        int i = sc.nextInt()-1;
        if(i>=0 && i<livros.size() && livros.get(i).emprestado) {
            livros.get(i).emprestado = false;
            System.out.println("Livro devolvido!");
        } else {
            System.out.println("Livro não estava emprestado!");
        }
    }
}
