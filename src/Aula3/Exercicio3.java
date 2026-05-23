import java.util.Random;

// Simulação de vendas diárias e análise de resultados

public class Exercicio3 {
    public static void main(String[] args) {
        Random random = new Random();

        double[] valorDias = new double[30];
        for (int i = 0; i < 30; i++) {
            valorDias[i] = random.nextDouble(100.0);
        }
        double media = 0.0;
        for (int i = 0; i < valorDias.length; i++) {
            media += valorDias[i];
    }
        media /= valorDias.length;
        System.out.println("Média: " + String.format("%.2f", media));

        double maiorValor = valorDias[0];
        for (int i = 1; i < valorDias.length; i++) {
            if (valorDias[i] > maiorValor) {
                maiorValor = valorDias[i];
            }
        }
        double menorValor = valorDias[0];
        for (int i = 1; i < valorDias.length; i++) { 
            if (valorDias[i] < menorValor) {
                menorValor = valorDias[i];
            }
        }
        int diaMaior = 0;
        int diaMenor = 0;
        for (int i = 0; i < valorDias.length; i++) {
            if (valorDias[i] == maiorValor) {
                diaMaior = i + 1;
            }
            if (valorDias[i] == menorValor) {
                diaMenor = i + 1;
            }
        }
        System.out.println("Melhor dia: " + String.format("%d", diaMaior) + " | R$ " + String.format("%.2f", maiorValor));
        System.out.println("Pior dia:   " + String.format("%d", diaMenor) + " | R$ " + String.format("%.2f", menorValor));
    }
}
