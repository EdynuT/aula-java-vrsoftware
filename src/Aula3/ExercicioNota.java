import java.util.Scanner;

public class ExercicioNota{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int[] notas = new int[5];
        int soma = 0;

        for (int i = 0; i < notas.length; i++){
            System.out.print("Digite nota " + (i + 1) + ": ");
            notas[i] = scanner.nextInt();
            soma += notas[i];
        }

        double media = (double) soma / notas.length;
        System.out.println("A sua média é: " + media);
    }
}
