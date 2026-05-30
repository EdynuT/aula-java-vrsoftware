import java.util.Scanner;

public class Exercicio1 {
    // Dei uma pesquisada e percebi que se eu declarar o scanner dessa forma, na raiz da classe, ele vai estar disponivel em todo o script sem instanciar dentro de todo metodo
    public static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();

        System.out.printf("Média: %.2f%n", calcularMedia(nota1, nota2, nota3));
        // Ainda estou descobrindo as funções de formatação, essa eu sei que funcionou
    }
    
    /* 
    Usei a entrada ilimitada de argumentos, usei o como python referencia (**args):

    def media(**args):
        soma = 0
        quantidade = 0

        for args in args:
            soma += args
            quantidade += 1
        return soma / quantidade 

        Eu testei no python como escrevi em 'calcularMedia', mas por algum motivo ele n aceita a função len(args) para medir a quantidade de argumentos inseridos
        Por isso criei a variavel 'quantidade'
    */

    public static double calcularMedia(double... notas) {
        double soma = 0;
        // Eu estava descrente, mas no fim resolvi usar esse tipo de "for", ja que serve para qualquer quantidade de argumentos sem adicionar verbosidade
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }
}
