import java.util.Scanner;

class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto(String nome, double preco, int qtd) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = qtd;
    }

    public void vender(int qtd) {
        this.quantidade -= qtd;
    }

    public double valorEmEstoque() {
        return this.preco * this.quantidade;
    }
}


public class ProgramacaoOrientadaAObjetos {
    public static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Produto mouse = new Produto("Mouse", 80.0, 10);

        mouse.vender(3);
        System.out.println(mouse.valorEmEstoque()); //560.0
    }

}
