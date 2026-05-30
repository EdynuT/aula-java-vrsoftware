import java.util.Scanner;

public class Exercicio3 {
    public static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Cadastrar aluno 
        // A IA transformou o método 'cadastrarAluno' em um método que retorna um array de String, assim separando os dois resultados (nome e matricula)
        String[] aluno = cadastrarAluno();

        // Cadastrar notas 
        double media = cadastrarNotas();

        // Verificar situação 
        String situacao = verificarSituacao(media);

        // Exibir boletim 
        // Aqui n teve jeito, so cheguei nesse resultado com IA, pq eu n estava conseguindo dividir os resultados do método 'cadastrarAluno'
        exibirBoletim(aluno[0], aluno[1], media, situacao);
    }

    public static String[] cadastrarAluno() {
        System.out.println("Nome do aluno:"); 
        String nome = scanner.nextLine();
        System.out.println("Matrícula:"); 
        String matricula = scanner.nextLine();

        // Aqui a IA fez retornar um array de String, assim separando os dois resultados (nome e matricula)
        return new String[]{nome, matricula};
    }

    public static double cadastrarNotas() {
        System.out.println("Quantas notas?");  
        int quantidade = scanner.nextInt(); 
        double[] notas = new double[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Nota " + (i+1) + ":");
            notas[i] = scanner.nextDouble();
        }
        double soma = 0; 
        for (double nota : notas) {
            soma += nota;
        } 
        return soma / quantidade;
    }

    public static String verificarSituacao(double media) {
        String situacao; 
        if (media >= 7.0) {
            situacao = "Aprovado";
        } 
        else if (media >= 5.0) {
            situacao = "Recuperação";
        } 
        else {
            situacao = "Reprovado";
        }
        return situacao;
    }

    public static void exibirBoletim(String nome, String matricula, double media, String situacao) {
        System.out.println("=== BOLETIM ===");
        System.out.println("Aluno: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Média: " + String.format("%.2f", media));
        System.out.println("Situação: " + situacao);
    }
}
