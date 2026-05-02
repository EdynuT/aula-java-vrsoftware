import java.util.Scanner;

public class Task1{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        for (int i = 1; i <= numero; i++){
            System.out.println("Contagem: " + i);
        }
        scanner.close();
        System.out.println("Finalizado!");
    }
}