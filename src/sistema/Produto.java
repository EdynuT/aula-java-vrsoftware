package sistema;

public class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto(String nome, double preco, int qtd) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = qtd;
    }

    protected String getNome() {
        return this.nome;
    }

    protected void setNome(String novoNome) {
        this.nome = novoNome;
    }

    protected double getPreco() {
        return this.preco;
    }

    protected void setPreco(double precoNovo) {
        if (precoNovo > 0) {
            this.preco = precoNovo;
        } else {
            System.out.println("O valor do produto deve ser maior do que zero!\n");
        }
    }

    protected int getQuantidade() {
        return this.quantidade;
    }

    protected void setQuantidade(int qtd) {
        this.quantidade -= qtd;
    }

    protected double getValorEmEstoque() {
        return this.preco * this.quantidade;
    }
}