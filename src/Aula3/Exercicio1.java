import java.util.Scanner;

// Tarefas diarias e se concluidas ou não

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tarefas = {
            "Lavar a louça",
            "Limpar a casa",
            "Fazer compras",
            "Estudar para a prova",
            "Cozinhar",
            "Ler livro",
            "Exercitar-se",
            "Assistir um filme",
            "Escrever um diário",
            "Meditar"
        };
        boolean[] concluidas = new boolean[tarefas.length];

        System.out.println("Lista de Tarefas");
        System.out.println();
        for (int i = 0; i < tarefas.length; i++) {
            String status;
            if (concluidas[i]) {
                status = " [Concluída]";
            } 
            else {
                status = "";
            }
            System.out.println((i + 1) + ". " + tarefas[i] + status);
        }

        System.out.print("\nDigite o número da tarefa para marcar como concluída: ");
        int numero = scanner.nextInt();

        if (numero >= 1 && numero <= tarefas.length) {
            concluidas[numero - 1] = true;
            System.out.println("A tarefa '" + tarefas[numero - 1] + "' foi marcada como concluída!");
        } 
        else {
            System.out.println("Número de tarefa inválido.");
        }

        scanner.close();
    }
}
