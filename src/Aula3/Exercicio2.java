import java.util.Scanner;

// Validação de email

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu email:");
        String email = scanner.nextLine();

        if (email.contains("@") && email.contains(".")) {
            if (email.indexOf("@") < email.lastIndexOf(".")) {
                if (!email.startsWith("@") && !email.endsWith("@"))
                    System.out.println("Email válido!");
                else
                    System.out.println("Email inválido!");
            } 
            else {
                System.out.println("Email inválido!");
            }
        } 
        else {
            System.out.println("Email inválido!");
        }
        scanner.close();
    }
}
