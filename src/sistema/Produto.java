public class Produto {
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

    public static void cadastrarProduto(String nome, double preco, int qtd) {
        Produto produto = new Produto(nome, preco, qtd);
    }
}