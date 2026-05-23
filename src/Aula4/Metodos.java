import java.util.Scanner;

public class Metodos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //        double media = calcularMedia(2d,3d);
        
        //        imprimirFrase();
        //        System.out.println(soma);
        //        System.out.println(media);
        int soma1 = somar(2, 3);
        int soma2 = somar(3.6, 4.4);
        int soma3 = somar(1, 2, 3);

        double resultado = 0d;

        if (soma1 > 3) {
            double numero1 = calcularMedia(soma1, 10);
            resultado = numero1;
        }
        System.out.println(resultado);
    }

    // Preferi deixar os métodos como private, 
    // ja que n faz sentido chamar esses métodos de fora da classe
    private static double calcularMedia(double a, double b) {
        return (a + b) / 2;
    }

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

    private static void imprimirFrase() {
        System.out.println("Qualquer frase");
    }
}
