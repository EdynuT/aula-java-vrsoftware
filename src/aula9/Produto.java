package aula9;

public class Produto implements Comparable<String> {
    private String nome;
    private double preco;
    private int    quantidade;
    private String categoria;
    
    public Produto(String nome, double preco, int quantidade, String categoria) {
        this.nome =       nome;
        this.preco =      preco;
        this.quantidade = quantidade;
        this.categoria =  categoria
    }

    public String getNome()               {return nome}
    public void setNome(nome)             {this.nome = nome}

    public double getPreco()              {return preco}
    public void setPreco(preco)           {this.preco = preco}

    public int getQuantidade()            {return quantidade}
    public void setQuantidade(quantidade) {this.quantidade = quantidade}

    public String getCategoria()          {return categoria}
    public void setCategoria(categoria)   {this.categoria = categoria}

    @Override
    public void compareTo() 
}
