import java.util.Scanner;

public class Metodos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //        double media = calcularMedia(2d,3d);
        //
        //        imprimirFrase();
        //        System.out.println(soma);
        //        System.out.println(media);
        //int soma1 = somar(2, 3);
        //int soma2 = somar(3.6, 4.4);
        //int soma3 = somar(1, 2, 3);
        //
        //double resultado = 0d;
        //
        //if (soma1 > 3) {
        //    double numero1 = calcularMedia(soma1, 10);
        //    resultado = numero1;
        //}
        //System.out.println(resultado);

        String nome = lerNome();
        double media = calcularMedia();
        exibirResultado(nome, media);
    }
    
    // Leitura
    private static String lerNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do aluno: ");
        return scanner.nextLine();
    }
    // Calcular
    private static double calcularMedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();
        
        return (nota1 + nota2 + nota3) / 3;
    }
    
    // Exibir
    private static void exibirResultado(String nome, double media) {
        System.out.print(nome + ": " + media);
        
        if (media >= 7) {
            System.out.println(" Aprovado!");
        } 
        else {
            System.out.println(" Reprovado!");
        }
    }

    // Preferi deixar os métodos como private, 
    // ja que n faz sentido chamar esses métodos de fora da classe
    
    // Overload de metodos de soma
    private static int somar(int a, int b) {
        return a + b;
    }
    private static double somar(double a, double b) {
        return a + b;
    }
    private static int somar(int a, int b, int c) {
        return a + b + c;
    }
}
