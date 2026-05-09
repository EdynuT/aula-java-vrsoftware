/*
    Aula sobre arrays e strings
*/
import java.util.Scanner;

public class ArraysStrings{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Array ou Strings? (1 - 2): ");
        int escolha = scanner.nextInt();

        boolean isTrue = true;
        while (isTrue){  
            if (escolha == 1){
                arrays();
                isTrue = false;
            }
            else if (escolha == 2){
                strings();
            }
            else {
                System.out.println("Digita certo, animal!\n");
            }
        }
    }

    private static void arrays(){
        int[] numeros = {3, 5, 8, 9};
        String[] nomes = {
            "João", 
            "Maria", 
            "Claudio", 
            "Roberta", 
            "Carlos", 
            "Amanda",
        };

        System.out.print(numeros[0] + ", ");
        System.out.print(numeros[1] + ", ");
        System.out.print(numeros[2] + ", ");
        System.out.println(numeros[3]);

        // Forma otimizada de listar os itens de um array
        for (int i = 0; i < nomes.length; i++){
            if (i < nomes.length - 1){
                System.out.print(nomes[i] + ", ");
            }
            else {
                System.out.println(nomes[i]);
            }
        }
    }

    private static void strings(){
        System.out.println("\nEsse ficou abandonado\n");
    }
}
