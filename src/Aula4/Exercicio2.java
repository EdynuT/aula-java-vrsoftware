import java.util.Scanner;

public class Exercicio2 {
    public static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Digite o lado do quadrado ou o raio do círculo:");
        double valor = scanner.nextDouble();
        System.out.println("Digite o segundo lado do retângulo (ou 0 para calcular a área do quadrado ou círculo):");
        double valor2 = scanner.nextDouble();

        if (valor2 == 0) {
            System.out.printf("Área: %.2f unidades quadradas%n", calcularArea(valor));
        } 
        else {
            System.out.printf("Área: %.2f unidades quadradas%n", calcularArea(valor, valor2));
        }
    }

    // Eu n consegui pensar em alguma maneira de fazer mais um overload somente para circulo, por causa de conflito de quantidade de argumentos
    // Então eu coloquei a opção de escolher o tipo de cálculo do circulo dentro desse metodo
    public static double calcularArea(double lado) {
        System.out.println("Qual calculo deseja fazer? (1 - Quadrado, 2 - Círculo)");
        int escolha = scanner.nextInt();
        boolean isTrue = true;
        while (isTrue) {
            if (escolha == 1) {
                isTrue = false;
                return lado * lado;
            }
            else if (escolha == 2) {
                isTrue = false;
                return Math.PI * lado * lado;
            }
            else {
                System.out.println("Opção inválida. Digite 1 para Quadrado ou 2 para Círculo");
                escolha = scanner.nextInt();
            }
        }
        return 0;
    }

    // Ainda manti o overload para o calculo do retangulo, ja que ele tem uma quantidade diferente de argumentos
    public static double calcularArea(double lado1, double lado2) {
            return lado1 * lado2;
    }
}
