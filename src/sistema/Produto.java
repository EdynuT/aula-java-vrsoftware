package sistema;

public abstract class Produto {
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected String categoria;

    public Produto(String nome, double preco, int qtd, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = qtd;
        this.categoria = categoria;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double precoNovo) {
        if (precoNovo > 0) {
            this.preco = precoNovo;
        } else {
            System.out.println("O valor do produto deve ser maior do que zero!\n");
        }
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int qtd) {
        this.quantidade -= qtd;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValorEmEstoque() {
        return this.preco * this.quantidade;
    }
}