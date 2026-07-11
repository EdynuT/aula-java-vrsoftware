package sistema;

public class ProdutoPerecivel extends Produto {
    protected String validade;

    public ProdutoPerecivel(
        String nome, 
        double preco, 
        int quantidade, 
        String categoria,
        String validade
    ) {
        super(nome, preco, quantidade, categoria);
        this.validade = validade;
    }

    public String getValidade() {
        return validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
}
