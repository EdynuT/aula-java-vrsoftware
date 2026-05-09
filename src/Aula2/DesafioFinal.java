// Desafio da tarefa de casa do professor

import java.util.Scanner;

public class DesafioFinal{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int numSenha = (int) (Math.random() * 100);
        int tentativa = 1;

        do{
            if (tentativa < 6){
                System.out.print(tentativa + ". ");
                int chute = scanner.nextInt();
                tentativa++;

                if (chute == numSenha){
                    System.out.println("Parabéns! Você acertou em " + (tentativa - 1) + " tentativa(s)!\n");
                    break;
                } 
                else if (chute < numSenha){
                    System.out.println("Muito baixo.\n");
                } 
                else {
                    System.out.println("Muito alto.\n");
                }
            }
            else {
                tentativa++;
                System.out.println("Sistema bloquado!\n");
                break;
            }

        } while (tentativa < 7);
    }
}
