package aula11;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Digite o valor total do financiamento: ");
        double valorTotal = scanner.nextDouble();

        System.out.print("Digite o valor de entrada: ");
        double entrada = scanner.nextDouble();

        System.out.print("Digite a quantidade de parcelas: ");
        int parcelas = scanner.nextInt();
        
        try{
            Financiamento financiamento = new Financiamento(valorTotal, entrada, parcelas);
            System.out.printf("O valor das parcelas é R$%.2f%n", financiamento.prestacao());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Programa encerrado");
        }
    }
}
