package aula11;

public class Financiamento {
    double valorTotal, entrada;
    int parcelas;

    public Financiamento(double valorTotal, double entrada, int parcelas) {
        if (entrada < valorTotal * 0.2) {
            throw new RuntimeException("A entrada deve ser ao menos 20% do total");
        }
        if (parcelas < 6) {
             throw new RuntimeException("O número mínimo de parcelas é 6");
        }
        this.valorTotal = valorTotal;
        this.entrada = entrada;
        this.parcelas = parcelas;
    }
    
    public double prestacao() {
        return (valorTotal - entrada) / parcelas;
    }
}
